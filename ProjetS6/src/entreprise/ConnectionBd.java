package entreprise;

import java.sql.*;

public class ConnectionBd{
    private Connection connection;

    public ConnectionBd(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public ConnectionBd() throws SQLException {
        // Load Type-4 Driver
        // MySQL Type-4 driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database URL, username, and password

        // Replace with your database name
        String url = "jdbc:mysql://127.0.0.1:3306/db_proj";

        // Replace with your MySQL username
        String username = "pal";

        // Replace with your MySQL password
        String password = "jlupexgx";

        this.connection = DriverManager.getConnection(url, username, password);
        
    }catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        }
    catch (ClassNotFoundException e) {
        System.err.println("JDBC Driver not found: " + e.getMessage());
    }
}
//test
