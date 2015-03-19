import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import rexcore.dataobjects.*;

public class HelloWorld
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		System.out.println("Hello friends.");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

/*		String connectionUrl = "jdbc:sqlserver://localhost:1434;databaseName=sample;user=;password=;";
		Connection cnn = DriverManager.getConnection(connectionUrl);
		
		// simple select statement
		Statement stmt = cnn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM jobs");

		int rowCount = 0;

		while(rs.next()){
			System.out.println("Row : " + rowCount++ + " " + rs.getString("job_description"));
		}

		// now let's try a stored procedure
		PreparedStatement stmt2 = cnn.prepareStatement("EXEC spdnGetjobs ?");
		stmt2.setEscapeProcessing(true); // not sure what this does
		stmt2.setString(1, "6"); // retrieve job id 6
		ResultSet rs2 = stmt2.executeQuery();

		rowCount = 0;

		while(rs2.next()){
			System.out.println("Row : " + rowCount++ + " " + rs2.getString("job_description"));
		}

*/
		Jobs job = Jobs.getById("6");
		System.out.println("Job Description: " + job.job_description);
		Jobs job2 = Jobs.getById("4");
		System.out.println("Job Description: " + job2.job_description);

	}
}