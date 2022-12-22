package picks.app.picks;

public abstract class initiate_sports {


        /**
         * Adds the teams to the array list so the program can shows the current teams
         * playing that week and to ensure correct input when peoplea re entering wins
         *
         */
        protected abstract void add_teams();

        /**
         *
         * @param certify - Boolean that makes sure the check() return true
         * @return - Returns true if picks is successful
         */
        protected abstract boolean picks(boolean certify);

        /**
         * Makes sure that there is something in the database
         *
         * @return - True if there is something in database
         */
        protected abstract boolean check();

        /**
         * Ranks the player wins depending on how many correct teams the user choose
         */
        protected abstract void rank_weekly_users_wins();

        /**
         * Ranks the player wins depending on how many weekly_wins the user has
         */
        protected abstract void rank_season_user_wins();

        /**
         * Adds the user picks for what they think the winning teams to an arrat so we
         * can
         * count how correct they are
         */
        protected abstract void add_user_picks_to_array();

        /**
         * Adds the user picks for what they think the winning teams are to the database
         *
         * @param certify - Returns true if the picks is entered to the database
         *                successfully
         */
        protected abstract void enter_picks_to_db(boolean certify);

        /**
         * Functions that updates the database if any teams are added to it by
         * adminstartor
         */
        protected abstract void update_teams();

        /**
         * Adds the winning teams to the array
         */
        protected abstract void add_winning_teams();

        /**
         * Counts how many correct teams that the user picks
         */
        protected abstract void count_weekly_wins();

        /**
         * Adds weekly wins to database
         */
        protected abstract void add_weekly_win_to_db();

        protected abstract void add_season_standing();

        protected abstract void add_week_standing();

        // ------------------------------------------------------------------------

        public final void create_picks() {
            boolean check = check();

            boolean certify = picks(check);

            enter_picks_to_db(certify);

        }

        public final void add_picks() {

            add_user_picks_to_array();

        }

        public final void show_the_weekly_score() {
            rank_weekly_users_wins();





        }

        public final void show_the_season_score() {
            rank_season_user_wins();



        }

        public final void add_weekly_to_db() {
            count_weekly_wins();

            add_weekly_win_to_db();

        }

    }


