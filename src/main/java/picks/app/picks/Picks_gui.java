package picks.app.picks;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Picks_gui extends Application {
    BorderPane border = new BorderPane();
    BackgroundFill background_color = new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_color);






    @Override
    public void start(Stage stage) throws Exception {
        border.setBackground(background);
        Scene scene = new Scene(border,1000,900);
        stage.setScene(scene);
        stage.show();
        choose();


    }

    private void choose() {
        Button basketball = new Button();
        basketball.setAlignment(Pos.CENTER);
        basketball.setScaleY(4);
        basketball.setScaleX(4);
        basketball.setText("Basketball");


        Button football = new Button();
        football.setAlignment(Pos.CENTER);
        football.setScaleY(4);
        football.setScaleX(4);
        football.setText("Football");

        Button baseball = new Button();
        baseball.setAlignment(Pos.CENTER);
        baseball.setScaleY(4);
        baseball.setScaleX(4);
        baseball.setText("Baseball");

        HBox button_border = new HBox(250);
        button_border.setAlignment(Pos.CENTER);
        button_border.getChildren().addAll(football,baseball,basketball);


        border.setCenter(button_border);




    }


}
