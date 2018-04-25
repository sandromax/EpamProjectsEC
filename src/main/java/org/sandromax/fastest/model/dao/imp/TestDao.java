package org.sandromax.fastest.model.dao.imp;

import org.apache.log4j.Logger;
import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.domain.testing.IssueDone;
import org.sandromax.fastest.domain.testing.TestResult;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.*;

public class TestDao {

    //  (SELECT id FROM subjects WHERE name = ? )
    //  (SELECT id FROM themes WHERE name = ?)

    private static final String SQL_SELECT_ALL_SUBJECTS = "SELECT * FROM subjects";

    public static List<Subject> getAllSubjects() {
        Logger logger = Logger.getLogger("TestDao");
//        Logger logger = null;
//        try {
//            logger = Logger.getLogger(Class.forName("TestDao"));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        List<Subject> subjects = new LinkedList<>();
        String name, lang;
        int id;

        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBJECTS)) {

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                lang = resultSet.getString("lang");

                Subject subject = new Subject(name, new Locale(lang));
                subject.setId(id);

                subjects.add(subject);
            }

            statement.close();
            logger.fatal("fatal");
            logger.error("error");
            logger.warn("warn");
            logger.info("info: founded subjects: " + subjects.size());
            logger.debug("debug log");
            logger.trace("trace");

            return subjects;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>();
    }


    private static final String SQL_SELECT_THEMES_BY_SUBJECT_NAME = "SELECT themes.id, themes.name, subjects.id, subjects.name, subjects.lang FROM themes JOIN subjects ON themes.subject_id = subjects.id WHERE subjects.name = ?";

    public static List<Theme> getThemesBySubjectName(String subjectName) {
        int themesId, subjectId = 0;
        String name, lang = "";
        List<Theme> themes = new LinkedList<>();
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_THEMES_BY_SUBJECT_NAME)) {

            statement.setString(1, subjectName);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                themesId = resultSet.getInt(1);
                name = resultSet.getString(2);
                subjectId = resultSet.getInt(3);
                subjectName = resultSet.getString(4);
                lang = resultSet.getString(5);

                Subject subject = new Subject(subjectName, new Locale(lang));
                subject.setId(subjectId);
                Theme theme = new Theme(name, subject);
                theme.setIdInDb(themesId);

                themes.add(theme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return themes;
    }

    public void downloadIssues(HashSet<Issue> issues, boolean deleteRepeats) {
        Issue issue = issues.iterator().next();

        checkTheme(issue);
        if(deleteRepeats) {
            HashSet<Issue> issuesNoRepeats = checkQuestions(issues);
            if(issuesNoRepeats.size() > 0)
                insertIssues(issuesNoRepeats);
        } else {
            insertIssues(issues);
        }

    }


    private static final String  SQL_INSERT_ISSUE = "INSERT INTO issues(theme_id, question, pos_answer_1, pos_answer_2, pos_answer_3, pos_answer_4, right_answer)VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ID_FROM_THEMES = "SELECT id FROM themes WHERE name = ?;";

    private boolean insertIssues(HashSet<Issue> issuesHashSet) {

        boolean result = false;
        ResultSet resultSet = null;

        try (Connection connection = ConnectionPool.getConnection();
                Connection additionalConnection = ConnectionPool.getConnection();
                PreparedStatement statementAdditional = additionalConnection.prepareStatement(SQL_SELECT_ID_FROM_THEMES);
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUE)) {

            String themeName = issuesHashSet.iterator().next().getTheme().getName();
            statementAdditional.setString(1, themeName);
            resultSet = statementAdditional.executeQuery();

            int themeId = 0;
            while (resultSet.next()){
                themeId = resultSet.getInt(1);
            }

            int counter = 0;
            for (Issue issue : issuesHashSet) {
                statement.setInt(1, themeId);
                statement.setString(2, issue.getQuestion());
                statement.setString(3, issue.getVariantAnswers().get(0));
                statement.setString(4, issue.getVariantAnswers().get(1));
                statement.setString(5, issue.getVariantAnswers().get(2));
                statement.setString(6, issue.getVariantAnswers().get(3));
                statement.setString(7, issue.getRightAnswer());

                statement.execute();
                counter++;
            }

            System.out.println("Added " + counter + " issues.");
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }


    private static final String SQL_FIND_THEME_BY_NAME = "SELECT * FROM themes WHERE name = ?";

    private boolean isNewTheme(String theme) {

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_THEME_BY_NAME)) {

            ps.setString(1, theme);

            if(ps.execute())
                return false;
            else
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    private static final String SQL_INSERT_NEW_SUBJECT = "INSERT INTO subjects(name, lang) VALUES(?, ?);";
    private static final String SQL_INSERT_NEW_THEME = "INSERT INTO themes(name, subject_id) VALUES(?, ?);";

    private boolean addNewTheme(Theme theme, Subject subject) {

        try(Connection conSubject = ConnectionPool.getConnection();
            Connection conTheme = ConnectionPool.getConnection();
            PreparedStatement psSubject = conSubject.prepareStatement(SQL_INSERT_NEW_SUBJECT);
            PreparedStatement psTheme = conTheme.prepareStatement(SQL_INSERT_NEW_THEME)) {

            psSubject.setString(1, subject.getName());
            psSubject.setString(2, subject.getLang().getLanguage());
            psSubject.executeUpdate();

            psTheme.setString(1, theme.getName());
            psTheme.setInt(2, subject.getId());
            psTheme.executeUpdate();

            System.out.println("Subject " + subject.getName() + " was added.");
            System.out.println("Theme " + theme.getName() + " was added.");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    private void checkTheme(Issue issue) {

        if(isNewTheme(issue.getTheme().getName())) {
            Subject newSubject = issue.getTheme().getSubject();
            Theme newTheme = issue.getTheme();
            addNewTheme(newTheme, newSubject);

            System.out.println("Subject: " + issue.getTheme().getSubject().getName() + " is new.");
            System.out.println("and it was added");
            System.out.println("Theme: " + issue.getTheme() + " is new.");
            System.out.println("and it was added");
        } else
            System.out.println("Theme: " + issue.getTheme() + " is not new.");
    }


    private static final String SQL_FIND_ISSUE_BY_QUESTION = "SELECT * FROM issues WHERE question = ?;";

    private HashSet<Issue> checkQuestions(HashSet<Issue> issues) {

        HashSet<Issue> noRepeatIssues = new HashSet<>();
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ISSUE_BY_QUESTION)) {

            for(Issue issue : issues) {
                statement.setString(1, issue.getQuestion());

                resultSet = statement.executeQuery();
                if(!resultSet.next()) {
                    noRepeatIssues.add(issue);
                }
            }
            System.out.println("Repeats: " + (issues.size() - noRepeatIssues.size()));

            return noRepeatIssues;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return noRepeatIssues;
    }


    private static final String SQL_SELECT_ID_THEMES_BY_NAME = "SELECT id FROM themes WHERE name = ?;";
    private static final String SQL_SELECT_ALL_ISSUES_BY_THEME = "SELECT * FROM issues WHERE theme_id = ?;";

    public static LinkedHashSet<Issue> getIssuesByTheme(Theme theme) {

        LinkedHashSet<Issue> findedIssues = new LinkedHashSet<>();
        ResultSet serviceResultSet = null;
        ResultSet resultSet = null;

        try(Connection serviceConnection = ConnectionPool.getConnection();
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement serviceStatement = serviceConnection.prepareStatement(SQL_SELECT_ID_THEMES_BY_NAME);
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_ISSUES_BY_THEME)) {

            serviceStatement.setString(1, theme.getName());
            serviceResultSet = serviceStatement.executeQuery();
            int themeId = 0;
            while (serviceResultSet.next()) {
                themeId = serviceResultSet.getInt(1);
            }

            if(themeId == 0) {
                System.out.println("Error! Theme wasn't found.");
                return findedIssues;
            } else {
                statement.setString(1, "" + themeId);
                resultSet = statement.executeQuery();

                int id;
                String question, rightAnswer;
                LinkedList<String> variantAnswers = new LinkedList<>();
                while (resultSet.next()) {
                    variantAnswers = new LinkedList<>();

                    id = resultSet.getInt("id");
                    question = resultSet.getString("question");
                    rightAnswer = resultSet.getString("right_answer");
                    variantAnswers.add(resultSet.getString(4));
                    variantAnswers.add(resultSet.getString(5));
                    variantAnswers.add(resultSet.getString(6));
                    variantAnswers.add(resultSet.getString(7));

                    theme.setIdInDb(themeId);

                    Issue issue = new Issue(id, theme, question, rightAnswer, variantAnswers);
                    findedIssues.add(issue);

                    System.out.println("finded in DB " + findedIssues.size() + " issues.");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return findedIssues;
    }

    private static final String SQL_SELECT_ID_STUDENT_BY_NAME = "SELECT id FROM students WHERE name = ?;";
    private static final String SQL_INSERT_TEST_RESULT = "INSERT INTO test_results(theme_id, student_id, date_time, issue_dones_ids, rate) VALUES(?, ?, ?, ?, ?)";
    public static boolean insertTestResult(TestResult testResult) {

        //Getting id of theme if it absent
        Theme theme = testResult.getTheme();
        checkingForEmptyThemeId(theme);


        //Getting id of student if it absent
        Student student = testResult.getStudent();
        checkingForEmptyStudentId(student);


        //  Getting id of issueDone if it absent
        List<IssueDone> issueDones = testResult.getIssueDones();
        checkingForEmptyIssueDoneId(issueDones);

        String issueDoneIds = testResult.getIssueDonesDbFormat();

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_TEST_RESULT)) {

            statement.setInt(1, theme.getIdInDb());
            statement.setInt(2, student.getIdInDb());
            statement.setString(3, testResult.getTimeMoment().toString());
            statement.setString(4, issueDoneIds);
            statement.setDouble(5, testResult.getRate());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private static void checkingForEmptyThemeId(Theme theme) {
        if(theme.getIdInDb() == 0) {
            ResultSet resultSet = null;
            try(Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ID_THEMES_BY_NAME)) {

                statement.setString(1, theme.getName());

                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    theme.setIdInDb(resultSet.getInt(1));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void checkingForEmptyStudentId(Student student) {
        if(student.getIdInDb() == 0) {
            ResultSet resultSet = null;
            try(Connection connection = ConnectionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ID_STUDENT_BY_NAME)) {

                statement.setString(1, student.getName());

                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    student.setIdInDb(resultSet.getInt(1));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Method check list of IssueDone by idInDb field
     * If field is empty than called 'setIssueDoneId' method
     * @param issueDones
     */
    private static void checkingForEmptyIssueDoneId(List<IssueDone> issueDones) {
        for(IssueDone issueDone : issueDones) {
            if(issueDone.getIdInDb() == 0)
                setIssueDoneId(issueDone);
        }
    }

    /**
     * Method set id it to the field
     * @param issueDone
     */
    private static void setIssueDoneId(IssueDone issueDone) {
        int issueId = issueDone.getIssue().getIdInDb();
        int studentId = issueDone.getStudent().getIdInDb();
        String date = issueDone.getDate().toString();

        int issueDoneId = getIdOfIssueDoneByIssueIdAndStudentIdAndDate(issueId, studentId, date);
        issueDone.setIdInDb(issueDoneId);
    }

    private static final String SQL_SELECT_ISSUEDONE_ID_BY_ISSUE_ID_STUDENT_ID_DATE = "SELECT id FROM issue_dones WHERE issue_id = ? AND student_id = ? AND issue_dones.date = ?;\n";
    private static int getIdOfIssueDoneByIssueIdAndStudentIdAndDate(int issueId, int studentId, String date) {
        ResultSet resultSet = null;
        int result = 0;
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ISSUEDONE_ID_BY_ISSUE_ID_STUDENT_ID_DATE)) {

            statement.setInt(1, issueId);
            statement.setInt(2, studentId);
            statement.setString(3, date);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    private static String joinForDb(List<String> list) {

        StringJoiner joiner = new StringJoiner("^");

        for(String str : list) {
            joiner.add(str.toString());
        }

        String result = joiner.toString();

        return result;
    }

    private static String[] splitFromDb(String string) {
        String[] splited = string.split("\\^");

        return splited;
    }

    private static final String SQL_INSERT_ISSUEDONE = "INSERT INTO issue_dones(issue_id, answer, is_positive, student_id, date) VALUES(?, ?, ?, ?, ?);";
    public static boolean insertIssueDone(IssueDone issueDone) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUEDONE)) {
            int issueId = issueDone.getIssue().getIdInDb();
            String answer = issueDone.getAnswer();
            boolean isPositive = issueDone.getPositive();
            Student student = issueDone.getStudent();
            checkingForEmptyStudentId(student);
            int studentId = student.getIdInDb();
            String date = issueDone.getDate().toString();

            statement.setInt(1, issueId);
            statement.setString(2, answer);
            statement.setBoolean(3, isPositive);
            statement.setInt(4, studentId);
            statement.setString(5, date);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean insertIssueDones(List<IssueDone> issueDones) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUEDONE)) {
            int issueId;
            String answer;
            boolean isPositive;
            Student student;
            int studentId;
            String date;

            for(IssueDone issueDone : issueDones) {
                issueId = issueDone.getIssue().getIdInDb();
                answer = issueDone.getAnswer();
                isPositive = issueDone.getPositive();
                student = issueDone.getStudent();
                checkingForEmptyStudentId(student);
                studentId = student.getIdInDb();
                date = issueDone.getDate().toString();

                statement.setInt(1, issueId);
                statement.setString(2, answer);
                statement.setBoolean(3, isPositive);
                statement.setInt(4, studentId);
                statement.setString(5, date);

                statement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
