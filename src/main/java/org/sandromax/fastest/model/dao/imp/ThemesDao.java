package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by sandro on 18.04.18.
 */
public class ThemesDao {


    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_INSERT_THEME = "INSERT INTO themes(name, subject_id) VALUES (?, ?);";

    public static boolean createTheme(String themeName, String subjectName) throws SQLException {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_THEME)) {

            Subject subject = SubjectsDao.getSubjectByName(subjectName);
            if(subject == null) {
                return false;
            }
            else {
                statement.setString(1, themeName);
                statement.setInt(2, subject.getId());

                return statement.execute();
            }
        }
    }


    private static final String SQL_GET_THEME_BY_NAME = "SELECT * FROM themes WHERE name = ?;";

    public static Theme getThemeByName(String name) throws SQLException{
        ResultSet resultSet = null;
        Theme theme = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_THEME_BY_NAME)) {

            statement.setString(1, name);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int subjectId = resultSet.getInt(3);

                Subject subject = SubjectsDao.getSubjectById(subjectId);

                theme = new Theme(id, name, subject);
            }
        }
        return theme;
    }


    private static final String SQL_GET_THEME_BY_ID = "SELECT * FROM themes WHERE id = ?;";

    public static Theme getThemeById(int id) throws SQLException{
        ResultSet resultSet = null;
        Theme theme = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_THEME_BY_ID)) {

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int subjectId = resultSet.getInt(3);

                Subject subject = SubjectsDao.getSubjectById(subjectId);

                theme = new Theme(id, name, subject);
            }
        }
        return theme;
    }

    private static final String SQL_DELETE_THEME = "DELETE FROM themes WHERE name = ?;";

    public static boolean deleteTheme(String name) throws SQLException {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_THEME)) {

            statement.setString(1, name);
            return statement.execute();
        }
    }

}
