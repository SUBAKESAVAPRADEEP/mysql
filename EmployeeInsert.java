import java.sql.*;

public class EmployeeInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees";
        String username = "root";
        String password = "pradeep99#";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insertQuery = "INSERT INTO employees (empcode, empname, empage, esalay) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Data to be inserted
            int[] empCodes = {101, 102, 103, 104, 105};
            String[] empNames = {"Jenny", "Jacky", "Joe", "John", "Shameer"};
            int[] empAges = {25, 30, 20, 40, 25};
            double[] empSalaries = {10000, 20000, 40000, 80000, 90000};

            // Insert data into the table
            for (int i = 0; i < empCodes.length; i++) {
                preparedStatement.setInt(1, empCodes[i]);
                preparedStatement.setString(2, empNames[i]);
                preparedStatement.setInt(3, empAges[i]);
                preparedStatement.setDouble(4, empSalaries[i]);
                preparedStatement.executeUpdate();
            }

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }}