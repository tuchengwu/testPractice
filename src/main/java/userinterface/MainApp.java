package userinterface;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

/**
 * @author PC
 */
public class MainApp extends Application {
    final Button button = new Button ("Send");
    final Label notification = new Label ();
    final TextField subject = new TextField("");
    final TextArea text = new TextArea ("");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group(), 500, 270);

        final ComboBox emailComboBox = new ComboBox();
        emailComboBox.getItems().addAll(
                "jacob.smith@example.com",
                "isabella.johnson@example.com",
                "ethan.williams@example.com",
                "emma.jones@example.com",
                "michael.brown@example.com"
        );
        emailComboBox.setTooltip(new Tooltip("选择需要测试的项目"));
//        emailComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                String desc = String.format("您点了第%d项，快餐名称是%s",
//                        emailComboBox.getSelectionModel().getSelectedIndex(),
//                        emailComboBox.getSelectionModel().getSelectedItem().toString());
//                System.out.println(desc);
//            }
//        });

        final ComboBox priorityComboBox = new ComboBox();
//        priorityComboBox.getItems().addAll(
//                "Highest",
//                "High",
//                "Normal",
//                "Low",
//                "Lowest"
//        );
        emailComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(emailComboBox.getSelectionModel().getSelectedIndex()==0){
                    List<String> triangle = Arrays.asList("三角形1","三角形2");
                    priorityComboBox.setItems(FXCollections.observableArrayList(triangle));
                    System.out.println(emailComboBox.getSelectionModel().getSelectedIndex());
                }
                else if(emailComboBox.getSelectionModel().getSelectedIndex()==1)
                {
                    List<String> triangle = Arrays.asList("万年1","万年2");
                    priorityComboBox.setItems(FXCollections.observableArrayList(triangle));
                }
                else{
                    List<String> triangle = Arrays.asList("佣金1","佣金2");
                    priorityComboBox.setItems(FXCollections.observableArrayList(triangle));
                }
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("To: "), 0, 0);
        grid.add(emailComboBox, 1, 0);
        grid.add(new Label("Priority: "), 2, 0);
        grid.add(priorityComboBox, 3, 0);
        grid.add(new Label("Subject: "), 0, 1);
        grid.add(subject, 1, 1, 3, 1);
        grid.add(text, 0, 2, 4, 1);
        grid.add(button, 0, 3);
        grid.add (notification, 1, 3, 3, 1);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
