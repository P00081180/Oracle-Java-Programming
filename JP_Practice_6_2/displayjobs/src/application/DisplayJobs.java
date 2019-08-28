package application;
	
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class DisplayJobs extends Application {
	private TextArea ta = new TextArea();
	private Button btShowJobs = new Button("Show Records");
	private ComboBox<String> cboTableName = new ComboBox<>();
	  
	private Statement stmt;
	  
	@Override 
	public void start(Stage primaryStage) {   
		//establish the database connection
		initializeDB();

	    //display the JOB Data 
	    btShowJobs.setOnAction(e -> showData());    

		HBox hBox = new HBox(10);
	    hBox.getChildren().addAll(new Label("Table Name"), cboTableName, btShowJobs);
	    hBox.setAlignment(Pos.CENTER);
	    
	    BorderPane bpane = new BorderPane();
	    bpane.setCenter(new ScrollPane(ta));
	    bpane.setTop(hBox);
	    
	    Scene scene = new Scene(bpane, 420, 180);
	    primaryStage.setTitle("Dispaly JOB Information"); 
	    primaryStage.setScene(scene); 
	    primaryStage.show(); 
	  }//end method start

	private void initializeDB() {
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@localhost:1521/xepdb1");
			Connection conn = ods.getConnection();

			stmt = conn.createStatement();
	      
			DatabaseMetaData dbMetaData = conn.getMetaData();

			ResultSet rsTables = dbMetaData.getTables(null, null, "JOB%", new String[] {"TABLE"});
			while (rsTables.next()) {
				cboTableName.getItems().add(rsTables.getString("TABLE_NAME"));
			}//end while
			cboTableName.getSelectionModel().selectFirst();
		}catch (Exception ex) {
			ex.printStackTrace();
	    }//end try catch
	}//end method initializeDB

	private void showData() {
		ta.clear();
	    String tableName = cboTableName.getValue();
	    try {
	    	String queryString = "select * from " + tableName;

	    	ResultSet resultSet = stmt.executeQuery(queryString);

	    	ResultSetMetaData rs = resultSet.getMetaData();
	    	for (int i = 1; i <= rs.getColumnCount(); i++) {
	    		ta.appendText(rs.getColumnName(i) + "    ");
	    	}//end for
	    	ta.appendText("\n");

	    	while (resultSet.next()) {
	    		for (int i = 1; i <= rs.getColumnCount(); i++)
	    			ta.appendText(resultSet.getObject(i) + "     ");
	    			ta.appendText("\n");
	    		}//endfor
	    	//endwhile	
	    }catch (SQLException e) {
	    	e.printStackTrace();
	    }//end try catch
	 }//end method showData
	  	
	public static void main(String[] args) {
		launch(args);
	}//end method main
}//end class DisplayJobs
