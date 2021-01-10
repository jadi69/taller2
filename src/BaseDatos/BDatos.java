/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Javier
 */
public class BDatos {
    private static Connection bDConnection;
    private static Statement bDStatement;
    private static ResultSet bDResultSet;
    private final String bd;
    private final String user;
    private final String password;
    private final String insertTabla;
    private final String updateTabla;
    private final String vaciarTabla;
    private final String deleteTabla;

    public BDatos(String bd, String user, String password) {
        bDConnection=null;
        bDStatement=null;
        bDResultSet=null;
        this.bd = bd;
        this.user = user;
        this.password = password;
        this.insertTabla="INSERT INTO <tabla> ";
        this.updateTabla="UPDATE <tabla> SET ";
        this.vaciarTabla="DELETE FROM <tabla>;";
        this.deleteTabla="DELETE FROM <tabla> FROM ";
    }
    
    public void SetTabla(){
        
    }
    public boolean Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            bDConnection = DriverManager.getConnection("jdbc:mysql://taller-2.ddns.net:3306/" + bd, user, password);
            return(bDConnection != null);
        }
        catch(Exception e){
            return(false);
        }
    }
    public boolean Desconectar(){
        try {
            bDConnection.close();
        }
        catch(Exception e) {
            return(false);
        }
        return true;
    }
    public boolean Operacion(String tabla, String commando){
        boolean lresult=true;
        
        try {
            bDStatement = bDConnection.createStatement();
            bDStatement.execute(commando);
        } 
        catch (Exception e){
            lresult=false;
            System.err.println(e.toString());
        }
        return(lresult);    
    }
}
