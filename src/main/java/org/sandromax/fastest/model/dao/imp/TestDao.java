package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class TestDao {

    private static final String SQL_SELECT_ALL_SUBJECTS = "SELECT * FROM subjects";
    private static final String SQL_SELECT_THEMES_BY_SUBJECT_NAME = "SELECT themes.id, themes.name, subjects.id, subjects.name, subjects.lang FROM themes JOIN subjects ON themes.subject_id = subjects.id WHERE subjects.name = ?";

    //  (SELECT id FROM subjects WHERE name = ? )
    //  (SELECT id FROM themes WHERE name = ?)

    /**
     * analog - getAll
     * @return list  of all signed student
     */
    public List<Subject> getAllSubjects() {
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
            return subjects;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>();
    }

    public List<Theme> getThemesBySubjectName(String subjectName) {
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

    public boolean insertIssues(HashSet<Issue> issuesHashSet) {
        boolean result = false;
        int counter = 0;

        try (Connection connection = ConnectionPool.getConnection();
                Connection additionalConnection = ConnectionPool.getConnection();
                PreparedStatement statementAdditional = additionalConnection.prepareStatement(SQL_SELECT_ID_FROM_THEMES);
                PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUE)) {

//            PreparedStatement statementAdditional = additionalConnection.prepareStatement(SQL_SELECT_ID_FROM_THEMES);

            ResultSet resultSet;
            int themeId = 0;
            String themeName = issuesHashSet.iterator().next().getTheme().getName();
            statementAdditional.setString(1, themeName);
            resultSet = statementAdditional.executeQuery();
            while (resultSet.next()){
                themeId = resultSet.getInt(1);
            }

//            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUE);

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
        }
        return result;
    }

    private static final String SQL_FIND_THEME_BY_NAME = "SELECT * FROM themes WHERE name = ?";

    private boolean isNewTheme(String theme) {
        try(Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_THEME_BY_NAME);
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
            Connection conTheme = ConnectionPool.getConnection()) {

            PreparedStatement psSubject = conSubject.prepareStatement(SQL_INSERT_NEW_SUBJECT);
            PreparedStatement psTheme = conTheme.prepareStatement(SQL_INSERT_NEW_THEME);

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

    private static final String SQL_FIND_THEME = "SELECT * FROM themes WHERE name = ?;";

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

    public static final String SQL_FIND_ISSUE_BY_QUESTION = "SELECT * FROM issues WHERE question = ?;";

    private HashSet<Issue> checkQuestions(HashSet<Issue> issues) {
        HashSet<Issue> noRepeatIssues = new HashSet<>();

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ISSUE_BY_QUESTION)) {

            for(Issue issue : issues) {
                statement.setString(1, issue.getQuestion());

                ResultSet resultSet = statement.executeQuery();
                if(!resultSet.next()) {
                    noRepeatIssues.add(issue);
                }
            }
            System.out.println("Repeats: " + (issues.size() - noRepeatIssues.size()));
            return noRepeatIssues;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noRepeatIssues;
    }

    private static final String SQL_SELECT_ID_THEMES_BY_NAME = "SELECT id FROM themes WHERE name = ?;";
    private static final String SQL_SELECT_ALL_ISSUES_BY_THEME = "SELECT * FROM issues WHERE theme_id = ?;";
    public HashSet<Issue> getIssuesByTheme(String themeName) {
        HashSet<Issue> findedIssues = new HashSet<>();

        return findedIssues;
    }
}
