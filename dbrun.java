
import java.sql.*;
import cbadb.oracon;
import cbadb.netezzacon;

public class dbrun
{

	public static void main(String[] args)
	{
		System.out.println("Connecting to O R A C L E .. ");
		oracon ora= new oracon();
		ora.connect();
		String sql="SELECT img_id, filename FROM IMGS ORDER BY filename";
		ora.retrieveAsTable(sql);
		ora.disconnect();	

		System.out.println("</CENTER>");
		System.out.println("Connecting to N E T E Z Z A ..");
		netezzacon nzcon=new netezzacon();

		nzcon.connect();
		sql="SELECT ID,RECORD from cba.testload LIMIT 200";
		nzcon.retrieveAsTable(sql);
		nzcon.disconnect();
	} 

}
