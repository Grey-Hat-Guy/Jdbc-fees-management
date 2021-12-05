package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class UpdateDetail {
	
	private Stage stage;
    private Scene scene;
    private Parent root;
	
	DatabaseConnection dbconnection = new DatabaseConnection();
	Connection connection = dbconnection.getConnection();
	
	@FXML
	private TextField updatename, updateerp, updatefname, updatemname, updateno, updateyear, updatefeestype, updatefees, entererp;
	
	@FXML
	private Button okbtn;
	
	@FXML
	private Button backbtn;
	
	@FXML
	private Button updatebtn;
	
	@FXML
    void backbutton(ActionEvent event) throws IOException {
        
		root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene = new Scene(root);
		stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
    }

    @FXML
    void okbutton(ActionEvent event) {
 
    	
    	try {
    		
    		String erpString = entererp.getText();	
    		
    		PreparedStatement prst = connection.prepareStatement("select * from Student_details where ERP_No=?");
    		prst.setString(1, erpString);
    		ResultSet rs = prst.executeQuery();
    		
    		if (rs.next() == true) {
    			
				updatename.setText(rs.getString(1));
				updateerp.setText(rs.getString(2));
				updatefname.setText(rs.getString(3));
				updatemname.setText(rs.getString(4));
				updateno.setText(rs.getString(5));
				updateyear.setText(rs.getString(6));
				updatefeestype.setText(rs.getString(7));
				updatefees.setText(rs.getString(8));
			}
    		
		} 
    	catch (Exception e) {
			e.printStackTrace();
			
		}	
    	
    }

    @FXML
    void updatebutton(ActionEvent event) {
    	String erpString = entererp.getText();
    	 String Name = updatename.getText();
		 String ERP_No = updateerp.getText();
		 String Father_Name = updatefname.getText();
		 String Mother_Name = updatemname.getText();
		 String Mobile_Number = updateno.getText();
		 String Year = updateyear.getText();
		 String Fees_Type = updatefeestype.getText();
		 String Fees = updatefees.getText();
		 
		 
		 try {
			 
			 PreparedStatement prst = connection.prepareStatement("update Student_details set Name=?, ERP_No=?, Father_Name=?, Mother_Name=?, Mobile_Number=?, Year=?, Fees_Type=?, Fees=? where ERP_No=?");
			 prst.setString(1, Name);
			 prst.setString(2, ERP_No);
			 prst.setString(3, Father_Name);
			 prst.setString(4, Mother_Name);
			 prst.setString(5, Mobile_Number);
			 prst.setString(6, Year);
			 prst.setString(7, Fees_Type);
			 prst.setString(8, Fees);
			 prst.setString(9, erpString);
			    
			    int a = prst.executeUpdate();
			
			    if (a == 1) {
			    	updatename.setText("");
			    	updateerp.setText("");
			    	updatefname.setText("");
			    	updatemname.setText("");
			    	updateno.setText("");
			    	updateyear.setText("");
			    	updatefeestype.setText("");
			    	updatefees.setText("");
			    	entererp.setText("");
			    	
			    	Alert alert = new Alert(AlertType.INFORMATION);
			    	alert.setContentText("Record Updated");
			    	alert.setTitle("Message");
			    	alert.show();
			    	
			    }
			    else {
			    	System.out.println("Record Not Updated");
			    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
