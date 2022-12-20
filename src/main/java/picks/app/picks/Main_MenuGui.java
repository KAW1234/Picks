package picks.app.picks;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.util.ArrayList;


public class Main_MenuGui extends Application {
    Border bord = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT));
    BackgroundFill backfill = new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(backfill);
    StackPane root = new StackPane();
    int display_counter;
    ScrollPane data_border = new ScrollPane();
    Football_teamGUI fb_gui = new Football_teamGUI();
    Baseball_TeamGui base_gui = new Baseball_TeamGui();
    Basketball_Gui basket_gui = new Basketball_Gui();
    ArrayList<Node> display_list = fb_gui.node_list();



    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 1000, 900);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.setMinHeight(1000);
        stage.setMinWidth(1000);
        stage.show();

        main_menu(stage);

    }

    public void main_menu(Stage stage) {
        Button profile = new Button("Profile");
        profile.setScaleX(1.5);
        profile.setScaleY(1.5);

        Button message = new Button("Message");
        message.setScaleX(1.5);
        message.setScaleY(1.5);

        Button picks = new Button("Picks");
        picks.setScaleX(1.5);
        picks.setScaleY(1.5);

        Button standings = new Button("Standing");
        standings.setScaleX(1.5);
        standings.setScaleY(1.5);
        //----------------------------------------
        HBox top_middle_buttons = new HBox(75);
        top_middle_buttons.getChildren().add(message);
        top_middle_buttons.getChildren().add(profile);
        top_middle_buttons.getChildren().add(picks);
        top_middle_buttons.getChildren().add(standings);
        top_middle_buttons.setAlignment(Pos.CENTER);

        //-------------------------------------------------
        Button log_out = new Button("Log Out");
        Button setting = new Button("Setting");
        //-----------------------------------------
        HBox top_left_buttons = new HBox(17);
        top_left_buttons.getChildren().addAll(log_out, setting);
        top_left_buttons.setAlignment(Pos.TOP_CENTER);
        //-------------------------------------------
        Button football = new Button("Football");
        Button baseball = new Button("Baseball");
        Button basketball = new Button("Basketball");
//-----------------------------------------------------------
        Button next = new Button("Next");
        next.setAlignment(Pos.TOP_CENTER);
//-----------------------------------------------------------
        Button previous = new Button("Previous");
        previous.setAlignment(Pos.TOP_CENTER);

//------------------------------------------------------------
        basketball.setScaleX(2);
        basketball.setScaleY(2);

        football.setScaleX(2);
        football.setScaleY(2);

        baseball.setScaleX(2);
        baseball.setScaleY(2);
//-------------------------------------------------------------

        data_border.setMaxHeight(400);
        data_border.setMinHeight(400);

        data_border.setMaxWidth(700);
        data_border.setMinWidth(700);

        data_border.setContent(display_list.get(display_counter));

//-----------------------------------------------------------------
        HBox sport_buttons = new HBox(170);
        sport_buttons.getChildren().addAll(football, baseball, basketball);
        sport_buttons.setAlignment(Pos.TOP_CENTER);
//---------------------------------------------------------------------------------


//--------------------------------------------------------------------------
        HBox bottom_box = new HBox(20);
        bottom_box.setAlignment(Pos.CENTER);
        bottom_box.getChildren().addAll(previous, data_border, next);
///-----------------------------------------------------------------------
        HBox top_border_buttons = new HBox(650);
        top_border_buttons.getChildren().addAll(top_left_buttons, top_middle_buttons);
        top_border_buttons.setPadding(new Insets(35, 35, 35, 35));

//-------------------------------------------------------------------------------------
//------------------------------------------------------------------------
         Rectangle rect = new Rectangle();
         rect.setFill(Color.BLACK);
         rect.setHeight(150);
         rect.setWidth(1950);
         rect.setStroke(Color.YELLOW);
         rect.setStrokeWidth(5);
        //-----------------------------------------------------------------------
        //The grid that contains the top border color, the log out,settings and profile buttons
        StackPane top_border = new StackPane();
        top_border.getChildren().addAll(rect,top_border_buttons);

//----------------------------------------------------------------------------------
        VBox vert = new VBox(90);
        vert.getChildren().addAll(sport_buttons, bottom_box);
        vert.setAlignment(Pos.CENTER);
        vert.setBorder(bord);
//-----------------------------------------------------------------------------------
        //The grid that stacks all the other grids (mid_buttons, top_border and bottom_border) on screen
        BorderPane vertical_stack = new BorderPane();
        vertical_stack.setCenter(vert);
        vertical_stack.setTop(top_border);

//----------------------------------------------------------------------------------
        root.setBackground(background); //Sets background to whatever background is
        root.getChildren().addAll(vertical_stack);
//-----------------------------------------------------------------------------------

        football.setOnAction(e -> {
                    display_list.clear();
                    display_list = fb_gui.node_list();
                    data_border.setContent(display_list.get(display_counter));


                }


        );

//-----------------------------------------------------------------------
        basketball.setOnAction(e -> {
                    display_list.clear();
                    display_list = basket_gui.node_list(); //Put the baseketball info here
                    data_border.setContent(display_list.get(display_counter));
                }

        );
//-----------------------------------------------------------------------------

        baseball.setOnAction(e -> {
            display_list.clear();
            display_list = base_gui.node_list();
            data_border.setContent(display_list.get(display_counter));
             //Put the baseball info here


                }

        );

        next.setOnAction(e -> {


                    if (display_counter >= display_list.size() - 1) {
                        display_counter = 0;
                        Node display = display_list.get(display_counter);
                        data_border.setContent(display);

                    } else {
                        display_counter++;
                        Node display = display_list.get(display_counter);
                        data_border.setContent(display);

                    }


                }


        );


        previous.setOnAction(e -> {
            if (display_counter <= 0 ) {
                display_counter =  display_list.size()-1;
                Node display = display_list.get(display_counter);
                data_border.setContent(display);

            } else {
                display_counter--;
                Node display = display_list.get(display_counter);
                data_border.setContent(display);

            }




                }

        );

        log_out.setOnAction(e-> {
            Login_Gui logingui = new Login_Gui();
                    try {
                        logingui.start(stage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }


                }
                );

        standings.setOnAction(e -> {





        }
        );









    }


}
