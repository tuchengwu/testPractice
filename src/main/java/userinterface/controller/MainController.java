package userinterface.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

/**
 * Created by tanzhenyu on 2017/6/14.
 */
public class MainController {

    @FXML
    public void handlerBtnClick(ActionEvent event) {
        Button btnSource = (Button) event.getSource();
        btnSource.setText("I am clicked!");
    }
}
