package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ResultDao {
    public static final String SQL_SELECT_RATE_BY_STUDENT_AND_THEME = "SELECT rate FROM success WHERE student_id = ? AND theme_id = ?";
    public static final String SQL_SELECT_DATE_BY_STUDENT_AND_THEME = "SELECT date FROM success WHERE student_id = ? AND theme_id = ?";
    public static final String SQL_SELECT_SUCCESS_BY_STUDENT = "SELECT * FROM success WHERE student_id = ?";

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

//    TestHistory getHistoryByStudentAndTheme(int studentId, int themeId) {
//        return new TestHistory();
//    }

//    List<Success> getSuccessByStudent(int studentId) {
//        PreparedStatement preparedStatement = null;
//        LocalDate date = null;
//        Date dateSQL = null;
//        Success success = new Success();
//        List <Success> successes = new LinkedList<>();
//
//        try (Connection connection = ConnectionPool.getConnection()) {
//            connection.prepareStatement(SQL_SELECT_SUCCESS_BY_STUDENT);
//
//            preparedStatement.setInt(1, studentId);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return successes;
//    }


//    boolean setSuccessOfStudent(Student student, Success success) {
//        return true;
//    }

}
