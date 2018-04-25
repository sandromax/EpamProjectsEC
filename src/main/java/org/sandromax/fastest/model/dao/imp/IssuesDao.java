package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.domain.test.Theme;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by sandro on 19.04.18.
 */
public class IssuesDao {

    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_INSERT_ISSUE = "INSERT INTO issues(theme_id, question, pos_answer_1, pos_answer_2, pos_answer_3, pos_answer_4, right_answer) VALUES(?, ?, ?, ?, ?, ?, ?);";

    public static boolean createIssue(Issue issue) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ISSUE)) {

            int themeId = issue.getTheme().getIdInDb();
            statement.setInt(1, themeId);
            statement.setString(2, issue.getQuestion());
            statement.setString(3, issue.getVariantAnswers().get(0));
            statement.setString(4, issue.getVariantAnswers().get(1));
            statement.setString(5, issue.getVariantAnswers().get(2));
            statement.setString(6, issue.getVariantAnswers().get(3));
            statement.setString(7, issue.getRightAnswer());

            return statement.execute();
        }
    }


    private static final String SQL_GET_ISSUE_BY_QUESTION = "SELECT * FROM issues WHERE question = ?";

    public static Issue getIssueByQuestion(String question) throws SQLException {
        ResultSet resultSet = null;
        Issue issue = null;
        LinkedList<String> posAnswers = new LinkedList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ISSUE_BY_QUESTION)) {

            statement.setString(1, question);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int themeId = resultSet.getInt(2);
//                String question
                posAnswers.add(resultSet.getString(4));
                posAnswers.add(resultSet.getString(5));
                posAnswers.add(resultSet.getString(6));
                posAnswers.add(resultSet.getString(7));
//                String posAnswer2 = resultSet.getString(5);
//                String posAnswer3 = resultSet.getString(6);
//                String posAnswer4 = resultSet.getString(7);
                String rightAnswer = resultSet.getString(8);

                Theme theme = ThemesDao.getThemeById(themeId);


                issue = new Issue(id, theme, question, rightAnswer, posAnswers);
            }
        }

        return issue;
    }

    private static final String SQL_GET_ISSUE_BY_ID = "SELECT * FROM issues WHERE id = ?";

    public static Issue getIssueById(int id) throws SQLException {
        ResultSet resultSet = null;
        Issue issue = null;
        LinkedList<String> posAnswers = new LinkedList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ISSUE_BY_ID)) {

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
                int themeId = resultSet.getInt(2);
                String question = resultSet.getString(3);
                posAnswers.add(resultSet.getString(4));
                posAnswers.add(resultSet.getString(5));
                posAnswers.add(resultSet.getString(6));
                posAnswers.add(resultSet.getString(7));
//                String posAnswer2 = resultSet.getString(5);
//                String posAnswer3 = resultSet.getString(6);
//                String posAnswer4 = resultSet.getString(7);
                String rightAnswer = resultSet.getString(8);

                Theme theme = ThemesDao.getThemeById(themeId);


                issue = new Issue(id, theme, question, rightAnswer, posAnswers);
            }
        }

        return issue;
    }

    private static final String SQL_DELETE_ISSUE = "DELETE FROM issues WHERE question = ?";

    public static boolean delete(String question) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ISSUE)) {

            statement.setString(1, question);

            return statement.execute();
        }
    }


}
