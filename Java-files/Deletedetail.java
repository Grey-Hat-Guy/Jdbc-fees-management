package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;

public class Deletedetail {
	
	private Stage stage;
    private Scene scene;
    private Parent root;
	
    @FXML
    private Button bckbtn;
    
	@FXML
	private TextField erpget;
	
	@FXML
	private Button delerp;

	public void Deleteerp(ActionEvent event) {
		
		DatabaseConnection databaseConnection = new DatabaseConnection();
		Connection conn = databaseConnection.getConnection();
		
		try {
			
			String erpString = erpget.getText();
				
			PreparedStatement prst = conn.prepareStatement("delete from Student_details where ERP_No=?");
			prst.setString(1, erpString);
			int k = prst.executeUpdate();
			
			if (k >= 1) {
				erpget.setText("");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Record Deleted");
		    	alert.setTitle("Message");
		    	alert.show();
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Record not Deleted");
				alert.setTitle("Warning");
				alert.show();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 @FXML
	    void getback(ActionEvent event) throws IOException {
            
		    root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
		    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   	scene = new Scene(root);
			stage.setScene(scene);
		    stage.setResizable(false);
		    stage.show(); 
	    }
}
