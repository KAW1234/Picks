package picks.app.picks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User_view {
    Database database = Database.get_instance();
    private Connection conn = database.connect_database();

    private boolean delete_account() {
        System.out.print("Are you sure you want to delete your account?\n");

        Create_Scanner scan = Create_Scanner.get_instance();

        while (true) {

            String choice = scan.scan.nextLine();

            if (choice.trim().toLowerCase().equals("yes")) {
                return true;
            }

            else if (choice.trim().toLowerCase().equals("no")) {
                return false;
            }

            else {
                System.out.print(choice + " is not an option");
            }

        }

    }

    private void delete() {

        String user = Login_Screen.user_array();
        String sql = "DELETE FROM login_info WHERE username == " + "" + user + "";
        try {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeQuery(sql);
            }
        }

        catch (SQLException e) {
            System.out.print("SQL ERROR: " + e);

        }

        System.out.print("Account Deleted");



    }

    private void change_username() {

    }

    private void change_password() {

    }

}
