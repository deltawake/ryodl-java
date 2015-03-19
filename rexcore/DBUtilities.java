package rexcore;

import java.sql.*;
import java.util.*;

public class DBUtilities
{
	public static final String DBUSER = "";
	public static final String DBPWD = "";

	public static ResultSet ExecuteStoredProc(String sDbName, String sStoredProcName,
		String sSingleParamName, String sSingleParamValue)
		throws SQLException
	{
		return ExecuteStoredProc(sDbName, sStoredProcName, sSingleParamName, sSingleParamValue, DBUSER, DBPWD);
	}
	
	public static ResultSet ExecuteStoredProc(String sDbName, String sStoredProcName,
		String sSingleParamName, String sSingleParamValue, String sDbUser, String sDbPassword)
		throws SQLException
	{
		ArrayList<String> paramNames = new ArrayList<String>();
		paramNames.add(sSingleParamName);
		ArrayList<String> paramValues = new ArrayList<String>();
		paramValues.add(sSingleParamValue);

		return ExecuteStoredProc(sDbName, sStoredProcName, paramNames, paramValues, sDbUser, sDbPassword);
	}

	public static ResultSet ExecuteStoredProc(String sDbName, String sStoredProcName,
		ArrayList<String> ParamNames, ArrayList<String> ParamValues, String sDbUser, String sDbPassword)
		throws SQLException
	{

		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=" + sDbName + ";user=" + sDbUser + ";password=" + sDbPassword + ";";
		System.out.println("Connection String: " + connectionUrl);
		
		Connection cnn = DriverManager.getConnection(connectionUrl);
		
		PreparedStatement stmt = cnn.prepareStatement("EXEC " + sStoredProcName + " ?");
		stmt.setEscapeProcessing(true); // not sure what this does
		stmt.setString(1, ParamValues.get(0)); 
		ResultSet rs = stmt.executeQuery();
		return rs;
	}


}