package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {
		
		private Stage stage;
		private Scene scene;
		private Parent root;
		
	    @FXML
	    private Button button;

	    @FXML
	    private PasswordField txtpass;
	    

	    @FXML
	    private TextField txtuser;

	    @FXML
	public void loginbtn(ActionEvent e) throws IOException {
	
	    	 if(txtuser.getText().toString().equals("Admin0101") && txtpass.getText().equals("admin")){
	    		 
	    	    root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
			    stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			    scene = new Scene(root);
			    stage.setScene(scene);
			    stage.setResizable(false);
			    stage.show();
			    
		}
		
		else if (txtuser.getText().isEmpty() && txtpass.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Please enter your data");
			alert.setTitle("Message");
			alert.show();
			
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Wrong username or Password");
			alert.setTitle("Message");
			alert.show();
			
		}
	}
	    
	
}
