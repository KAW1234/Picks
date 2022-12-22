package backend.main.java.picks.app.picks;


public class Main_Menu  {
    Create_Scanner scan = Create_Scanner.get_instance();



    private String main_menu(String choice) {

        if (choice.trim().toLowerCase().equals("picks")) {
            Football_teams fb = new Football_teams();
            fb.add_picks();

        }

        return "Done";

    }

}
