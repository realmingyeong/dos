package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	   
	   @FXML
	   private TextField txt1;
	   
	   @FXML
	   private TextField txt2;
	   
	   @FXML
	   private TextArea txtF1;
	   
	   @FXML
	   private Button input;
	   
	   @FXML
	   private Button delete;
	   
	   @FXML
	   private Button select;
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	      input.setOnAction(e->insert(e));      
	   }
	   
	   public void insert(ActionEvent e){
	      UserDto dto= new UserDto(1, txt1.getText(), txt2.getText());
	      Dao.insert(dto);
	      
	      System.out.println(txt1.getText());
	   }
	}