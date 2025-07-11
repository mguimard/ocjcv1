package training.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/** 
 *  CREATE TABLE KEBAB(kebabId int, sauce varchar(255), PRIMARY KEY (kebabId));
 * */
public class Main {
	static Connection c;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "secret");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void rollbacks_transaction(String[] args) throws SQLException {
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		c.setAutoCommit(false);
		selectStmt.execute("INSERT INTO KEBAB VALUES(5, 'mayo')");
		selectStmt.execute("INSERT INTO KEBAB VALUES(6, 'ketchup')");
		c.rollback();
		
		//c.setAutoCommit(true);
		selectStmt.execute("INSERT INTO KEBAB VALUES(7, 'test')");
		c.commit();
		c.rollback();
	}
	
	public static void cursor_out_of_bounds(String[] args) throws SQLException {
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = selectStmt.executeQuery("SELECT * FROM KEBAB");
		
		rs.beforeFirst();
		rs.getInt("kebabId");		
	}
	
	public static void refresh(String[] args) throws SQLException {
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = selectStmt.executeQuery("SELECT * FROM KEBAB");
		
		Scanner s = new Scanner(System.in);
		while(true) {
			rs.absolute(1);
			rs.refreshRow();
			int kebabId = rs.getInt("kebabId");
			String sauce = rs.getString("sauce");
			System.out.println("Kebab " + kebabId + " sauce " + sauce);	
			
			
			System.out.println("Again? Y/N");
			String answer = s.nextLine();
			if(!answer.equalsIgnoreCase("y")) {
				break;
			}			
		}
		
		System.out.println("Fin de programme");		
	}
	
	public static void insert(String[] args) throws SQLException {	
		String insertTemplate = "INSERT INTO KEBAB VALUES(?,?)";
		PreparedStatement s = c.prepareStatement(insertTemplate);
		
		s.setInt(1, 2);
		s.setString(2, "autre");
		
		int rows = s.executeUpdate();
		
		System.out.println("Fin de programme: " + rows);
		
	}
	
	public static void delete_rows(String[] args) throws SQLException {
		
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = selectStmt.executeQuery("SELECT * FROM KEBAB");
		rs.absolute(1);
		
		int kebabId = rs.getInt("kebabId");
		System.out.println(kebabId);
		
		String q = "DELETE FROM KEBAB WHERE kebabId=" + kebabId;
		
		String qTemplate = "DELETE FROM KEBAB WHERE kebabId>?";
		PreparedStatement s = c.prepareStatement(qTemplate);
		s.setInt(1, 0);
		
		System.out.println(s.executeUpdate());		
	}
	
	public static void delete_row(String[] args) throws SQLException  {
		
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = selectStmt.executeQuery("SELECT * FROM KEBAB");
		
		rs.next();
		rs.deleteRow(); // dépend de l'implémentation du connecteur
		System.out.println("Deleted: " + rs.rowDeleted());
		
	}
	
	public static void updates(String[] args) throws SQLException {				
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = selectStmt.executeQuery("SELECT * FROM KEBAB");
	
		rs.next();
		rs.updateString("sauce", "algérienne"); // en mémoire seulement
		rs.updateRow();	 // commit en base	 // dépend de l'implémentation du connecteur
		System.out.println(rs.rowUpdated());
		c.close();
		selectStmt.close();
		rs.close();
		rs.close();		
		selectStmt.close();
		selectStmt.close();		
		c.close();
		c.close();
	}
	
	public static void delete_all_entries(String[] args) throws SQLException {
		
			String q = "DELETE FROM KEBAB";
			Statement s = c.createStatement();
			boolean res = s.execute(q);
			
			System.out.println(res);
	}
	
	
	public static void selectBasics(String[] args) throws ClassNotFoundException, SQLException  {	
		System.out.println(c.isValid(1000));
		System.out.println(c.isClosed());
		
		
		Statement selectStmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = selectStmt.executeQuery("SELECT * FROM KEBAB");
		
		while(rs.next()) {			
			int kebabId = rs.getInt("kebabId");
			String sauce = rs.getString("sauce");
			System.out.println("Kebab " + kebabId + " sauce " + sauce);	
		}	
		
		while(rs.previous()) {			
			int kebabId = rs.getInt("kebabId");
			String sauce = rs.getString("sauce");			
			System.out.println("Kebab " + kebabId + " sauce " + sauce);	
		}
		
		rs.absolute(1);
		int kebabId = rs.getInt("kebabId");
		String sauce = rs.getString("sauce");			
		System.out.println("Kebab " + kebabId + " sauce " + sauce);	
		
		rs.relative(10);
		kebabId = rs.getInt("kebabId");
		sauce = rs.getString("sauce");			
		System.out.println("Kebab " + kebabId + " sauce " + sauce);	
		
	}
}
