package app.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label header;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    public AnchorPane AnchorPane;



    public void LoadLoginScene(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        stage.setTitle("JavaFX");
        stage.setScene(scene);
        stage.show();

    }
//    Authentication method, TODO: maybe put in a different file
    public void Authenticate(){
        if (userName.getText().equals("a") && password.getText().equals("a")) {
            header.setText("Authenticated");
            try {
                Stage stage = (Stage) AnchorPane.getScene().getWindow();
                CalculatorController CalculatorScene = new CalculatorController();
                CalculatorScene.LoadCalculatorScene(stage);

            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getStackTrace()[0]);
            }
        }
        else{
            header.setText("login details incorrect");
        }

    }

}
