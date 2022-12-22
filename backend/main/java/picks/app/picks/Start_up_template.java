package backend.main.java.picks.app.picks;


public abstract class Start_up_template {

    abstract void add_users();

    abstract void add_to_teams();

    abstract void add_winners();

    abstract void add_football_teams();

    abstract void add_baseball_teams();

    abstract void add_basketball_teams();

    public final void start_up() {
        add_users();

        add_football_teams();

        add_baseball_teams();

        add_basketball_teams();

        add_winners();
    }

}

