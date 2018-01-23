package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.*;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class RealDAO {
    public static final String SQL_INSERT_STUDENT = "INSERT INTO students(name, surname, email, pass) VALUES(?, ?, ?, ?)";
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String SQL_SELECT_STUDENTS_EMAIL_BY_PASS = "SELECT email FROM students WHERE pass = '?'";
    public static final String SQL_SELECT_RATE_BY_STUDENT_AND_NAME = "SELECT rate FROM success WHERE student_id = ? AND theme_id = ?";


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

    List<Student> getAllStudent() {
        List<Student> resultList = new LinkedList<>();
        String name, surname, email;
        int id;

        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_STUDENTS);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
                email = resultSet.getString("email");

                Student student = new Student(id, name, surname, email);

                resultList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new LinkedList<>();
    }

//    String getNameByPass() {
//        try(Connection connection = ConnectionPool.getConnection()) {
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return new String();
//    }

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

    Double getRateByStudentAndTheme(int studentId, int themeId) {
        return 0.0;
    }

    LocalDate getDateByStudentAndTheme(int studentId, int themeId) {
        return LocalDate.now();
    }

    TestHistory getHistoryByStudentAndTheme(int studentId, int themeId) {
        return new TestHistory();
    }

    Success getSuccessByStudent(int studentId) {
        return new Success();
    }

    List<Subject> getAllSubjects() {
        return new LinkedList<>();
    }

    List<Theme> getThemesBySubject(int subjectId) {
        return new LinkedList<>();
    }

    List<Issue> getIssuesByThemeAndLang(int themeId, String lang) {
        return new LinkedList<>();
    }

    boolean setSuccessOfStudent(Student student, Success success) {
        return true;
    }
}
