package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.testing.IssueDone;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by sandro on 19.04.18.
 */
public class IssueDoneDao {

    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_INSERT_ISSUE_DONE = "INSERT INTO issue_dones(issue_id, answer, is_positive, student_id, date) VALUES(?, ?, ?, ?, ?);";

    public static boolean createIssueDone(IssueDone issueDone) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUE_DONE)) {

            int issueId = issueDone.getIssue().getIdInDb();
            statement.setInt(1, issueId);
            statement.setString(2, issueDone.getAnswer());
            statement.setBoolean(3, issueDone.getPositive());
            int studentId = issueDone.getStudent().getIdInDb();
            statement.setInt(4, studentId);
            String date = issueDone.getDate().toString();
            statement.setString(5, date);

            return statement.execute();
        }
    }


    private static final String SQL_GET_ISSUE_DONE_BY_ID = "SELECT * FROM issue_dones WHERE ";

//    public static Object get(String) throws SQLException {
//        ResultSet resultSet = null;
//        Object object = null;
//
//        try (Connection connection = ConnectionPool.getConnection();
//             PreparedStatement statement = connection.prepareStatement()) {
//
//        }
//    }

    private static final String SQL_DELETE_ISSUE_DONE_BY_ID = "DELETE FROM issue_dones WHERE id = ?;";

    public static boolean deleteIssueDone(int id) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ISSUE_DONE_BY_ID)) {

            statement.setInt(1, id);

            return statement.execute();
        }
    }


}
