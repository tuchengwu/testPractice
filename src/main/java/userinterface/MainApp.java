package userinterface;

import exceloperation.ReadExcel;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import testExecution.CalendarTest;
import testExecution.CommissionTest;
import testExecution.TriangleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PC
 */
public class MainApp extends Application {
    final Button button = new Button ("执行");
    final Label notification = new Label ();
    final TextField subject = new TextField("");
    final TextArea text = new TextArea ("");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group(), 800, 600);
        final ComboBox<String> projectComboBox = new ComboBox<String>();
        projectComboBox.getItems().addAll(
                "三角形问题",
                "万年历问题",
                "佣金问题"
        );
        final ComboBox<String> priorityComboBox = new ComboBox<String>();
        final ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("pass", 13),
                new PieChart.Data("fail", 25),
                new PieChart.Data("wait",1));
        final PieChart pieChart = new PieChart(pieChartData);
        pieChart.setVisible(false);
        projectComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(projectComboBox.getSelectionModel().getSelectedIndex()==0){
                    String filePath="src/main/resources/triangleTestCases.xlsx";
                    int number= ReadExcel.getNumberOfRow(filePath);
                    changeAccordingToChoice(number, priorityComboBox, pieChart,filePath);
                }
                else if(projectComboBox.getSelectionModel().getSelectedIndex()==1)
                {
                    String filePath="src/main/resources/calendarTestCases.xlsx";
                    int number= ReadExcel.getNumberOfRow(filePath);
                    changeAccordingToChoice(number, priorityComboBox, pieChart,filePath);
                }
                else{
                    String filePath="src/main/resources/commissionTestCases.xlsx";
                    int number= ReadExcel.getNumberOfRow(filePath);
                    changeAccordingToChoice(number, priorityComboBox, pieChart,filePath);
                }
                pieChart.setVisible(true);
            }
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int index=projectComboBox.getSelectionModel().getSelectedIndex();
                switch (index){
                    case 0:
                        TriangleTest triangleTest = new TriangleTest();
                        if(priorityComboBox.getSelectionModel().getSelectedIndex()==0){

                            triangleTest.executeAll();
                        }
                        else {
                            triangleTest.executeTestCases(priorityComboBox.getSelectionModel().getSelectedIndex());
                        }
                        String filePath0="src/main/resources/triangleTestCases.xlsx";
                        int number0= ReadExcel.getNumberOfRow(filePath0);
                        changeAccordingToChoice(number0, priorityComboBox, pieChart,filePath0);
                        break;
                    case 1:
                        CalendarTest calendarTest = new CalendarTest();
                        if(priorityComboBox.getSelectionModel().getSelectedIndex()==0){
                            calendarTest.executeAll();
                        }
                        else {
                            calendarTest.executeTestCases(priorityComboBox.getSelectionModel().getSelectedIndex());
                        }
                        String filePath1="src/main/resources/calendarTestCases.xlsx";
                        int number1= ReadExcel.getNumberOfRow(filePath1);
                        changeAccordingToChoice(number1, priorityComboBox, pieChart,filePath1);
                        break;
                    case 2:
                        CommissionTest commissionTest = new CommissionTest();
                        if(priorityComboBox.getSelectionModel().getSelectedIndex()==0){

                            commissionTest.executeAll();
                        }
                        else {
                            commissionTest.executeTestCases(priorityComboBox.getSelectionModel().getSelectedIndex());
                        }
                        String filePath="src/main/resources/commissionTestCases.xlsx";
                        int number= ReadExcel.getNumberOfRow(filePath);
                        changeAccordingToChoice(number, priorityComboBox, pieChart,filePath);
                        break;
                    default:
                }
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("测试对象"), 0, 0);
        grid.add(projectComboBox, 1, 0);
        grid.add(new Label("执行测试用例编号"), 2, 0);
        grid.add(priorityComboBox, 3, 0);
        grid.add(pieChart, 0, 2, 4, 1);
        grid.add(button, 0, 3);
//        grid.add (notification, 1, 3, 3, 1);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeAccordingToChoice(int number, ComboBox<String> priorityComboBox, PieChart pieChart,String filePath) {
        List<String> triangle = new ArrayList<String>();
        triangle.add("All");
        for(int i=1;i<number;i++){
            triangle.add(String.valueOf(i));
        }
        priorityComboBox.setItems(FXCollections.observableArrayList(triangle));
        int numberOfPass=0;
        int numberOfWait=0;
        int numberOfFail=0;
        for(int i=2;i<=number;i++){
            if("pass".equals(ReadExcel.getDataCell(filePath,7,i)))
            {
                numberOfPass++;
            }
            else if("fail".equals(ReadExcel.getDataCell(filePath,7,i))){
                numberOfFail++;
            }
            else {
                numberOfWait++;
            }
        }
        ObservableList<PieChart.Data> pieChartDataUpdate = FXCollections.observableArrayList(
                new PieChart.Data("pass", numberOfPass),
                new PieChart.Data("fail", numberOfFail),
                new PieChart.Data("wait",numberOfWait));
        pieChart.setData(pieChartDataUpdate);
    }
}
