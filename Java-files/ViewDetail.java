package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ViewDetail implements Initializable{
	
	private Stage stage;
    private Scene scene;
    private Parent root;
    
	@FXML
	private Button back;
	@FXML
	private TableView<ViewController> tvstudent;
	@FXML
	private TableColumn<ViewController, String> namecolumn;
	@FXML
	private TableColumn<ViewController, Integer> erpcolumn;
	@FXML
	private TableColumn<ViewController, String> fathercolumn;
	@FXML
	private TableColumn<ViewController, String> mothercolumn;
	@FXML
	private TableColumn<ViewController, Long> numbercolumn;
	@FXML
	private TableColumn<ViewController, String> yearcolumn;
	@FXML
	private TableColumn<ViewController, String> typecolumn;
	@FXML
	private TableColumn<ViewController, Integer> feescolumn;
	@FXML
	private TextField value;
	
	ObservableList<ViewController> observableList = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection con = connectNow.getConnection();
		
		String queryString = "select * from Student_details";
		
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			
			while(resultSet.next()) {
				
				String queryname = resultSet.getString("Name");
				Integer queryerp = resultSet.getInt("ERP_No");
				String queryfather = resultSet.getString("Father_Name");
				String querymother = resultSet.getString("Mother_Name");
				Long querynumber = resultSet.getLong("Mobile_Number");
				String queryyear = resultSet.getString("Year");
				String queryfeestype = resultSet.getString("Fees_Type");
				Integer queryfees = resultSet.getInt("Fees");
				
				observableList.add(new ViewController(queryname, queryerp, queryfather, querymother, querynumber, queryyear, queryfeestype, queryfees));

			}
			
			namecolumn.setCellValueFactory(new PropertyValueFactory<>("nameString"));
			erpcolumn.setCellValueFactory(new PropertyValueFactory<>("erp"));
			fathercolumn.setCellValueFactory(new PropertyValueFactory<>("fString"));
			mothercolumn.setCellValueFactory(new PropertyValueFactory<>("mString"));
			numbercolumn.setCellValueFactory(new PropertyValueFactory<>("number"));
			yearcolumn.setCellValueFactory(new PropertyValueFactory<>("yearString"));
			typecolumn.setCellValueFactory(new PropertyValueFactory<>("feestypeString"));
			feescolumn.setCellValueFactory(new PropertyValueFactory<>("fees"));
			
			tvstudent.setItems(observableList);
			
			FilteredList<ViewController> filterData = new FilteredList<>(observableList, b -> true);
			
			value.textProperty().addListener((observable,oldvalue,newvalue) -> {
				filterData.setPredicate(ViewController -> {
					
					if(newvalue.isEmpty() || newvalue.isBlank() || newvalue == null) {
						return true;
					}
					
					String searchString = newvalue.toLowerCase();
					
					if(ViewController.getNameString().toLowerCase().indexOf(searchString) > -1) {
						return true;
					}
					else if (ViewController.getErp().toString().indexOf(searchString) > -1) {
						return true;
					}
					else if(ViewController.getFString().toLowerCase().indexOf(searchString) > -1) {
						return true;
					}
					else if(ViewController.getMString().toLowerCase().indexOf(searchString) > -1) {
						return true;
					}
					else if(ViewController.getNumber().toString().indexOf(searchString) > -1) {
						return true;
					}
					else if(ViewController.getYearString().toLowerCase().indexOf(searchString) > -1) {
						return true;
					}
					else if(ViewController.getFeestypeString().toLowerCase().indexOf(searchString) > -1) {
						return true;
					}
					else if(ViewController.getFees().toString().indexOf(searchString) > -1) {
						return true;
					}
					else {
						return false;
					}
				});
			});
			
			SortedList<ViewController> sortedData = new SortedList<>(filterData);
			
			// Bind Sorted data with Table View
			sortedData.comparatorProperty().bind(tvstudent.comparatorProperty());
			
			// Apply filtered and sorted data to the table view
			tvstudent.setItems(sortedData);
		} 
		catch (Exception e) {
			e.printStackTrace();

		}	
				
	}
	
	@FXML
    void goback(ActionEvent event) throws IOException {
        
		root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
	    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   	scene = new Scene(root);
		stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
    }

}
