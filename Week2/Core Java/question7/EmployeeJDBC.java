// File: src/question7/EmployeeJDBC.java
import java.sql.*;

public class EmployeeJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/your_db";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);

        // CREATE
        PreparedStatement ps = con.prepareStatement("INSERT INTO employee (id, name, department) VALUES (?, ?, ?)");
        ps.setInt(1, 1);
        ps.setString(2, "Alice");
        ps.setString(3, "HR");
        ps.executeUpdate();

        // READ
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");
        System.out.println("All employees:");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("department"));
        }

        // UPDATE
        ps = con.prepareStatement("UPDATE employee SET name=? WHERE id=?");
        ps.setString(1, "Alicia");
        ps.setInt(2, 1);
        ps.executeUpdate();

        // DELETE
        ps = con.prepareStatement("DELETE FROM employee WHERE id=?");
        ps.setInt(1, 1);
        ps.executeUpdate();

        con.close();
    }
}
