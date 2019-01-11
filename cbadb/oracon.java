package cbadb;

import java.sql.*;
import java.sql.SQLException;



public class oracon
{
	String JDBC_DRIVER;
        String DB_URL;
        String USER;
        String PWD; 
        Connection conn;
        Statement stmt;
        ResultSet rs;

public oracon()
{
 	JDBC_DRIVER ="oracle.jdbc.driver.OracleDriver";
        // NOTE MULTITENANT SERVICENAME SYNTAX vs SID
        DB_URL="jdbc:oracle:thin:@192.168.1.194:1521/pdbcba1";
        USER = "CBA";
        PWD = "kAren2003";
        conn=null;
        stmt=null;
        rs=null;

      try 
	{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

        System.out.println("<h4>Driver registered</h4>");

      } catch(Exception e) {
         //Handle errors for Class.forName
         System.out.println("Failed to register the driver");
                e.printStackTrace();
      }

}


public void connect()
{

	try
	{
	// Open a connection
		System.out.println("<h4>Opening connection to PDB...</h4>");
		 conn = DriverManager.getConnection(DB_URL, USER, PWD);
		System.out.println("<h4>Connected</h4>");
	}
	catch(SQLException se) 
	{
		 //Handle errors for JDBC
		 se.printStackTrace();
		 System.out.println(se.getMessage());

        } 
}


public void retrieveAsTable(String sql)
{

	try
	{
		 // Execute SQL query
         	stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

         // Extract data from result set
         System.out.println("<CENTER><TABLE BORDER=1>");
         System.out.println("<TR><TH>IMG ID</TH><TH>FILENAME</TH></TR>");
         int i=0;
         while(rs.next()){
                i++;
            //Retrieve by column name
            int img_id  = rs.getInt("img_id");
            String filename = rs.getString("filename");
             //Display values
            if(i/2*2 == i)
            {
                System.out.println("<TR bgcolor=#CCCCFF>");
            }
	    else
            {
                System.out.println("<TR bgcolor=#99C2C2>");
            }
            System.out.println("<TD ALIGN=RIGHT>" + img_id + "</td>");
            System.out.println("<TD>" + filename + "</td>");
            System.out.println("</TR>");
         } //end of while

        System.out.println("</TABLE>");
        System.out.println("</body></html>");


	}//endl of try
	catch(SQLException se) 
	{
         //Handle errors for JDBC
         se.printStackTrace();
         System.out.println(se.getMessage());

        } 

}

public void disconnect()
{

	try
	{
	conn.close();
	}
	 catch(SQLException se)
        {
         //Handle errors for JDBC
         se.printStackTrace();
         System.out.println(se.getMessage());

        }


}

}
