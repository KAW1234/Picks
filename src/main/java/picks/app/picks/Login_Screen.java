package picks.app.picks;



import javafx.stage.Stage;


import java.sql.*;

public class Login_Screen   {
    Stage stage = new Stage();
    Database database = Database.get_instance();
    Connection conn = database.connect_database();
    private static String current_user;
    private static Login_Screen Singleton;

    private Login_Screen() {

    }

    public static Login_Screen get_instance() {
        if (Singleton == null) {
            return Singleton = new Login_Screen();
        }

        return Singleton;

    }
    public boolean access(String username, String password) {

        try {



                boolean check = check_credentials(conn, username, password);

                if (check == true) {
                    current_user = username;
                    return true;

                }

                else {
                    return false;
                }


        }

        catch (SQLException e) {
            System.out.print("Couldnt conenct to database\n Error: " + e);
            return false;
        }


    }

    private boolean check_credentials(Connection conn, String username, String pass) throws SQLException {
        String sql = "SELECT id, username, password FROM login_info";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            {

                while (rs.next()) { // While there is something in the database

                    if (rs.getString(2).equals(username) && rs.getString(3).equals(pass)) { // If the user name and
                        // password equals what
                        // the database has allow
                        // access
                        return true;
                    }

                }

            }
        }

        return false;
    }


    private void create_account(Connection conn, String user, String password) throws SQLException {
        String sql = "INSERT INTO login_info(username,password) VALUES (?,?)"; // Inserting two values

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user); // Add the users to first column
            pstmt.setString(2, password); // Add passwords to seond column
            pstmt.executeUpdate();

        }
    }

    private boolean check(String user) {
        String sql = "SELECT username FROM login_info";

        try {

            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    if(user.equals(rs.getString(1))){
                        return false;
                    }
                }

            }

        }

        catch(SQLException e){
            System.out.print("Sql Error: " + e);
            return false;
        }

        return true;
    }


    public static String user_array() {
        return current_user;
    }

    public final String create(String user, String password) {

        boolean check = check(user);

        if(!check) {
            return "Some one has that username";
        }

        else {

            try  {


                create_account(conn, user, password);

                return "Account created!";

            }

            catch (SQLException e) {
                return "Account cannot be created! Please try Again";
            }

        }

    }


}


