import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database"; // Change your_database to your actual database name
        String user = "your_username"; // Change to your MySQL username
        String password = "your_password"; // Change to your MySQL password

        // SQL query to fetch data from Employee table
        String query = "SELECT EmpID, Name, Salary FROM Employee";

        try (
            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            // Create statement
            Statement stmt = conn.createStatement();
            // Execute query
            ResultSet rs = stmt.executeQuery(query)
        ) {
            // Display results
            System.out.println("EmpID | Name | Salary");
            while (rs.next()) {
                int empId = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(empId + " | " + name + " | " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
