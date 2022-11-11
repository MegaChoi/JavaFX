package app.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;

public class Controller {
    @FXML
    private Label label;
    private float num1;
    private String operator = "";
    private boolean  start = true;
    Calculator calculator = new Calculator();

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