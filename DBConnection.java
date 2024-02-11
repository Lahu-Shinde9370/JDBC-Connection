import java.sql.*;
public class DBConnection {
	public static void main(String args[]) {
		oracle.jdbc.driver.OracleDrivr driver = new oracle.jdbc.driver.OracleDriver( );
		//Register the jdbc driver s\w
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("oracle:jdbc:thin:@localhost:1521:ORCL","system","tiger");
		if(con == null)
		System.out.println("Connection is not eastiblish");
		else
		System.out.println("Connection is eastiblish");
	}
}
