package application;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Sample3Controller implements Initializable{	
	   
     	private Stage stage;
	    private Scene scene;
	    private Parent root;
	    
	  @FXML
	    private Button buttonadd;

	    @FXML
	    private Button buttonback;

	    @FXML
	    private ChoiceBox<String> feeschoice;
	    private String[] fees = {"Merit", "Centac", "Management"};
	    String fee;
	   
	    
	    @FXML
	    private ChoiceBox<String> yearchoice;
	    private String[] years = {"I", "II", "III", "IV"};
	    String year;

	    @FXML
	    public TextField txterp;

	    @FXML
	    private TextField txtfname;

	    @FXML
	    private TextField txtmname;

	    @FXML
	    private TextField txtname;

	    @FXML
	    private TextField txtno;
	    
	    @FXML
	    private TextField txtfees;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			feeschoice.getItems().addAll(fees);
			feeschoice.setOnAction(this::getfees);
			feeschoice.setValue("Select Fees Type");
			
			yearchoice.getItems().addAll(years);
			yearchoice.setValue("Select Year");
		}
		
		 @FXML
		 void getfees(ActionEvent event) {
			 
			 int value = 0;
			 String fee = feeschoice.getValue();
			 switch (fee) {
			case "Merit":
				value = 450;
				txtfees.setText(String.valueOf(value));
				break;
				
			case "Centac":
			    value = 25000;
			    txtfees.setText(String.valueOf(value));
				break;
				
			case "Management":
				value = 50000;
				txtfees.setText(String.valueOf(value));
				break;	

			default:
				break;
			}
			 
		 }
		 
		  @FXML
		    void getyear(ActionEvent event) {
			  
		    }
		 
		 @FXML
		    void getdetails(ActionEvent event){
			 
			 DatabaseConnection dbConnection = new DatabaseConnection();
			 Connection connection = dbConnection.getConnection();
			 
			 String Name = txtname.getText();
			 String ERP_No = txterp.getText();
			 String Father_Name = txtfname.getText();
			 String Mother_Name = txtmname.getText();
			 String Mobile_Number = txtno.getText();
			 String Fees_Type = feeschoice.getValue();
			 String Fees = txtfees.getText();
			 String Year = yearchoice.getValue();
			 
			 try {
				 
				    PreparedStatement prst = connection.prepareStatement("insert into Student_details(Name,ERP_No,Father_Name,Mother_Name,Mobile_Number,Year,Fees_Type,Fees) values(?,?,?,?,?,?,?,?)");
				    prst.setString(1, Name);
				    prst.setString(2, ERP_No);
				    prst.setString(3, Father_Name);
				    prst.setString(4, Mother_Name);
				    prst.setString(5, Mobile_Number);
				    prst.setString(6, Year);
				    prst.setString(7, Fees_Type);
				    prst.setString(8, Fees);
				    
				    int a = prst.executeUpdate();
				
				    if (a == 1) {
				    	txtname.setText("");
				    	txterp.setText("");
				    	txtfname.setText("");
				    	txtmname.setText("");
				    	txtno.setText("");
				    	txtfees.setText("");
				    	yearchoice.setValue("Select Year");
				    	feeschoice.setValue("Select Fees Type");
				    	
				    	Alert alert = new Alert(AlertType.INFORMATION);
				    	alert.setContentText("Record Added");
				    	alert.setTitle("Message");
				    	alert.show();
				    	
				    }
				    else {
				    	System.out.println("Record Not added");
				    }
				
			} catch (SQLException e) {
				
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
