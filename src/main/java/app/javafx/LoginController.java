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

public class LoginController {
    @FXML
    private Label header;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private AnchorPane AnchorPane;

    private Stage stage;
    public void setStage(Stage stage){
        this.stage = stage;
        startApp(this.stage);
        this.stage.show();
    }
//    private void closeStage(){
//        stage = (Stage) AnchorPane.getScene().getWindow();
//        stage.close();
//    }
    public void startApp(Stage stage){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setTitle("JavaFX");
            stage.setScene(scene);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void Login(ActionEvent event){
        if (userName.getText().equals("a") && password.getText().equals("a")) {
            header.setText("Authenticated");

            try {
                stage = (Stage) AnchorPane.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("style.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                stage.setTitle("JavaFX");
                stage.setScene(scene);
                stage.show();
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
