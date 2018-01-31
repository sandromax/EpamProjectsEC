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
    public static final String SQL_SELECT_THEMES_BY_SUBJECT_NAME = "SELECT themes.id, themes.name, subjects.name, themes.lang FROM themes JOIN subjects ON themes.subject_id = subjects.id WHERE subjects.name = ?";


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

    List<Theme> getThemesBySubject(String subjectName) {
        PreparedStatement preparedStatement = null;
        int id = 0;
        String name, lang = "";
//        Subject subject

        try(Connection connection = ConnectionPool.getConnection()) {
            connection.prepareStatement(SQL_SELECT_THEMES_BY_SUBJECT_NAME);
            preparedStatement.setString(1, subjectName);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
//                subjectName = rs.getString(3);
                lang = rs.getString(4);

//                Theme theme = new Theme(id, name, new Subject(su))
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    List<Issue> getIssuesByThemeAndLang(int themeId, String lang) {
        return new LinkedList<>();
    }

    boolean addIssues(LinkedList<Issue> issues) {
        return true;
    }
}
