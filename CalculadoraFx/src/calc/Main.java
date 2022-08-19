package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage historyStage = null;

    public static Stage getHistoryStage() {
        return historyStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("deshacer/calculator.fxml"));
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        createHistoryStage();
    }

    public void createHistoryStage() {

        historyStage = new Stage();
        historyStage.setTitle("Historial de Calculo");
        historyStage.setAlwaysOnTop(true);
        historyStage.setResizable(true);
        historyStage.initModality(Modality.APPLICATION_MODAL);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
