package week06.JDBC;

import java.sql.*;

public class JDBC {
    public static final String DB_URL = DBConfig.URL.getConfidential();
    public static final String DB_USERNAME = DBConfig.USERNAME.getConfidential();
    public static final String DB_PASSWORD = DBConfig.PASSWORD.getConfidential();

    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("employee_id"));
                System.out.println("Name : " + resultSet.getString("employee_name"));
                System.out.println("Position : " + resultSet.getString("employee_position"));
                System.out.println("Salary : " + resultSet.getInt("employee_salary"));
                System.out.println("#################");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
