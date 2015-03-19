package rexcore.dataobjects;

import java.sql.*;
import rexcore.*;

public class Jobs
{
	/////--------COLUMN NAMES----------//////////
	public static final String _ID = "id";
	public static final String _JOB_DESCRIPTION = "job_description";
	public static final String _JOB_URL = "job_url";
	public static final String _DATE_POSTED = "date_posted";
	public static final String _APPLIED = "applied";
	public static final String _DATE_APPLIED = "date_applied";
	public static final String _RATING = "rating";
	public static final String _NOTES = "notes";
	public static final String _COMPANY_NAME = "company_name";
	public static final String _COMPANY_URL = "company_url";

	/////--------COLUMN PROPERTIES----------//////////
	public String id;
	public String job_description;
	public String job_url;
	public String date_posted;
	public String applied;
	public String date_applied;
	public String rating;
	public String notes;
	public String company_name;
	public String company_url;

	/////--------CONSTRUCTOR----------//////////
	public Jobs(){}

// may need to pass the connection to each method to avoid having many open connections at once.
	public static Jobs getById(String id) throws SQLException{

		ResultSet rs = DBUtilities.ExecuteStoredProc("sample", "dbo.spdnGetjobs", "id", id);
		if(!rs.next()){
			return null;
		}
		Jobs o = new Jobs();
		o.id = rs.getString("id");
		o.job_description = rs.getString("job_description");
		o.job_url = rs.getString("job_url");
		o.date_posted = rs.getString("date_posted");
		o.applied = rs.getString("applied");
		o.date_applied = rs.getString("date_applied");
		o.rating = rs.getString("rating");
		o.notes = rs.getString("notes");
		o.company_name = rs.getString("company_name");
		o.company_url = rs.getString("company_url");
		return o;
	}

}