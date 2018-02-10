package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class TestDao {

    public static final String SQL_SELECT_ALL_SUBJECTS = "SELECT * FROM subjects";
    public static final String SQL_SELECT_THEMES_BY_SUBJECT_NAME = "SELECT themes.id, themes.name, subjects.id, subjects.name, themes.lang FROM themes JOIN subjects ON themes.subject_id = subjects.id WHERE subjects.name = ?";
    public static final String SQL_SELECT_THEMES_BY_SQL = "SELECT themes.id, themes.name, subjects.id, subjects.name, themes.lang FROM themes JOIN subjects ON themes.subject_id = subjects.id WHERE subjects.name = 'SQL'";


    /**
     * analog - getAll
     * @return list  of all signed student
     */
    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new LinkedList<>();
        String name, lang;
        int id;

        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SUBJECTS);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                lang = resultSet.getString("lang");

                Subject subject = new Subject(id, name, new Locale(lang));

                subjects.add(subject);
            }

            statement.close();
            return subjects;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>();
    }

    public List<Theme> getThemesBySubject(String subjectName) {
//        PreparedStatement preparedStatement = null;
        int themesId, subjectId = 0;
        String name, lang = "";
        List<Theme> themes = new LinkedList<>();

        try(Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_THEMES_BY_SUBJECT_NAME);
            preparedStatement.setString(1, subjectName);
//
            ResultSet rs = preparedStatement.executeQuery();

//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(SQL_SELECT_THEMES_BY_SQL);

            while (rs.next()) {
                themesId = rs.getInt(1);
                name = rs.getString(2);
                subjectId = rs.getInt(3);
                subjectName = rs.getString(4);
                lang = rs.getString(5);

                Theme theme = new Theme(themesId, name, new Subject(subjectId, subjectName, new Locale(lang)), new Locale(lang));

                themes.add(theme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themes;
    }

    List<Issue> getIssuesByThemeAndLang(int themeId, String lang) {
        return new LinkedList<>();
    }

    boolean addIssues(LinkedList<Issue> issues) {
        return true;
    }
}
