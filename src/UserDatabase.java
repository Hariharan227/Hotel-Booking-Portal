import java.sql.*;
import javax.swing.*;

public class UserDatabase 
{
	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hari2\\eclipse-workspace\\First\\User.sqlite");
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
}
