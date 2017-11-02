/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cysecurity.cspf.jvl.model;

 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author breakthesec
 */
public class DBConnect {
    public Connection connect(String path) throws IOException,ClassNotFoundException,SQLException
    {
		String query=null;
		String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	connection = DriverManager.getConnection("jdbc:odbc:projectDB");

	query = "SELECT * FROM Users WHERE user_id ='" + userid + "' AND password ='" + password +"'";

	PreparedStatement ps = connection.prepareStatement(query);
	ResultSet users = ps.executeQuery();

	if(users.next()){

	//some thing here
	}
	else{

		}
		 String dbpass=null;
		 String con=null;
        Properties properties=new Properties();
        properties.load(new FileInputStream(path));
        String dbuser=properties.getProperty("dbuser");
         String dbpass = properties.getProperty("dbpass");
       String dbfullurl = properties.getProperty("dburl")+properties.getProperty("dbname");
       String jdbcdriver = properties.getProperty("jdbcdriver");
           
			
		 
          try
                   {
                    Class.forName(jdbcdriver);
                    con= DriverManager.getConnection(dbfullurl,dbuser,dbpass);
                    return con;
                   }
                   finally
                    {
                                 
                    }      
    }
}