package app.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorController {
    @FXML
    private Label label;
    private float num1;
    private String operator = "";
    private boolean  start = true;
    Calculator calculator = new Calculator();

    @FXML
    VBox VBox;

    public void LoadCalculatorScene(Stage stage) {
        try {
            float width = (float) stage.getWidth();
            float height = (float) stage.getHeight();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calculator.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setWidth(width);
            stage.setHeight(height);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);

        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.getStackTrace()[0]);
        }
    }

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) VBox.getScene().getWindow();
        LoginController login = new LoginController();
        login.LoadLoginScene(stage);
    }


    @FXML
    public void clear(ActionEvent event){
        num1 = 0;
        operator = "";
        label.setText("");

    }
    @FXML
    public void processNumbers(ActionEvent event){
        if (start){
            label.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        label.setText(value);

    }
    @FXML
    public void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
//      if the operator is not "="
        if(!value.equals("=")){
//          if the operator variable is not empty
            if(!operator.isEmpty()) {
                operator = value;
            }
            else{
                try {
                    operator = value;
                    num1 = Float.parseFloat(label.getText());
                    label.setText("");
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        } else {
            if (operator.isEmpty())
                return;
            float num2 = Float.parseFloat(label.getText());
            float output = calculator.calculate(num1, num2,operator);
            System.out.println(calculator.calculate(num1, num2,operator));
            label.setText(String.valueOf(output));
            operator = "";
            start = true;
        }
    }

}