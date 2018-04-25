package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by sandro on 18.04.18.
 */
public class SubjectsDao {

    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_INSERT_SUBJECT = "INSERT INTO subjects(name, lang) VALUES(?, ?);";
    public static boolean creatSubject(String name, String lang) throws SQLException {

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SUBJECT)) {
            statement.setString(1, name);
            statement.setString(2, lang);

            return statement.execute();
        }
    }


    private static final String SQL_SELECT_SUBJECT_BY_NAME = "SELECT * FROM subjects WHERE name = ?;";
    public static Subject getSubjectByName(String name) throws SQLException {
        ResultSet resultSet = null;
        Subject subject = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_SUBJECT_BY_NAME)) {

            statement.setString(1, name);
            statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nameDb = resultSet.getString(2);
                String lang = resultSet.getString(3);

                subject = new Subject(id, name, new Locale(lang));
            }

        }
        return subject;
    }

    private static final String SQL_SELECT_SUBJECT_BY_ID = "SELECT * FROM subjects WHERE id = ?;";
    public static Subject getSubjectById(int id) throws SQLException {
        ResultSet resultSet = null;
        Subject subject = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_SUBJECT_BY_ID)) {

            statement.setInt(1, id);
            statement.executeQuery();

            while (resultSet.next()) {
                String nameDb = resultSet.getString(2);
                String lang = resultSet.getString(3);

                subject = new Subject(id, nameDb, new Locale(lang));
            }

        }
        return subject;
    }


    private static final String SQL_DELETE_SUBJECT = "DELETE FROM subjects WHERE name = ?";

    public static boolean deleteSubject(String name) throws SQLException {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_SUBJECT)) {

            statement.setString(1, name);

            return statement.execute();
        }
}

}
