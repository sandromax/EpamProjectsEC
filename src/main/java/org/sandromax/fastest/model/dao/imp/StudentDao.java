package org.sandromax.fastest.model.dao.imp;

import org.sandromax.fastest.domain.user.Student;
import org.sandromax.fastest.domain.result.TestHistory;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation concerning students DAO
 */
public class StudentDao {
    public static final String SQL_INSERT_STUDENT = "INSERT INTO students(student_name, email, pass) VALUES(?, ?, ?)";
    public static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    public static final String SQL_SELECT_STUDENTS_NAME_BY_PASS = "SELECT * FROM students";

    /**
     *
     * @param name of new student
     * @param email of new student
     * @param pass of new student
     *
     * @return true if adding was successful
     */
    boolean addStudent(String name, String email, String pass) {
//        PreparedStatement preparedStatement = null;
//
//        try (Connection connection = ConnectionPool.getConnection()) {
//            connection.prepareStatement(SQL_INSERT_STUDENT);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, email);
//            preparedStatement.setString(1, pass);
//
//            preparedStatement.executeQuery();
//
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return false;
    }

    /**
     *
     * @return list that contains all students in db
     */
    List<Student> getAllStudents() {
        return new LinkedList<>();
    }

    /**
     *
     * @param pass
     * @return
     */
    String getNameByPass(String pass) {
        return "name";
    }

    /**
     *
     * @param pass
     * @return
     */
    String getEmailByPass(String pass) {
        return "email";
    }

    /**
     *
     * @param studentId
     * @param themeId
     * @return
     */
    double getRateByStudentAndTheme(String studentId, String themeId) {
        return 99.9;
    }

    /**
     *
     * @param studentId
     * @param themeId
     * @return
     */
    String getDateByStudentAndTheme(String studentId, String themeId) {
        return "01.01.2018";
    }

    /**
     *
     * @param studentId
     * @param themeId
     * @return
     */
    TestHistory getHistoryByStudentAndTheme(String studentId, String themeId) {
        return new TestHistory();
    }


//    public boolean newStudent(String name, String email, String pass) {
//        PreparedStatement preparedStatement = null;
//
//        try (Connection connection = ConnectionPool.getConnection()) {
//            connection.prepareStatement(SQL_INSERT_STUDENT);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, email);
//            preparedStatement.setString(1, pass);
//
//            preparedStatement.executeQuery();
//
//            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }

    public List<Student> findAllStudents() {
        List<Student> result= new LinkedList<>();
//        Student student;
//
//        try(Connection connection = ConnectionPool.getConnection()) {
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_STUDENTS);
//
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String email = rs.getString(3);
//                String surname = "Churchill";
//                student = new Student(id, name, surname, email);
//                result.add(student);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return result;
    }
}
