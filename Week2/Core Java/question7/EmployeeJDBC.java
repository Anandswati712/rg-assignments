import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class EmployeeJDBC{
    static final String URL = "jdbc:mysql://localhost:3306/employees_data";
    static final String USER = "root";  
    static final String PASSWORD = "admin@1234";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                EmployeeJDBC.URL, EmployeeJDBC.USER, EmployeeJDBC.PASSWORD);

            System.out.println("Connection established successfully!");

            // INSERT (Create)
            // insertEmployee(connection, 4, "Bill", "Sales");
            // printEmployees(connection);

            //UPDATE (Update)
            // updateEmployee(connection, 4, "Marketing");
            // printEmployees(connection);

            // //DELETE
            deleteEmployee(connection, 4);
            printEmployees(connection);

        connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
    //Insert
    public static void insertEmployee(Connection connection, int id, String name, String department) throws SQLException {
        String insertSQL = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(insertSQL);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, department);
        int rowsInserted = pstmt.executeUpdate();
        System.out.println(rowsInserted + " row(s) inserted.");
    }

    //UPDATE
    public static void updateEmployee(Connection connection, int id, String newDepartment) throws SQLException{
        String updateSQL = "UPDATE employees SET department = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(updateSQL);
        pstmt.setString(1, newDepartment);
        pstmt.setInt(2, id);
        int rowsUpdated = pstmt.executeUpdate();
        System.out.println(rowsUpdated + " row(s) updated.");
    }

    //DELETE
    public static void deleteEmployee(Connection connection, int id) throws SQLException {
        String deleteSQL = "DELETE FROM employees WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(deleteSQL);
        pstmt.setInt(1, id);
        int rowsDeleted = pstmt.executeUpdate();
        System.out.println(rowsDeleted + " row(s) deleted.");
    }

    //RETRIEVE (READ)
    public static void printEmployees(Connection connection) throws SQLException {
        String selectSQL = "SELECT * FROM employees";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectSQL);
        System.out.println("ID | Name | Department");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String department = rs.getString("department");
            System.out.println(id + " | " + name + " | " + department);
        }
        System.out.println(); 
        rs.close();
        stmt.close();   
    }
}

