package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Records {
    private static ObservableList<Record> records;
    private static TableView table;

    public Records(ObservableList<Record> records) {
        this.records = records;
    }

    public static ObservableList<Record> getRecords() {
        return records;
    }

    public void setRecords(ObservableList<Record> records) {
        this.records = records;
    }

    public static TableView getTable() {
        return table;
    }

    public static void setTable(TableView table) {
        Records.table = table;
    }

    public static void displayRecord(String title){
        Stage window = new Stage();
        table = new TableView();

        window.setTitle(title);
        window.setMinWidth(100);

        TableColumn<Record, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Record, Double> timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(200);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.setItems(records);
        table.getColumns().addAll(nameColumn, timeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().add(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();



    }

/*    public static ObservableList<Record> inputRecord(){
        ObservableList<Record> records =  FXCollections.observableArrayList();
        records.add(new Record("Skyrain", 32.2));
        records.add(new Record("GGBondo", 23.1));
        records.add(new Record("Xinple", 25.1));

        return records;
    }*/

}
