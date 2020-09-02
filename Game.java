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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game  {

    private static Stage window;
    private static Group group;
    private static Scene scene;
    private static double sceneLength = 1280;
    private static double sceneHeight = 960;
    private static int score = 0;


    public void setScore(int score) {
        Game.score = score;
    }

    //randomly display 20 buttons as targets to be clicked
    public void displayGame(){
        window = new Stage();
        group = new Group();
        window.setFullScreen(true);
        VBox quitButtons = new VBox();
        //for(int i = 0; i < 20; i++){
            Button target = new Button();
            Button quit = new Button("Quit");
            Button restart = new Button("Restart");
            double x = getRandomDouble() * (sceneLength);
            double y = getRandomDouble() * (sceneHeight);
            System.out.println(x + " " + y);
            target.setLayoutX(x);
            target.setLayoutY(y);

            target.setOnAction(e -> targetClicked(target));
            group.getChildren().add(target);
            scene = new Scene(group, sceneLength, sceneHeight);

            window.setScene(scene);

            window.show();
        //}
    }


    private void targetClicked(Button target){
        score++;
        Button newTarget = new Button();
        double v = getRandomDouble() * (sceneLength);
        double h = getRandomDouble() * (sceneHeight);

        System.out.println(v + " "+ h);
        newTarget.setLayoutX(v);
        newTarget.setLayoutY(h);
        group.getChildren().remove(target);

        newTarget.setOnAction(e->targetClicked(newTarget));
        System.out.println(score);

        if(score == 5) {
            window.setFullScreen(false);
            boolean ans = Finished.displayFinishWindow("Congradulations! You finished in time!");
            if(ans == false) {
                window.close();

            }else{
                window.close();
                displayGame();
            }
            return;
        }

        group.getChildren().add(newTarget);
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
