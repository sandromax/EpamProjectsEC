package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by sandro on 17.04.18.
 */
public class StudentsDao {

    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_INSERT_STUDENT = "INSERT INTO students (name, email, pass) VALUES(?, ?, ?)";
    public static boolean createStudent(String name, String email, String pass) throws SQLException {
        String passHash = BCrypt.hashpw(pass, BCrypt.gensalt(13));

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_STUDENT)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, passHash);

            return statement.execute();
        }
    }

    private static final String SQL_SELECT_STUDENT = "SELECT * FROM students WHERE email = ?;";
    public static Student getStudent(String email, String pass) throws SQLException {
        ResultSet resultSet = null;
        Student student = null;

        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_STUDENT)) {
            statement.setString(1, email);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idDB = resultSet.getInt(1);
                String nameDb = resultSet.getString(2);
                String emailDb = resultSet.getString(3);
                String passDb = resultSet.getString(4);

                if(BCrypt.checkpw(pass, passDb)) {
                    student = new Student(idDB, nameDb, emailDb);
                }
            }
        }
        return student;
    }

    private static final String SQL_GET_STUDENT_BY_EMAIL = "SELECT id, name, email FROM students WHERE email = ?;";

    public static Student getStudentByEmail(String email) throws SQLException{
        ResultSet resultSet = null;
        Student student = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_STUDENT_BY_EMAIL)) {

            statement.setString(1, email);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
//                String emailDb = resultSet.getString(3);

                student = new Student(id, name, email);
            }
        }
        return student;
    }


    private static final String SQL_GET_STUDENT_BY_NAME = "SELECT id, name, email FROM students WHERE name = ?;";

    public static Student getStudentByName(String name) throws SQLException{
        ResultSet resultSet = null;
        Student student = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_STUDENT_BY_NAME)) {

            statement.setString(1, name);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
//                String nameDb = resultSet.getString(2);
                String email = resultSet.getString(3);

                student = new Student(id, name, email);
            }
        }
        return student;
    }

//    public static final String SQL_UPDATE_STUDENT = "UPDATE admins SET pass =  WHERE email = ?";
//    public static boolean updateStudent(Student student) throws SQLException {
//        try(Connection connection = ConnectionPool.getConnection();
//            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_STUDENT)) {
//
//        }
//
//        return true;
//    }

    private static final String SQL_DELETE_STUDENT = "DELETE FROM students WHERE email = ?;";

    public static boolean deleteStudent(String email) throws SQLException {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_STUDENT)) {

            statement.setString(1, email);

            return statement.execute();
        }
    }

}
