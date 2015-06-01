package com.csams.intlops.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.csams.intlops.beans.User;

public abstract class AbstractDAO {

	protected Connection connection;
	
	
	protected void dbSetup() throws Exception{
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "eintern",
					"pwd123");
		}
		catch(Exception e){
			throw new Exception("Database Connection could not be established");
			
		}
	}
	
	protected void dbShutdown() throws Exception{
		
		if(connection !=null){
			try{
				connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	
}
