package picks.app.picks;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Map;

public class Basketball_Gui {

    private Basketball_teams basketball_teams = new Basketball_teams();
    private ArrayList<Node> node_list = new ArrayList<>();


    private Node display_users() {
        basketball_teams.add_teams();
        BackgroundFill color = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(color);

        VBox user_container = new VBox(20);
        user_container.setMinHeight(700);
        user_container.setMinWidth(700);
        user_container.setAlignment(Pos.TOP_CENTER);
        user_container.setBackground(background);

        Text title = new Text("Users");
        title.setFont(Font.font("Times New Roman", 30));

        user_container.getChildren().add(title);


        for (String user : Baseball_team.get_users()) {
            Text user_text = new Text();
            user_text.setText(user);
            user_text.setFont(Font.font("Times New Roman", 21));
            user_text.setFill(Color.BLACK);

            user_container.getChildren().add(user_text);
        }

        return user_container;

    }

    private Node display_teams() {
        basketball_teams.add_teams(); //DELETE THIS WHEN YOU ADD USERS TO THE BOOT UP
        BackgroundFill color = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(color);

        Border border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

        VBox user_container = new VBox(20);
        user_container.setMinHeight(700);
        user_container.setMinWidth(700);
        user_container.setAlignment(Pos.TOP_CENTER);
        user_container.setBackground(background);

        Text title = new Text("Teams");
        title.setFont(Font.font("Times New Roman", 30));

        user_container.getChildren().add(title);

        for(Map.Entry<String[],String> teams: basketball_teams.get_teams().entrySet()){
            HBox team_display = new HBox(20);
            team_display.setAlignment(Pos.CENTER);
            team_display.setBorder(border);

            String[] versus_team = teams.getKey();

            String team1 = versus_team[0];
            String team2 = versus_team[1];
            String date = teams.getValue();

            Text text1 = new Text(team1);
            text1.setFont(Font.font("Times New Roman",25));

            Text text2 = new Text(team2);
            text2.setFont(Font.font("Times New Roman",25));

            Text versus = new Text(" vs ");
            versus.setFont(Font.font("Times New Roman",25));

            Text date_game = new Text(date);
            date_game.setFont(Font.font("Times New Roman",25));

            team_display.getChildren().addAll(text1, versus, text2, date_game);

            user_container.getChildren().add(team_display);

        }

        return user_container;
    }

    private Node display_season_standing() {
        BackgroundFill color = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(color);

        VBox display_standing = new VBox(20);
        display_standing.setMinHeight(700);
        display_standing.setMinWidth(700);
        display_standing.setAlignment(Pos.TOP_CENTER);
        display_standing.setBackground(background);

        Text title = new Text("Season Standings");
        title.setFont(Font.font("Times New Roman", 30));

        display_standing.getChildren().add(title);

        return null;

    }

    private Node display_weekly_standings() {
        BackgroundFill color = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(color);

        VBox display_standing = new VBox(20);
        display_standing.setMinHeight(700);
        display_standing.setMinWidth(700);
        display_standing.setAlignment(Pos.TOP_CENTER);
        display_standing.setBackground(background);

        Text title = new Text("Season Standings");
        title.setFont(Font.font("Times New Roman", 30));

        display_standing.getChildren().add(title);
        return null;

    }


    public ArrayList<Node> node_list() {
        node_list.add(display_users());
        node_list.add(display_teams());
        node_list.add(display_season_standing());
        node_list.add(display_weekly_standings());
        return node_list;

    }







}

