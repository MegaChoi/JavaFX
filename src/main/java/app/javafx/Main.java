package app.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            LoginController login = new LoginController();
            login.LoadLoginScene(stage);
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getStackTrace()[0]);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}