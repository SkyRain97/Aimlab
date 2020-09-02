package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;



public class Finished {
//Alert box
    static Stage window = new Stage();
    private static boolean result = true;

    public static boolean displayFinishWindow(String finish){
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(200);

        Label finishLabel = new Label(finish);

        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> startNewGame());

        Button backToFrontButton = new Button("back");
        backToFrontButton.setOnAction(e -> backToFront());

        HBox ButtonsLayout = new HBox(restartButton, backToFrontButton);
        ButtonsLayout.setSpacing(80);
        VBox layout = new VBox(finishLabel, ButtonsLayout);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return result;
    }

    private static void startNewGame(){
        window.close();
        result = true;
    }

    private static void backToFront(){
        window.close();
        result = false;
    }
}
