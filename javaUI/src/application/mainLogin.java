package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class mainLogin {
	public mainLogin() {
		
	}

    @FXML
    private Button student;

    @FXML
    private Button faculty;

    @FXML
    private Label warningLabel;
   

    @FXML
    void userFaculty(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("sample2login.fxml");
    }

    @FXML
    void userStudent(ActionEvent event) throws IOException {
    	Main m=new Main();
    	m.changeScene("sample1login.fxml");

    }

}
