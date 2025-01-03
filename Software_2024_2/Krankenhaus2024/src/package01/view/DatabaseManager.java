package package01.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


   public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://marlonbockelmann.ddns.net:3306/password";
    private static final String DB_USER = "Besh";
    private static final String DB_PASSWORD = "j8e)t7J8jY_1xCoA";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void createPermissionClass(String name, String description, String pin, String acctype) throws SQLException {
        String query = "INSERT INTO PermissionClass (name, description, pin, acctype) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setString(3, pin);
            stmt.setString(4, acctype);
            stmt.executeUpdate();
        }
    }
   }

