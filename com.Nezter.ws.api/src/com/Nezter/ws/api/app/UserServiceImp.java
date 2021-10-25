package com.Nezter.ws.api.app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.*;


import javax.servlet.http.*;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.wsdl.extensions.soap.SOAPHeader;
import javax.wsdl.extensions.soap.SOAPHeaderFault;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.Nezter.Objects.User;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


@WebService(endpointInterface = "com.Nezter.ws.api.app.UserService")
public class UserServiceImp implements UserService,SOAPHandler<SOAPMessageContext>{
	
	
	
	@WebMethod
	public User getUserById(int idUser) throws Exception{
		//User user= new User(1,"test","address",12345,54321);
		return null;
	}

	@Override
	public List<User> getAll() throws Exception{
		
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
        return listUser;
        
        
	}

	@Override
	public Boolean updateUser(User user) throws Exception {
		String SPsql = "EXEC wsp_UploadUser ?,?,?,?,?"; 
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

			
		PreparedStatement ps = dbConn.prepareStatement(SPsql);
		ps.setEscapeProcessing(true);
		ps.setQueryTimeout(3000);
		ps.setString(1,user.getName());
		ps.setString(2,user.getAddress());
		ps.setInt(3,user.getCellPhone());
		ps.setInt(4,user.getZipCode());
		ps.setInt(5,user.getID());
		ResultSet rs = ps.executeQuery();
		
		if(rs.first()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteUser(int userId) throws Exception {
		
		String SPsql = "EXEC wsp_DeleteUser ?"; 
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
			
		PreparedStatement ps = dbConn.prepareStatement(SPsql);
		ps.setEscapeProcessing(true);
		ps.setQueryTimeout(3000);
		ps.setInt(1,userId);		
		ResultSet rs = ps.executeQuery();
		
		if(rs.first()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean insertUser(User user) throws Exception {
		String SPsql = "EXEC wsp_InsertUser ?,?,?,?"; 
		
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

			
		PreparedStatement ps = dbConn.prepareStatement(SPsql);
		ps.setEscapeProcessing(true);
		ps.setQueryTimeout(3000);
		ps.setString(1,user.getName());
		ps.setString(2,user.getAddress());
		ps.setInt(3,user.getCellPhone());
		ps.setInt(4,user.getZipCode());		
		ResultSet rs = ps.executeQuery();
		
		if(rs.first()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Map<String, List<String>> headers = new HashMap<>();
		List<String> liste= new ArrayList<String>();
		liste.add("*");
		headers.put("Access-Control-Allow-Origin", liste);
		context.put(MessageContext.HTTP_REQUEST_HEADERS, liste);
		
	      return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
