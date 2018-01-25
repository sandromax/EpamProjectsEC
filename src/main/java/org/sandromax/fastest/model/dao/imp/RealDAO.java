package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.result.Success;
import org.sandromax.fastest.domain.result.TestHistory;
import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class RealDAO {
    public static final String SQL_INSERT_STUDENT = "INSERT INTO students(name, surname, email, pass) VALUES(?, ?, ?, ?)";
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String SQL_SELECT_STUDENTS_EMAIL_BY_PASS = "SELECT email FROM students WHERE pass = '?'";
    public static final String SQL_SELECT_RATE_BY_STUDENT_AND_THEME = "SELECT rate FROM success WHERE student_id = ? AND theme_id = ?";
    public static final String SQL_SELECT_DATE_BY_STUDENT_AND_THEME = "SELECT date FROM success WHERE student_id = ? AND theme_id = ?";
    public static final String SQL_SELECT_SUCCESS_BY_STUDENT = "SELECT * FROM success WHERE student_id = ?";
    public static final String SQL_SELECT_ALL_SUBJECTS = "SELECT * FROM subjects";
    public static final String SQL_SELECT_THEMES_BY_SUBJECT_NAME = "SELECT themes.id, themes.name, subjects.name, themes.lang FROM themes JOIN subjects ON themes.subject_id = subjects.id WHERE subjects.name = ?";


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

            return resultList;
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
        PreparedStatement preparedStatement = null;
        Double rate = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            connection.prepareStatement(SQL_SELECT_RATE_BY_STUDENT_AND_THEME);

            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, themeId);

            ResultSet resultSet = preparedStatement.executeQuery();

            rate = resultSet.getDouble("rate");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rate;
    }

    LocalDate getDateByStudentAndTheme(int studentId, int themeId) {
        PreparedStatement preparedStatement = null;
        LocalDate date = null;
        Date dateSQL = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            connection.prepareStatement(SQL_SELECT_DATE_BY_STUDENT_AND_THEME);

            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, themeId);

            ResultSet resultSet = preparedStatement.executeQuery();

            dateSQL = resultSet.getDate("date");
            date = dateSQL.toLocalDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return date;
    }

    TestHistory getHistoryByStudentAndTheme(int studentId, int themeId) {
        return new TestHistory();
    }

    List<Success> getSuccessByStudent(int studentId) {
        PreparedStatement preparedStatement = null;
        LocalDate date = null;
        Date dateSQL = null;
        Success success = new Success();
        List <Success> successes = new LinkedList<>();

        try (Connection connection = ConnectionPool.getConnection()) {
            connection.prepareStatement(SQL_SELECT_SUCCESS_BY_STUDENT);

            preparedStatement.setInt(1, studentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return successes;
    }

    List<Subject> getAllSubjects() {
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

    boolean setSuccessOfStudent(Student student, Success success) {
        return true;
    }

    boolean addIssues(LinkedList<Issue> issues) {
        return true;
    }
}
