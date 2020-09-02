package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    Stage window;
    TextField nameInput;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("AimLab");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //record layout


        VBox record = new VBox();
        Button recordButton = new Button("Record");
        recordButton.setOnAction(e -> Records.displayRecord("Record"));
        record.setAlignment(Pos.CENTER);
        record.getChildren().add(recordButton);

        //center
        GridPane startGame = new GridPane();
        startGame.setPadding(new Insets(10, 10, 10, 10));
        startGame.setHgap(8);
        startGame.setVgap(8);

        Label nameLabel = new Label("Your name:");
        GridPane.setConstraints(nameLabel, 0,0);

        //Name Input
        TextField nameInput = new TextField("S1mple");
        nameInput.setPromptText("S1mple");
        GridPane.setConstraints(nameInput, 1,0);

        //Start Button
        Button startButton = new Button("start");
        //startButton.setOnAction(e -> startButtonClick());
        //startButton.setOnAction(e -> Game.start());
        startButton.setOnAction(e -> gameStart());
        GridPane.setConstraints(startButton, 0,1);

        //close Button
        Button closeButton = new Button("Quit");
        closeButton.setOnAction(e -> closeProgram());
        GridPane.setConstraints(closeButton, 1,1);
        startGame.getChildren().addAll(nameLabel, nameInput, startButton, closeButton);


        //embed layouts
        BorderPane borderLayout = new BorderPane();
        borderLayout.setRight(record);
        borderLayout.setCenter(startGame);

        //set window
        Scene scene = new Scene(borderLayout, 800,600);
        window.setScene(scene);
        window.show();

    }




    private void closeProgram(){
        boolean ans = ConfirmBox.display("Exit Program", "Want to quit?");
        if(ans){
            window.close();
        }
    }
    private void gameStart(){
        Game aGame = new Game();
        aGame.setScore(0);
        aGame.displayGame();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
