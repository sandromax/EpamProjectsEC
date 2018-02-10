package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    public static final String SQL_INSERT_STUDENT = "INSERT INTO students(name, surname, email, pass) VALUES(?, ?, ?, ?)";
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String SQL_SELECT_STUDENTS_EMAIL_BY_PASS = "SELECT email FROM students WHERE pass = '?'";

    boolean addStudent(String name, String surname, String email, String pass) {
        PreparedStatement preparedStatement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            connection.prepareStatement(SQL_INSERT_STUDENT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, pass);

            preparedStatement.executeQuery();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Student> getAllStudents() {
        List<Student> resultList = new LinkedList<>();
        String name, surname, email;
        int id;

        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_STUDENTS);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString(2);
                surname = resultSet.getString(3);
                email = resultSet.getString("email");

                Student student = new Student(id, name, surname, email);

                resultList.add(student);
            }

            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>();
    }

    String getEmailByPass(String pass) {
        PreparedStatement preparedStatement = null;
        String email = "";

        try (Connection connection = ConnectionPool.getConnection()) {
            connection.prepareStatement(SQL_SELECT_STUDENTS_EMAIL_BY_PASS);
            preparedStatement.setString(1, pass);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                email = resultSet.getString("email");
            }

            return email;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new String();
    }
}
