package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    public static final String SQL_INSERT_STUDENT = "INSERT INTO students(name, email, pass) VALUES(?, ?, ?)";
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String SQL_SELECT_STUDENTS_EMAIL_BY_PASS = "SELECT email FROM students WHERE pass = ?";
    public static final String SQL_SELECT_PASS_BY_EMAIL = "SELECT pass FROM students WHERE email = ?";
    public static final String SQL_SELECT_NAME_BY_EMAIL = "SELECT name FROM students WHERE email = ?";

    //  OK
    public static boolean addStudent(String name, String email, String pass) {
        String passHash = BCrypt.hashpw(pass, BCrypt.gensalt(12));

        try(Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_STUDENT);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, passHash);

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //  OK
    public static String getPassByEmail(String email) {
        String pass = "";

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_PASS_BY_EMAIL);
            ps.setString(1, email);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                pass = resultSet.getString("pass");
            }

            return pass;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pass;
    }

    public static String getNameByEmail(String email) {
        String name = "";

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_NAME_BY_EMAIL);
            ps.setString(1, email);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                name = resultSet.getString("name");
            }

            return name;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
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

    //  OK
    //  not secure
    public static String getEmailByPass(String pass) {
        String email = "";

//        String passHash = BCrypt.hashpw(pass, BCrypt.gensalt(12));

        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_STUDENTS_EMAIL_BY_PASS);
            preparedStatement.setString(1, pass);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                email = resultSet.getString("email");
            }

            return email;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return email;
    }
}
