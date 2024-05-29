/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectionDB {
    String dbUrl = "jdbc:mysql://localhost/pelabuhan";
    String username = "root";
    String password = "";
    public Connection conn;
    Statement statement;
    
    private static final Logger LOG = Logger.getLogger(connectionDB.class.getName());
    public connectionDB(){
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);
            createStatement();
            LOG.info("Koneksi DB Dibuat");
        }
        catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
    
    public void createStatement(){
        try {
            this.statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

