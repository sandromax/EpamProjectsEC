package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.user.Admin;
import org.sandromax.fastest.model.dao.connection.impl.ConnectionPool;

import java.sql.*;
import java.util.logging.Logger;

/**
 * Created by sandro on 17.04.18.
 */
public class AdminsDao {

    static Logger logger = Logger.getLogger(AdminsDao.class.getName());

    private static final String SQL_NEW_ADMIN = "INSERT INTO admins(name, email, pass) VALUES(?, ?, ?);";

    public static boolean createAdmin(String name, String email, String pass) throws SQLException {

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_NEW_ADMIN)) {

            int logRounds = 12;
            String passHashed = BCrypt.hashpw(pass, BCrypt.gensalt(logRounds));

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, passHashed);

            statement.execute();
        }
        return true;
    }

    private static final String SQL_GET_ADMIN = "SELECT * FROM admins WHERE email = ?;";

    public static Admin getAdmin(String email, String pass) throws SQLException {
        ResultSet resultSet = null;
        Admin admin = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ADMIN)) {
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idDB = resultSet.getInt(1);
                String nameDb = resultSet.getString(2);
                String emailDb = resultSet.getString(3);
                String passDb = resultSet.getString(4);

                if(BCrypt.checkpw(pass, passDb)) {
                    admin = new Admin(idDB, nameDb, emailDb);
                }
            }
        }
        return admin;
    }

    private static final String SQL_GET_ADMIN_BY_EMAIL = "SELECT id, name, email FROM admins WHERE email = ?;";

    public static Admin getAdminByEmail(String email) throws SQLException{
        ResultSet resultSet = null;
        Admin admin = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_ADMIN_BY_EMAIL)) {

            statement.setString(1, email);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idDB = resultSet.getInt(1);
                String nameDb = resultSet.getString(2);
                String emailDb = resultSet.getString(3);

                admin = new Admin(idDB, nameDb, emailDb);
            }
        }
        return admin;
    }

    public static boolean editAdmin(String name, String email, String pass) throws SQLException {

        return true;
    }

    private static final String SQL_DELETE_ADMIN = "DELETE FROM admins WHERE email = ?;";

    public static boolean deleteAdmin(String email) throws SQLException {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ADMIN)) {

            statement.setString(1, email);

            return statement.execute();
        }
    }
}
