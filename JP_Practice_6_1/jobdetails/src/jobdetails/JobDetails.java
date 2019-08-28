package jobdetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class JobDetails {

	public static void main(String[] args) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:orcluser/jdbcuser@localhost:1521:xepdb1");
		Connection conn = ods.getConnection();

		Statement stmt=conn.createStatement();

		// Execute a statement
		ResultSet rset= stmt.executeQuery("Select JOB_ID, JOB_TITLE,MIN_SALARY,MAX_SALARY from jobs");

		// Iterate through the result and print the employee names and ID
		System.out.println("Job ID" + "\t" +"JOB Title"+"\t"+"Min Salary"+"\t"+"Max Salary");
		System.out.println();
		while (rset.next())
			System.out.println(rset.getString(1) 
					+ "\t" +rset.getString(2)
					+ "\t"+rset.getString(3)
					+ "\t"+rset.getString(4));
		//endwhile
		
		//close the resources
		rset.close();
		stmt.close();
	}//end method main
}//end class JobDetails
