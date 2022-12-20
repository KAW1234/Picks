package picks.app.picks;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;


public class Login_Gui extends Application {
    private Login_Screen login = Login_Screen.get_instance();
    private final Label message = new Label();
    private final VBox box1 = new VBox(9);
    boolean confirmation;


    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(box1, 1000,600, Color.BEIGE);
        stage.setScene(scene);
        stage.setTitle("Login Screen");
        stage.show();
        login_screen(stage);
;



    }

    private void create_Account_gui(Stage stage)  {
        TextField new_user = new TextField();
        TextField new_pass = new TextField();
        Button create = new Button("Create");
        Button back = new Button("Back");
        new_user.setPromptText("New Username");
        new_pass.setPromptText("New Password");

        Label user_label = new Label("New Username");
        Label pass_label = new Label("New Password");

        box1.setPadding(new Insets(200,200,200,200));
        box1.getChildren().addAll(user_label,new_user,pass_label,new_pass,create,back);
        box1.setAlignment(Pos.CENTER);

        //--------------------------
        create.setOnAction(e -> {
            box1.getChildren().remove(message);


            if(new_user.getText().equals("") || new_user.getText() == null) {
                message.setText("No username entered");
                box1.getChildren().add(message);

            }

            else if(new_pass.getText().equals("") || new_pass.getText() == null) {
                message.setText("No password entered");
                box1.getChildren().add(message);

            }

            else{
               String text =  login.create(new_user.getText(), new_pass.getText());
               message.setText(text);
               box1.getChildren().add(message);


                if(text.equals("Account created!")) {
                    box1.getChildren().clear();
                    confirmation = true;
                    login_screen(stage);
                }

            }

                }

        );

        back.setOnAction(e -> {
            box1.getChildren().clear();
            login_screen(stage);

        }

);

    }
    private void login_screen(Stage stage){
        TextField user_text = new TextField();
        TextField pass_text = new TextField();

        user_text.setPromptText("Username");
        pass_text.setPromptText("Password");

        Label user = new Label("Username: ");
        Label pass = new Label("Password: ");

        Button sign_In = new Button("Sign In");
        Button create_account = new Button("Create Account");

        box1.setPadding(new Insets(200,200,200,200));
        box1.setAlignment(Pos.CENTER);
        box1.getChildren().addAll(user,user_text,pass,pass_text,sign_In,create_account);

        if(confirmation){
            message.setText("Account Created");
            box1.getChildren().add(message);

        }

        //----------------------------------
        sign_In.setOnAction(e -> {
                    box1.getChildren().remove(message);
                    boolean check = login.access(user_text.getText(),pass_text.getText());

                    if(!check) {
                        message.setText("Incorrect username or password");
                        box1.getChildren().add(message);

                    }

                    else{
                        Main_MenuGui main = new Main_MenuGui();
                        try {

                            main.start(stage);

                        } catch (Exception error) {
                            System.out.print("Error: " + error);
                        }


                    }


                }

        );
        //----------------------------------

        //----------------------------------
        create_account.setOnAction(e -> {
            box1.getChildren().clear();
            create_Account_gui(stage);




                }

        );



    }






    }





