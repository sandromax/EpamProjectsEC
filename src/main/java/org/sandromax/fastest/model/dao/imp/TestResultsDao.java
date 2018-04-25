package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.testing.TestResult;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by sandro on 20.04.18.
 */
public class TestResultsDao{

    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_INSERT_TEST_RESULTS = "INSERT INTO test_results(theme_id, student_id, date_time, issue_dones_ids, rate) VALUES(?, ?, ?, ?, ?)";

    public static boolean createTestResult(TestResult testResult) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_TEST_RESULTS)) {

            int themeId = testResult.getTheme().getIdInDb();
            statement.setInt(1, themeId);

            int studentId = testResult.getStudent().getIdInDb();
            statement.setInt(2, studentId);

            String dateTime = testResult.getTimeMoment().toString();
            statement.setString(3, dateTime);

            String issue_dones_ids = testResult.getIssueDonesDbFormat();
            statement.setString(4, issue_dones_ids);

            double rate = testResult.getRate();
            statement.setDouble(5, rate);

            return statement.execute();
        }
    }


    private static final String SQL_GET_TEST_RESULT_BY_THEME_AND_STUDENT = "SELECT * FROM test_results WHERE theme_id = ? AND student_id = ?;";

    public static TestResult getTestResult(String themeName, String studentName ) throws SQLException {
        ResultSet resultSet = null;
        TestResult testResult = null;

        int studentId;
        int themeId;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_TEST_RESULT_BY_THEME_AND_STUDENT)) {

            themeId = ThemesDao.getThemeByName(themeName).getIdInDb();
            studentId = StudentsDao.getStudentByName(studentName).getIdInDb();

            statement.setInt(1, themeId);
            statement.setInt(2, studentId);

            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testResult;
    }

    private static final String SQL_DELETE_TEST_RESULT = "";

    public static boolean delete(String themeName, String studentName) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TEST_RESULT)) {

            return statement.execute();
        }

    }

}
