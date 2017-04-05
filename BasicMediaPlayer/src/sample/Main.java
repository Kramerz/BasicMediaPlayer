package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    Stage window;
    Scene mainScene, scene2, scene3;
    Button button;
    String MEDIA_URL = "Enter your URL to the Site here;

    @Override
    public void start(Stage primaryStage) throws Exception {


        Media media = new Media(new File(MEDIA_URL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);


        //CREATE MEDIAVIEW AND ADD MEDIA PLAYER TO THE VIEWER
        MediaView mediaView = new MediaView(mediaPlayer);

        //PRIMARY STAGE
        window = primaryStage;

        //CREATING THE MEDIA URL

        //MediaPlayer mediaPlayer = new MediaPlayer(media);
        // MediaView mediaView = new MediaView(mediaPlayer);


        //MEDIA LAYOUT SCENE
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(mediaView);
        Scene scene3 = new Scene(layout3, 1265, 715);



        Label label1 = new Label("Welcome to the first Scene");
        Button button1  = new Button("Go to scene 2");
        button1.setOnAction(event -> {
            window.setScene(scene2);
            System.out.println("Transferring to Scene 2");
        });

        //create the Alert Button just in case
        Button alertButton = new Button("Call me now!");
        alertButton.setOnAction(event -> {
            System.out.println("Supposed to be a pop up window");
        });

        Button moviePlayer = new Button("Movie Player");
        moviePlayer.setOnAction(event -> {
            window.setScene(scene3);
        });

        //layout 1 - Children are laid out in a vertical column

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, alertButton, moviePlayer);
        mainScene = new Scene(layout1, 200, 200);

        //Button 2
        Button button2 = new Button("This scene sucks go back to scene 1");
        button2.setOnAction(event -> {
            window.setScene(mainScene);
            System.out.println("Taking you back to scene 1");
        });
        Label label2 = new Label("Welcome to the second Scene");



        //layout2
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 400, 400);

        //creating the stage
        window.setScene(mainScene);
        window.setTitle("Insert some title here");
        window.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
