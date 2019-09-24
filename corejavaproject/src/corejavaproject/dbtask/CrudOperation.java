package corejavaproject.dbtask;
import java.sql.*;
public class CrudOperation {
private static Connection con;
public static void closeConnection()
{
try {
	if(con!=null)
		con.close();	
} catch (SQLException se) {
System.out.println(se);}
}
public static Connection createConnection()
{
try
{Class.forName("com.mysql.jdbc.Driver");//create object of driver class//factory method-forName()
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demand_management_system","root","root");//connection String
}                           //sub protocol//name or IP address of database used//Port no.//

catch(ClassNotFoundException|SQLException cse){
	System.out.print(cse);
}
return con;
}
public static void main(String[] args) {
	Connection cn=createConnection();
	System.out.println(cn);
}
}