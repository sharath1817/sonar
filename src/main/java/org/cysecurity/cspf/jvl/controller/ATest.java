package org.cysecurity.cspf.jvl.model;

 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBConnect {
    public Connection connect(String path) throws IOException,ClassNotFoundException,SQLException
    {
        Properties properties=new Properties();
        properties.load(new FileInputStream(path));
        String dbuser=properties.getProperty("dbuser");
         String dbpass = properties.getProperty("dbpass");
       String dbfullurl = properties.getProperty("dburl")+properties.getProperty("dbname");
       String jdbcdriver = properties.getProperty("jdbcdriver");
            Connection con=null;
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



public class User getUser(Connection con, String user) throws SQLException {

  Statement stmt1 = null;
  Statement stmt2 = null;
  PreparedStatement pstmt;
  try {
    stmt1 = con.createStatement();
    ResultSet rs1 = stmt1.executeQuery("GETDATE()"); // Compliant; parameters not used here

    stmt2 = con.createStatement();
    ResultSet rs2 = stmt2.executeQuery("select FNAME, LNAME, SSN " +
                 "from USERS where UNAME=" + user);  // Noncompliant; parameter concatenated directly into query

    pstmt = con.prepareStatement("select FNAME, LNAME, SSN " +
                 "from USERS where UNAME=" + user);  // Noncompliant; parameter concatenated directly into query
    ResultSet rs3 = pstmt.executeQuery();

    //...
}

public class User getUserHibernate(org.hibernate.Session session, String userInput) {

  org.hibernate.Query query = session.createQuery(  // Compliant
            "FROM students where fname = " + userInput);  // Noncompliant; parameter binding should be used instead
  // ...
}