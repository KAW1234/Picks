package backend.main.java.picks.app.picks;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database Singleton;

    private Database() {

    }

    /**
     * Connects to the database
     *
     * @return - The connection of the database
     */
    public Connection connect_database() {

        System.out.print("Connect to database...\n");
        String url = "jdbc:sqlite:C:/Database/this_one_picks.db";
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.print("Connected");
            return conn;

        }

        catch (SQLException e) {
            System.out.print("Couldnt connect to database. Please contact Kenyon");
            System.out.print("Error: " + e);
            System.exit(0);
        }

        return null;

    }

    /**
     * Gets instance of the singleton Database
     *
     * @return - The Database() class
     */
    public static Database get_instance() {
        if (Singleton == null) {
            return Singleton = new Database();
        }

        return Singleton;

    }

}

