import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Nezter.Objects.User;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class MainClass {


	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		

		SQLServerDataSource sqlDs = new SQLServerDataSource();
		sqlDs.setIntegratedSecurity(false);
		sqlDs.setUser("userExamen");
		sqlDs.setPassword("Examen2021");				
		sqlDs.setIntegratedSecurity(false);	
		sqlDs.setEncrypt(true);
		sqlDs.setTrustServerCertificate(true);
		sqlDs.setServerName("PLUTARCO\\SQLEXPRESS");
		sqlDs.setPortNumber(1433); 
		sqlDs.setDatabaseName("NezterExam");
		System.out.println(sqlDs.getServerName());
		Connection dbConn = sqlDs.getConnection();      
		
        String stringConn = "SELECT * FROM [dbo].[User]";        
        
        Statement st = dbConn.createStatement();        
        ResultSet rs = st.executeQuery(stringConn);
		List<User> listUser= new ArrayList<User>();
        while (rs.next()) {
        	  int ID = rs.getInt("ID");
        	  String Name = rs.getString("Name");
        	  String Address = rs.getString("Address");
        	  int CellPhone = rs.getInt("CellPhone");
        	  int ZipCode = rs.getInt("ZipCode");
        	  //Assuming you have a user object
        	  User user = new User(ID,Name,Address,CellPhone,ZipCode);

        	  listUser.add(user);
        }
        
        for (User user : listUser) {
        	System.out.println(user.getName());
		}
	}

}
