package backend.main.java.picks.app.picks;

import java.sql.*;



abstract class Create_Account_steps {

    /**
     * Creates the username
     *
     * @return - Return the username
     */
    abstract String create_username();

    /**
     * Creates the password
     *
     * @return - Returns the password
     */
    abstract String create_password();

    /**
     * Adds the password and username to database
     *
     * @param conn
     * @param user
     * @param password
     * @throws SQLException
     */
    abstract void create_account(Connection conn, String user, String password) throws SQLException;

    public final void create() {
        String url = "jdbc:sqlite:C:/Database/this_one_picks.db";

        try (Connection conn = DriverManager.getConnection(url)) {

            String user = create_username();

            String password = create_password();

            create_account(conn, user, password);

        }

        catch (SQLException e) {
            System.out.print("Account cannot be created! Please try Again");
        }
    }

}

