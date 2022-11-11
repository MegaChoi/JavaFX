package app.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
//        stage.setTitle("JavaFX");
//        stage.setScene(scene);
//        stage.show();
        LoginController login = new LoginController();
        login.setStage(stage);
    }
    public static void main(String[] args) {
        launch();
    }
}