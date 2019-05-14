package src.Playground;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Playground.fxml"));
        Parent root =  loader.load();
        primaryStage.setTitle("iSports - Playground");
        primaryStage.setScene(new Scene(root, 335, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}