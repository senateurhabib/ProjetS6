package entreprise;
import java.sql.*;

	// Java program to implement a simple JDBC application
	

	public class Stmt{
	    public static ResultSet exe_statement(String stmt) throws ClassNotFoundException, SQLException {
	        // Database URL, username, and password
	        // Replace with your database name

	        String url = "jdbc:mysql://127.0.0.1:3306/db_proj";

	        // Replace with your MySQL username
	        String username = "pal";

	        // Replace with your MySQL password
	        String password = "jlupexgx";

	        ResultSet rs = null;

	        // Establish JDBC Connection
	        try {

	            // Load Type-4 Driver
	            // MySQL Type-4 driver class
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish connection
	            Connection c = DriverManager.getConnection(url, username, password);

	            // Create a statement
	            Statement st = c.createStatement();

	            // Execute the query
	            rs = st.executeQuery(stmt);

	            // Close the connection
	            st.close();
	            c.close();
	            System.out.println("Connection closed.");
	        }
	        catch (ClassNotFoundException e) {
	            System.err.println("JDBC Driver not found: " + e.getMessage());
	        }
	        catch (SQLException e) {
	            System.err.println("SQL Error: " + e.getMessage());
	        }
	        return rs;
	    }
	}

}