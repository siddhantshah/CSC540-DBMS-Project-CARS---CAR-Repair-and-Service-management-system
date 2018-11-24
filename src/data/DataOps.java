package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataOps {
	private static final String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	private static final String user = "dnag";
	private static final String passwd = "200206242";	
	private static DataOps dataObject;
	private static Object mutex = new Object();
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static DataOps getInstance() {
		if(dataObject==null) {
			synchronized (mutex) {
				if(dataObject == null)
					dataObject = new DataOps();
			}
		}
		return dataObject;
	}
	
	public static void destroyInstance() {
		if(dataObject!=null) {
			close(rs);
			close(stmt);
			close(conn);
		}
		
	}
	
	private DataOps() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection(jdbcURL, user, passwd);
		} catch (Exception e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		} 
	}
	
	public synchronized boolean insertInto(String query) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);


		} catch (SQLException e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return true;
	}
	
	public synchronized ResultSet retrieve(String query) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);


		} catch (SQLException e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		} 
		return rs;
	 
	}
	public static void close(Connection conn) {
		if(conn != null) {
			try { conn.close(); } catch(Throwable whatever) {}
		}
	}

	public static void close(Statement st) {
		if(st != null) {
			try { st.close(); } catch(Throwable whatever) {}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try { rs.close(); } catch(Throwable whatever) {}
		}
	}
	
}
