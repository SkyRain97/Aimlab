package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game  {

    private static Stage window;
    private static Pane pane;
    private static Scene scene;
    private static double sceneLength = 1440;
    private static double sceneHeight = 1000;
    private int score;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //randomly display 20 buttons as targets to be clicked
    public void displayGame(){
        window = new Stage();
        pane = new Pane();
        BorderPane boarderPane = new BorderPane();
        //window.setFullScreen(true);

        VBox ButtonsLayout = new VBox();
        //for(int i = 0; i < 20; i++){
            Button target = new Button();

            Button quit = new Button("Quit");
            Button restart = new Button("Restart");

            double x = getRandomDouble() * (sceneLength);
            double y = getRandomDouble() * (sceneHeight);


            target.relocate(x, y);
            target.setOnAction(e -> targetClicked(target));
            target.getStyleClass().add("button-target");


            pane.setPrefSize(2000, 1500);
            pane.getChildren().add(target);
            window.setMinHeight(sceneHeight);
            window.setMinWidth(sceneLength);
            scene = new Scene(pane);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            window.setScene(scene);
            window.show();


        //}
    }


    private void targetClicked(Button target){
        score++;
        Button newTarget = new Button();
        newTarget.setShape(new Circle(40));
        newTarget.getStyleClass().add("button-target");
        double v = getRandomDouble() * (sceneLength);
        double h = getRandomDouble() * (sceneHeight);

        System.out.println(v + " "+ h);
        newTarget.relocate(v, h);
        pane.getChildren().remove(target);

        newTarget.setOnAction(e->targetClicked(newTarget));
        System.out.println(score);

        if(score == 5) {
            System.out.println("game ended");
            window.setFullScreen(false);
            Finished newFinished = new Finished();
            boolean ans = newFinished.displayFinishWindow("Congratulations! You finished in time!");
            if(ans == false) {
                window.close();
                score = 0;

            }else{
                window.close();
                displayGame();
            }
            return;
        }

        pane.getChildren().add(newTarget);
    }

    private static double getRandomDouble(){
        Random aRandomDouble = new Random();
        double result = aRandomDouble.nextDouble();
        if(result < 0.1){
            result = result + 0.1;
        }else if(result > 0.9){
            result = result - 0.1;
        }
        return result;
    }


}
