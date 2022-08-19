package calc.controllers;

import calc.Main;
import calc.utils.EvaluateString;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class CalculatorController {

    @FXML
    private Label expression;

    @FXML
    private Label result;

    public void insertNumber(String number) { expression.setText(expression.getText() + number); }

    public void insertOperator(String operator) {
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearExpression() {
        expression.setText("");
    }

    public Label getResult() { return result; }
    public void setResult(String newResult) { this.result.setText("= " + newResult); }

    public void insertAnswer(String answer) {
        expression.setText(expression.getText() + answer);
    }

    public void deleteLastChar() {
        if (!expression.getText().isEmpty()) {
            StringBuilder text = new StringBuilder(expression.getText());
            text.deleteCharAt(text.length() - 1);
            expression.setText(text.toString());
        }
    }

    public void openHistoryWindow() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/calc/resources/history.fxml"));
            Parent root = loader.load();

            Main.getHistoryStage().setScene(new Scene(root));
            Main.getHistoryStage().show();

        } catch (IOException ex) {

            System.out.println("Oh no!!!");

        }


    }

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String symbol = button.getText();


        switch (symbol) {

            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                insertNumber(symbol);
                break;

            case "+":
            case "-":
            case "/":
            case "*":
                int resulta = EvaluateString.evaluate(this.expression.getText());
                setResult(String.valueOf(resulta));
                insertOperator(symbol);
                break;

            case "LIMPIAR":

                clearExpression();
                break;

            case "=":

                int result = EvaluateString.evaluate(this.expression.getText());
                setResult(String.valueOf(result));
                break;

            case "RESPUESTA":

                insertAnswer(" " + getResult().getText().substring(2));
                break;

            case "DEL":

                deleteLastChar();
                break;

            case "HIST":
                openHistoryWindow();
                

        }
    }
}
