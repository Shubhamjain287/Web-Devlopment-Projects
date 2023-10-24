import java.sql.*;

class DBLoader
{
    static ResultSet executeQuery(String sqlstatement)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Successful");
            
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatroom","nikhil","applehunt");
            System.out.println("Connection Built");
            
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");
            
            ResultSet rs=stmt.executeQuery(sqlstatement);
            System.out.println("ResultSet Created");
        
            return rs;
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    
          return null;
    }
    
}