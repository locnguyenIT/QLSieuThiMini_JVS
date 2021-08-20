/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

//import com.mysql.jdbc.Connection;

//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ntloc
 */
public class MySQLConnect {
    private String user ="root";
    private String password ="";
    private String url = "jdbc:mysql://localhost/quanlysieuthimini?useUnicode=true&characterEncoding=UTF-8";
    private Connection connect = null;
    private Statement state = null;
    
    public void Connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            //System.out.println("connect successfully!");
        } catch (SQLException ex ) {
            //System.out.println("connect failure!");
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DisConnect()
    {
        try {
            state.close();
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ResultSet excuteQuery(String Query) //cho selecrt
    {
        ResultSet result = null;
        try {
            Connect();
            state = connect.createStatement();
            result = state.executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result ;
    }
    public void excuteUpdate(String Query) //Cho insert update delete
    {
        try {
            Connect();
            state = connect.createStatement();
            state.executeUpdate(Query);
            DisConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection()
    {
        Connect();
        return connect;
    }
//     public static void main(String[] args) {
//        // TODO code application logic here
//        MySQLConnect mySql = new MySQLConnect();
//        mySql.Connect();
//        
//    }
}
