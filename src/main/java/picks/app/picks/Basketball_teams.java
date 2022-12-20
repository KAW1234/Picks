package picks.app.picks;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Basketball_teams extends initiate_sports {
    private ArrayList<String[]> basketball_team = new ArrayList<String[]>();
    private ArrayList<String> basketball_win_teams = new ArrayList<String>();
    private ArrayList<String> user_picks_bball = new ArrayList<>();

    private int win_counter = 0;
    String current_user = Login_Screen.user_array();

    private static HashMap<String[], String> versus_info = new HashMap<>();
    private static ArrayList<String> users = new ArrayList<>();
    private static HashMap<String, Integer> week_standing = new HashMap<>();
    private static HashMap<String, Integer> season_standing = new HashMap<>();


    Database database = Database.get_instance();
    private Connection conn = database.connect_database();

    public Basketball_teams() {

    }

    @Override
    protected void count_weekly_wins() { // Takes the user picks and compares it to the Winning picks
        for(int x = 0; x < user_picks_bball.size(); x++) {
            String user_team =  user_picks_bball.get(x);
            String winner_team = basketball_win_teams.get(x);

            if(user_team.equals(winner_team)){
                win_counter = win_counter + 1;
            }

            else{
                continue;
            }

        }


    }



    @Override
    protected boolean picks(boolean certify) {

        if (certify == true) {

            Create_Scanner scan = Create_Scanner.get_instance();
            System.out.print("Enter your picks for the teams this week\n");

            for (String[] teams : basketball_team) {

                String team1 = teams[0];
                String team2 = teams[1];

                System.out.print(team1 + " vs " + team2);

                while (true) {
                    String choice = scan.scan.nextLine();

                    if (choice.toLowerCase().trim().equals(team1.trim().toLowerCase())) {
                        user_picks_bball.add(choice);
                        break;

                    }

                    else if (choice.toLowerCase().trim().equals(team2.trim().toLowerCase())) {
                        user_picks_bball.add(choice);
                        break;

                    }

                    else if (choice.trim().toLowerCase().equals("quit")) {
                        System.out.print("Clearing your picks. Returning to main menu");
                        user_picks_bball.clear();
                        return false;
                    }

                    else {
                        System.out.print(choice + " isnt an option. Please try again!");
                    }

                }

            }

            return true;

        }

        else {
            return false;
        }

    }



    @Override
    protected void enter_picks_to_db(boolean certify) {
        int y = 2;

        try {
            String sql = "INSERT INTO Picks_basketball(user,team1,team2,team3,team4,team5,team6,team7,team8) VALUES (?,?,?,?,?,?,?,?,?)"; // Inserting
            // teams

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, current_user); // Add the users to first column
                for (String team : user_picks_bball) {
                    pstmt.setString(y, team);
                    y = y + 1;

                }

                pstmt.executeUpdate();

            }

        }

        catch (SQLException e) {
            System.out.print("SQLError: " + e);
        }

    }

    private void count_season_wins() {

    }

    @Override
    protected void rank_weekly_users_wins() {
        String sql = "SELECT * FROM WEEKLY_BASKETBALL ORDER by win_count";

        try {

            try (Statement stmt = conn.createStatement()) {
                stmt.executeQuery(sql);
                {

                }

            }
        }

        catch (SQLException e) {
            System.out.print("SQLERROR: " + e);
        }

    }


    @Override
    protected void rank_season_user_wins() {
        String sql = "SELECT * FROM SEASON_BASKETBALL ORDER by win_count";

        try {

            try (Statement stmt = conn.createStatement()) {
                stmt.executeQuery(sql);
                {

                }

            }
        }

        catch (SQLException e) {
            System.out.print("SQLERROR: " + e);
        }

    }

    @Override
    protected void add_user_picks_to_array() {
        {
            String sql = "SELECT team1,team2,team3,team4,team5,team6,team7, team8"
                    + " FROM Picks_baseball WHERE user == " + "'" + current_user + "'";

            try {

                try (Statement stmt = conn.createStatement()) {
                    ResultSet rs = stmt.executeQuery(sql);

                    {

                        for (int x = 1; x <= 8; x++) {
                            String team = rs.getString(x);

                            if (team == null) {
                                break;
                            }

                            else {
                                user_picks_bball.add(team);
                            }

                        }

                    }
                }
            }

            catch (SQLException e) {
                System.out.print("SQL Error: " + e);
            }

        }

    }

    @Override
    protected void add_winning_teams() {

        if (basketball_win_teams.size() == 0) {

            String sql = "SELECT id, team FROM win_bball__team";

            try {

                try (Statement stmt = conn.createStatement()) {

                    ResultSet rs = stmt.executeQuery(sql);
                    {

                        while (rs.next()) { // While there is something in the database
                            String win_team = rs.getString(2);
                            basketball_win_teams.add(win_team);

                        }

                    }

                }

            }

            catch (SQLException e) {
                System.out.print("SQL Exception thrown: " + e);
            }
        }

        else {

            System.out.print("");
        }
    }

    private void add_wins() { // adds winners to the winners circle

    }


    public void add_users() {
        users.clear(); //DELETE THIS WHEN YOU ADD THE ADD USERS TO THE BOOTUP
        String sql = "SELECT username From login_info";
        try {


            try (Statement stmt = conn.createStatement()){
                ResultSet rs = stmt.executeQuery(sql);
                {

                    while(rs.next()) {
                        String user = rs.getString(1);
                        users.add(user);


                    }

                }

            }

        }

        catch(SQLException e){
            System.out.print("SQL Error: " + e);
        }
    }

    @Override
    public void update_teams() {
        if (basketball_team.size() == 0) {
            System.out.print("No teams in the database");
        }

        else {
            basketball_team.clear();
            add_teams();

        }

    }


    @Override
    protected boolean check() {
        if (user_picks_bball.size() == 0) {
            System.out.print("No picks to choose from! Would you like to enter football picks?\n");

            Create_Scanner scan = Create_Scanner.get_instance();

            while (true) {

                String choice = scan.scan.nextLine().trim().toLowerCase();

                if (choice.trim().toLowerCase().equals("yes")) {

                    return true;

                }

                else if (choice.trim().toLowerCase().equals("no")) {
                    break;
                }

                else {
                    System.out.print("Im sorry: " + scan + " is not an option");
                }

            }

        }

        else {

            return true;
        }

        return false;

    }

    @Override
    protected void add_week_standing() {
        String sql = "SELECT user, win_count FROM WEEKLY_BASKETBALL";
        try {

            try (Statement stmt = conn.createStatement()){
                ResultSet rs = stmt.executeQuery(sql);{

                    while(rs.next()){
                        String user = rs.getString(1);
                        int count = rs.getInt(2);
                        week_standing.put(user,count);

                    }

                }


            }

        }

            catch(SQLException e){
            System.out.print("SQL Error: " + e);

            }
    }

    @Override
    protected void add_season_standing(){
            String sql = "SELECT user, win_count FROM SEASONAL_BASKETBALL";

            try {

                try (Statement stmt = conn.createStatement()){
                    ResultSet rs = stmt.executeQuery(sql);{

                        while(rs.next()){
                            String user = rs.getString(1);
                            int count = rs.getInt(2);
                            season_standing.put(user,count);

                        }

                    }


                }

            }

            catch(SQLException e){
                System.out.print("SQL Error: " + e);

            }
        }




    @Override
    protected void add_teams() {

        if (versus_info.size() == 0) {
            String sql = "SELECT team1, team2, date_game FROM Basketball_teams";

            try {

                try (Statement stmt = conn.createStatement()) {

                    ResultSet rs = stmt.executeQuery(sql);

                    {

                        while (rs.next()) { // While there is something in the database
                            String[] versus_teams = new String[2];
                            String team1 = rs.getString(1);
                            String team2 = rs.getString(2);
                            String date = rs.getString(3);

                            versus_teams[0] = team1;
                            versus_teams[1] = team2;
                            versus_info.put(versus_teams, date);




                        }

                    }

                }

            }

            catch (SQLException e) {
                System.out.print("SQL Exception thrown: " + e);
            }

        }

    }

    @Override
    protected void add_weekly_win_to_db() {
        String sql = "INSERT INTO WEEKLY_BASKETBALL (user,win_count) VALUES (?,?)";

        try {

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(2, current_user);
                pstmt.setInt(3, win_counter);

            }
        }

        catch (SQLException e) {
            System.out.print("SQL Error: " + e);
        }

    }

    public static HashMap<String[],String> get_teams(){
        return versus_info;
    }

    public static ArrayList<String> get_users() {
        return users;
    }

    public static HashMap<String, Integer> get_week_standing() {return week_standing;}



}

