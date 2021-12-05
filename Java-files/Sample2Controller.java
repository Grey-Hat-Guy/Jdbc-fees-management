package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Sample2Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private Button btnadd;

    @FXML
    private Button btndel;

    @FXML
    private Button btnview;
    

    @FXML
    private Button btnupdate;

    @FXML
    void adddetails(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Sample3.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Add Student Details");
	    stage.setResizable(false);
		stage.show();
    }
    
    @FXML
    void deletedetails(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Sample4.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Delete Student ID");
	    stage.setResizable(false);
		stage.show();
    }
    
    @FXML
    void updatedetails(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Update.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Update Student Details");
	    stage.setResizable(false);
		stage.show();
    }

    @FXML
    void viewdetails(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("View.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("View Student Details");
	    stage.setResizable(false);
		stage.show();
    }

}
