package org.sandromax.fastest.domain.testing;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.imp.TestDao;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Random;

public class TestProvider {
    private LinkedList<Issue> issues = new LinkedList<>();          //  містить набір питань даного тесту
    private Issue currentIssue;         //  екземпляр поточного питання

    private Student student;            //  тестований студент
    private TestResult testResult;          //  результат проходження даного тесту


    private int numberOfIssues;         //  всього питань в даному тесті
    private int currentIssueIndex;          //  поточне питання
    private int estimateSeconds = 900;          //  секунд дано на проходження тесту

    private String answer;          //  відповідь
    private Boolean isEnd;          //  флаг про закінчення


    public TestProvider() {
    }

    public Issue getCurrentIssue() {
        return currentIssue;
    }

    /**
     * Notice student,
     * download issues to variable currentIssue,
     * preparing list of issues,
     * initialize TestResult class
     */
    public void init(Student student, Theme theme, int issueCapacity) {
        this.student = student;
        issues = new LinkedList<>(TestDao.getIssuesByTheme(theme));

        numberOfIssues = issueCapacity;
        shuffle(issues);
        cut(issues, numberOfIssues);

        testResult = new TestResult(theme, student);
    }

    /**
     * To start test, timer and get first issue
     */
    public void start() {
        testResult.setTimeMoment(LocalDateTime.now());

        currentIssueIndex = 0;
        currentIssue = issues.get(currentIssueIndex);

        timerStart();
    }

    /**
     * Switch to the next issue
     *
     * @param answer answer to the previous issue
     */
    public boolean next(String answer) {
        IssueDone issueDone = new IssueDone(currentIssue, answer, student);
        issueDone.evaluateIssue();      //Exception
//            java.lang.NullPointerException
//            org.sandromax.fastest.domain.testing.IssueDone.evaluateIssue(IssueDone.java:79)
//            org.sandromax.fastest.domain.testing.TestProvider.next(TestProvider.java:77)
//            org.sandromax.fastest.controller.command.impl.CommandNextQuestion.execute(CommandNextQuestion.java:35)

        testResult.addIssueDone(issueDone);

        currentIssueIndex++;
        if (currentIssueIndex == 4)
            System.out.println(currentIssueIndex);

        if (currentIssueIndex < issues.size()) {
            currentIssue = issues.get(currentIssueIndex);

            return true;
        } else
            return false;
    }

    /**
     * End of the testing
     */
    public void end() {
        testResult.evaluateIssues();
        System.out.println(testResult.getIssueDones().size() + " - size of issueDones");
        System.out.println(numberOfIssues + " - size of issueDones");

        TestDao.insertIssueDones(testResult.getIssueDones());
        TestDao.insertTestResult(testResult);

        isEnd = true;
    }

    /**
     * Дле перемішування вмісту колекції
     * To shuffle collection
     *
     * @param issues
     * @return shuffled collection
     */
    public void shuffle(LinkedList<Issue> issues) {
        LinkedList<Issue> newList = new LinkedList<>();
        Random random = new Random();
        int size = issues.size();

        for (int i = 0; i < size; i++) {
            int index = random.nextInt(issues.size());
            newList.add(issues.get(index));
            issues.remove(index);
        }

        issues.addAll(newList);
    }

    /**
     * Зменшення колекції
     * Cutting collection to capacity size
     *
     * @param issues
     * @param capacity
     * @return
     */
    public void cut(LinkedList<Issue> issues, int capacity) {
        while (issues.size() != capacity)
            issues.removeLast();    //java.util.NoSuchElementException
    }

    private void timerStart() {
        System.out.println("timerStart");
    }

    /**
     * Getters
     */
    public Student getStudent() {
        return student;
    }

    public int getNumberOfIssues() {
        return numberOfIssues;
    }

    public int getCurrentIssueIndex() {
        return currentIssueIndex;
    }

    public int getEstimateSeconds() {
        return estimateSeconds;
    }

    public Boolean getEnd() {
        return isEnd;
    }

    public TestResult getTestResult() {
        return testResult;
    }
}
