package org.sandromax.fastest.domain.testing;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.imp.TestDao;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Random;

public class TestProvider {
    //  містить набір питань даного тесту
    private LinkedList<Issue> issues = new LinkedList<>();
    //  тестований студент
    private Student student;

    //  результат проходження даного тесту
    private TestResult testResult;

    //  всього питань в даному тесті
    private int numberOfIssues;
    //  поточне питання
    private int currentIssueIndex;
    //  секунд дано на проходження тесту
    private int estimateSeconds = 900;
    //  екземпляр поточного питання
    private Issue currentIssue;

    //  відповідь
    private String answer;

    public Issue getCurrentIssue() {
        return currentIssue;
    }

    /**
     *  Notice student,
     *  download issues to variable currentIssue,
     *  preparing list of issues,
     *  initialize TestResult class
     *
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
     * @param answer answer to the previous issue
     */
    public void next(String answer) {
        if(currentIssueIndex < issues.size()) {
            IssueDone issueDone = new IssueDone(currentIssue, answer, student);
            issueDone.evaluateIssue();

            testResult.addIssueDone(issueDone);

            currentIssueIndex++;
            currentIssue = issues.get(currentIssueIndex);
        } else
            end();
    }

    /**
     * End of the testing
     */
    private void end() {
        testResult.evaluateIssues();

        TestDao.insertTestResult(testResult);
    }

    /**
     * Дле перемішування вмісту колекції
     * To shuffle collection
     *
     * @param issues
     * @return  shuffled collection
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
            issues.removeLast();
    }

    private void timerStart() {
        System.out.println("timerStart");
    }
}
