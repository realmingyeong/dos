package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable{

	@FXML
	private TextField txt1;

	@FXML
	private TextField txt2;

	@FXML
	private Button input;
	
	@FXML
	private Button delete; 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		input.setOnAction(e->insert(e));     //¶÷´Ù½Ä
		delete.setOnAction(e->delete(e));

	}
	
	public void insert(ActionEvent e){
		System.out.println("Input Clicked");
		UserDto dto= new UserDto(1, txt1.getText(), txt2.getText());
		Dao.insert(dto);
	}
	
	public void delete(ActionEvent e){
		System.out.println("Delete Clicked");
		String id =txt1.getText();
		Dao.delete(id);
	}
}