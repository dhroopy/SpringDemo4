package com.online.bank;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
	
public class JDBC{
	// JDBC driver name and database URL
	// static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	// java.sql.Driver or org.h2.Driver;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
	static final String USER = "root";
	static final String PASS = "Welcome123";

	public static boolean loginvali(String uname, String pw, HttpServletRequest request) {
		Connection conn = null;
		Statement stmt = null;
		System.out.println("IN loginvali");
		try {
			// STEP 2: Register JDBC driver
			System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();

			String select = "Select Userid, Fname, Lname, Pass from AMNA where Userid='" + uname + "'";
			System.out.println(select);

			ResultSet rs = stmt.executeQuery(select);
			// STEP 5: Extract data from result set
			System.out.println("Executing the Query");
			while (rs.next()) {
				// Retrieve by column name
				String userid = rs.getString("Userid");
				String pass = rs.getString("Pass");
				String Fname = rs.getString("Fname");
				String Lname = rs.getString("Lname");
				String Name = Fname + " " + Lname;
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("Fname", Fname);
				session.setAttribute("Lname", Lname);
				session.setAttribute("Name", Name);
				System.out.println("Userid: " + userid + " Pass :" + pass + " Name :" + Name);

				if (uname.equals(userid) && pw.equals(pass)) {
					System.out.println("OK");
					return true;
				} else {
					System.out.println("Not OK");
					return false;
				}
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

	public static boolean adloginvali(String uname, String pw) {
		Connection conn = null;
		Statement stmt = null;
		System.out.println("IN adloginvali");
		try {
			// STEP 2: Register JDBC driver
			System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();

			String select = "Select Userid, Pass, Ctype from AMNA where Userid='" + uname + "'";
			System.out.println(select);

			ResultSet rs = stmt.executeQuery(select);
			// STEP 5: Extract data from result set
			System.out.println("Executing the Query");
			while (rs.next()) {
				// Retrieve by column name
				String userid = rs.getString("Userid");
				String pass = rs.getString("Pass");
				String Ctype = rs.getString("Ctype");
				System.out.println("Admin " + userid + Ctype);
				if (uname.equals(userid) && pw.equals(pass) && Ctype.equals("A")) {
					return true;
				} else {
					return false;
				}
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

	public static String[] Balin(String un, String Accttype) {
		Connection conn = null;
		Statement stmt = null;
		String [] Retval = new String[2];
		System.out.println("IN Balin");
		try {
				System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();
			String select = "Select Userid, Acct, Accttype, Bal from AMNA Join AMBS on AMNA.CustID=AMBS.CustID where (Userid='"+ un +"' and Accttype='"+Accttype+"');";
				System.out.println(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next())
			{
				System.out.println("Executing the Query");
				String Acct = rs.getString("Acct");
				String Bal = rs.getString("Bal");
				Retval[0] = Acct;
				Retval[1] = Bal;
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return Retval;
		//return null;
	}// end main

	public static LinkedList<String> Txn(String un, String Accttype) {
		Connection conn = null;
		Statement stmt = null;
		//LinkedList<LinkedList<String>> ValR = new LinkedList<LinkedList<String>>();
		LinkedList<String> ValC = new LinkedList<String>();
		System.out.println("IN Txn");
		try {
				System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();
			String select = "Select AMBS.Acct, Accttype, TxnAmt, ARTD.Bal, Txndate from AMNA, AMBS, ARTD where AMNA.CustID=AMBS.CustID and AMBS.Acct=ARTD.Acct and (Userid='"+ un +"' and Accttype='"+Accttype+"');";
			System.out.println(select);
			ResultSet rs = stmt.executeQuery(select);
			System.out.println("Executing the Query");
			//int i = 0;
			while(rs.next())
			{
				ValC.add(rs.getString("Acct"));
				ValC.add(rs.getString("Accttype"));
				ValC.add(rs.getString("TxnAmt"));
				ValC.add(rs.getString("Bal"));
				ValC.add(rs.getString("Txndate"));
				/*ValR.add(ValC);
				System.out.println(ValR);
				ValC.remove(rs.getString("Acct"));
				ValC.remove(rs.getString("Accttype"));
				ValC.remove(rs.getString("TxnAmt"));
				ValC.remove(rs.getString("Bal"));
				ValC.remove(rs.getString("Txndate"));*/
			}
			//ValR.add(ValC);
			System.out.println(ValC);
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return ValC;
		//return null;
	}// end main

	public static LinkedList<String> Adws() {
		Connection conn = null;
		Statement stmt = null;
		//LinkedList<LinkedList<String>> ValR = new LinkedList<LinkedList<String>>();
		LinkedList<String> ValC = new LinkedList<String>();
		System.out.println("IN Adws");
		try {
				System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();
			String select = "Select CONCAT(fname, ' ', lname) as Name, Userid, Acct, Accttype, Approval from AMNA, AMBS where AMNA.CustID=AMBS.CustID and (Approval='N');";
			System.out.println(select);
			ResultSet rs = stmt.executeQuery(select);
			System.out.println("Executing the Query");
			while(rs.next())
			{
				ValC.add(rs.getString("Name"));
				ValC.add(rs.getString("Userid"));
				ValC.add(rs.getString("Acct"));
				ValC.add(rs.getString("Accttype"));
				ValC.add(rs.getString("Approval"));
			}
			System.out.println(ValC);
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return ValC;
		//return null;
	}// end main

	public static boolean withd(String un, String Accttype, int withdamt) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		System.out.println("IN withd");
		try {
				System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();
			String select = "Select Userid, Acct, Accttype, Bal from AMNA Join AMBS on AMNA.CustID=AMBS.CustID where (Userid='"+ un +"' and Accttype='"+Accttype+"');";
				System.out.println(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next())
			{
				System.out.println("Executing the Query");
				String Userid = rs.getString("Userid");
				String Acct = rs.getString("Acct");
				String Accttyp = rs.getString("Accttype");
				int Bal = rs.getInt("Bal");
				if (Userid.equals(un) && Accttyp.equals(Accttype)) {
					if (Bal >= withdamt) {
						int Bal2 = Bal - withdamt;
						String insert = "UPDATE AMBS SET `Bal`='" + Bal2 +" ' WHERE `Acct`='"+ Acct +"';";
						System.out.println(insert);
						stmt1 = (PreparedStatement) conn.prepareStatement(insert);
						stmt1.executeUpdate();
						stmt1.close();
	
						String insert2 = "INSERT INTO ARTD (`Acct`, `TxnType`, `TxnAmt`, `Bal`, `PrevBal`) VALUES ('"+ Acct +"', 'W', '"+ withdamt +"', '"+ Bal2 +"', '"+ Bal +"');";
						System.out.println(insert2);
						stmt2 = (PreparedStatement) conn.prepareStatement(insert2);
						stmt2.executeUpdate();
						stmt2.close();
						return true;
					}
					else {
						return false;
					}
				}
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt1 != null)
					stmt1.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt2 != null)
					stmt2.close();
			} catch (SQLException se2) {
			} // nothing we can do

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

	public static int xfr(String un, String SAccttype, String DAccttype, int Xframt, String memo) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		PreparedStatement stmt4 = null;
		int val = 0;
		int Bal = 0;
		int SBal = 0;
		int DBal = 0;
		int Bal2 = 0;
		int Bal3 = 0;
		String SAcct = null; 
		String DAcct = null;
		System.out.println("IN xfr");
		try {
				System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();
			String select = "Select Userid, Acct, Accttype, Bal from AMNA Join AMBS on AMNA.CustID=AMBS.CustID where (Userid='"+ un +"');";
				System.out.println(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next())
			{
				System.out.println("Executing the Query");
				String Userid = rs.getString("Userid");
				String Acct = rs.getString("Acct");
				String Accttyp = rs.getString("Accttype");
				Bal = rs.getInt("Bal");
				System.out.println("Result :" + Userid + Acct + Accttyp + Bal);
				if (Userid.equals(un)) {
					if (Accttyp.equals(SAccttype)) {
						SAcct = Acct;
						SBal = Bal;
						if (SBal >= Xframt) {
							Bal2 = SBal - Xframt;
						} else {
							val = 1; //nsf
							System.out.println("Val :" + val);
						}
					}
					if(Accttyp.equals(DAccttype)) {
						DAcct = Acct;
						DBal = Bal;
						Bal3 = DBal + Xframt;
					} 
				}
			}
			if (SAcct == null) {
				val = 2; //"srcntfnd";
				System.out.println("Val :" + val);
			}
			if (DAcct == null) {
				val = 3; //"destntfnd";
				System.out.println("Val :" + val);
			}
			if (val == 0) {
				String insert = "UPDATE AMBS SET `Bal`='" + Bal2 +" ' WHERE `Acct`='"+ SAcct +"';";
				System.out.println(insert);
				stmt1 = (PreparedStatement) conn.prepareStatement(insert);
				stmt1.executeUpdate();
				stmt1.close();

				String insert2 = "UPDATE AMBS SET `Bal`='" + Bal3 +" ' WHERE `Acct`='"+ DAcct +"';";
				System.out.println(insert2);
				stmt2 = (PreparedStatement) conn.prepareStatement(insert2);
				stmt2.executeUpdate();
				stmt2.close();
				
				String insert3 = "INSERT INTO ARTD (`Acct`, `TxnType`, `TxnAmt`, `Bal`, `PrevBal`, `Xfrmemo`) VALUES ('"+ SAcct +"', 'XW', '"+ Xframt +"', '"+ Bal2 +"', '"+ SBal +"','"+memo+"');";
				System.out.println(insert3);
				stmt3 = (PreparedStatement) conn.prepareStatement(insert3);
				stmt3.executeUpdate();
				stmt3.close();

				String insert4 = "INSERT INTO ARTD (`Acct`, `TxnType`, `TxnAmt`, `Bal`, `PrevBal`, `Xfrmemo`) VALUES ('"+ DAcct +"', 'XD', '"+ Xframt +"', '"+ Bal3 +"', '"+ DBal +"','"+memo+"');";
				System.out.println(insert4);
				stmt4 = (PreparedStatement) conn.prepareStatement(insert4);
				stmt4.executeUpdate();
				stmt4.close();
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			stmt1.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt1 != null)
					stmt1.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt2 != null)
					stmt2.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt3 != null)
					stmt3.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt4 != null)
					stmt4.close();
			} catch (SQLException se2) {
			} // nothing we can do

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return val;
	}// end main

	public static boolean depo(String un, String Accttype, int depo) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		System.out.println("IN depo");
		try {
				System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);
				System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();
			String select = "Select Userid, Acct, Accttype, Bal from AMNA Join AMBS on AMNA.CustID=AMBS.CustID where (Userid='"+ un +"' and Accttype='"+Accttype+"');";
				System.out.println(select);
			ResultSet rs = stmt.executeQuery(select);
			while(rs.next())
			{
				System.out.println("Executing the Query");
				String Userid = rs.getString("Userid");
				String Acct = rs.getString("Acct");
				String Accttyp = rs.getString("Accttype");
				int Bal = rs.getInt("Bal");
				if (Userid.equals(un) && Accttyp.equals(Accttype)) {
						int Bal2 = Bal + depo;
						String insert = "UPDATE AMBS SET `Bal`='" + Bal2 +" ' WHERE `Acct`='"+ Acct +"';";
						System.out.println(insert);
						stmt1 = (PreparedStatement) conn.prepareStatement(insert);
						stmt1.executeUpdate();
						stmt1.close();
	
						String insert2 = "INSERT INTO ARTD (`Acct`, `TxnType`, `TxnAmt`, `Bal`, `PrevBal`) VALUES ('"+ Acct +"', 'D', '"+ depo +"', '"+ Bal2 +"', '"+ Bal +"');";
						System.out.println(insert2);
						stmt2 = (PreparedStatement) conn.prepareStatement(insert2);
						stmt2.executeUpdate();
						stmt2.close();
						return true;
				}
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();

			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt1 != null)
					stmt1.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt2 != null)
					stmt2.close();
			} catch (SQLException se2) {
			} // nothing we can do

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

	public static boolean mmvali(String un, String mmn) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// STEP 3: Open a connection
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			// STEP 4: Execute a query
			stmt = (Statement) conn.createStatement();

			String select = "Select Userid, MMname from amna where Userid='" + un + "'";
			System.out.println(select);

			ResultSet rs = stmt.executeQuery(select);
			// STEP 5: Extract data from result set
			System.out.println("Executing the Query");
			while (rs.next()) {
				String id = rs.getString("Userid");
				String mmname = rs.getString("MMname");

				System.out.println("Userid: " + id + "mmn :" + mmn);

				if (un.equals(id) && mmn.equals(mmname)) {
					System.out.println("OK");
					return true;
				} else {
					System.out.println("Not OK");
					return false;
				}
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

	public static boolean register(String uname, String pass, String dob, String fname, String lname, String mmname,String email, String add, String ssn, String sex, String accttype) {
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		Statement stmt3 = null;
		System.out.println("IN register");
		try {
			// STEP 2: Register JDBC driver
			System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Building Query to update DB2 table.
			String insert = "INSERT INTO AMNA (`Userid`, `Pass`, `Fname`, `Lname`, `MMname`, `Email`, `SSN`, `Bdate`, `Address`, `Sex`, `Approval`) "
					+ "VALUES ('" + uname + "', '" + pass + "', '" + fname + "', '" + lname + "', '" + mmname + "', '"
					+ email + "', '" + ssn + "', '" + dob + "', '" + add + "', '" + sex + "','Y');";
			System.out.println(insert);

			// STEP 5: Execute a query
			System.out.println("Executing the Query");
			stmt1 = (PreparedStatement) conn.prepareStatement(insert);
			stmt1.executeUpdate();
			
			//Get CustID just created 
			stmt3 = (Statement)conn.createStatement(); 
			String select ="SELECT CustID FROM AMNA ORDER BY CustID DESC LIMIT 1;";
			System.out.println(select); 
			ResultSet rs2 = stmt3.executeQuery(select); 
			int CustID = rs2.getInt("CustID");
			System.out.println("Cust # " + CustID);
			 
			String insert2 = "INSERT INTO AMBS (CustID, Accttype, Bal) VALUES ('" + CustID + "','"+ accttype + "','0');";
			System.out.println(insert2);
			stmt2 = (PreparedStatement) conn.prepareStatement(insert2);
			stmt2.executeUpdate();

			// STEP 6: Clean-up environment
			stmt1.close();
			stmt2.close();
			conn.close();
			return true;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt1 != null)
					stmt1.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt2 != null)
					stmt2.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (stmt3 != null)
					stmt3.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

	public static boolean Admin() {
		Connection conn = null;
		Statement stmt = null;
		System.out.println("IN Admin");
		try {
			// STEP 2: Register JDBC driver
			System.out.println("Loading JDBC Drivers");
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Accessing DB...");
			stmt = (Statement) conn.createStatement();

			String select = "Select Userid, Fname, Approval, Acct, Accttype from AMNA Join AMBS on AMNA.CustID=AMBS.CustID where Approval='Y';";
			System.out.println(select);

			ResultSet rs = stmt.executeQuery(select);
			//HashSet<String> Entry = new HashSet<String>();
			// STEP 5: Extract data from result set
			System.out.println("Executing the Query");

			List<List<String>> Entry = new ArrayList<List<String>>();
				int col = -1;
				List<String> row = null;
				while(rs.next())
				{
				  if (col != rs.getInt(4))
				  {
				    col = rs.getInt(4);
				    row = new ArrayList<String>();
				    Entry.add((List<String>) row);
				  }
				  row.add(rs.getString("Userid"));
				  row.add(rs.getString("Fname"));
				  row.add(rs.getString("Acct"));
				  row.add(rs.getString("Accttype"));
				  row.add(rs.getString("Approval"));
				  System.out.println(row);
				}
				
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return false;
	}// end main

}// end FirstExample 