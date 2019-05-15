package src.iSport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Frames/HomePage/HomePage.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("iSports");
        primaryStage.setScene(new Scene(root, 335, 600));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
