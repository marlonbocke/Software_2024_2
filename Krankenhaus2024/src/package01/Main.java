package package01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the database and create initial permission classes
            initializeDatabase();

            // Start the login window
            //Anmeldung.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }

    private static void initializeDatabase() throws SQLException {
        DatabaseManager.createPermissionClass("Admin", "Full access permissions", "1234", "Admin");
        DatabaseManager.createPermissionClass("Mitarbeiter", "Mitarbeiter permissions", "45678", "Mitarbeiter");
        DatabaseManager.createPermissionClass("Kunde", "Kunde permissions", "98765", "Kunde");
    }
}

class DatabaseManager {
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
