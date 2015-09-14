import java.sql.*;

public class test {
   
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";

   
   static final String USER = "root";
   static final String PASS = "0909";
   
   public static void main(String[] args) {
   Connection conn = null;
   CallableStatement stmt = null;
   try{
      
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      
      System.out.println("Creating statement...");
      String sql = "{call getEmpName (?, ?)}";
      stmt = conn.prepareCall(sql);
      
      
      int empID = 1;
      stmt.setInt(1, empID); 
      
      stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
      
      
      System.out.println("Executing stored procedure..." );
      stmt.execute();

      
      String empName = stmt.getString(2);
      System.out.println("Emp Name with ID:" + 
               empID + " is " + empName);
      stmt.close();
      conn.close();
   }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}
}