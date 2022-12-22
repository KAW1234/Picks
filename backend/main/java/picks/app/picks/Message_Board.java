package picks.app.picks;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Message_Board implements Observer {
    private static Message_Board Singleton;
    Database database = Database.get_instance();
    Connection conn = database.connect_database();
    private ArrayList<String> messages = new ArrayList<String>();
    Create_Scanner scan = Create_Scanner.get_instance();

    private Message_Board() {

    }

    private String message(String message) {
        System.out.print("Message posted");
        return message;

    }

    private void board(String message) {
        // Server goes here

    }

    @Override
    public void add_users() {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove_users() {
        // TODO Auto-generated method stub

    }

    @Override
    public void notify_users() {
        // TODO Auto-generated method stub

    }

}
