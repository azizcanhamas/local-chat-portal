package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class userModel {
    Connection con;
    String query;
    PreparedStatement ps;
    ResultSet rs;
    public String connectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/localchat?user=root&password=");
            if(con==null)return "true";
            else return "true";     
        }catch(SQLException e){ return "Database connection unsuccessful! ERROR: "+e; }
        catch(ClassNotFoundException e){ return "Database driver not found! ERROR: "+e;}  
    }
    
    public ResultSet isUser(String email,String password){
        connectDB();
        query="SELECT * FROM users WHERE email=? AND password=?";
        try{
            ps=con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs=ps.executeQuery();
//            con.close();
            return rs;
        }catch(SQLException e){
            return null;
        }
    }
    
    public boolean addUser(String email,String password){
        connectDB();
        query="INSERT INTO users (email,password) VALUE (?,?)";
        try{
            ps=con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeUpdate();
            con.close();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
        
    }

}
