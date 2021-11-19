package db;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexao {
    
    private static Connection conn = null;
    
    public static Connection getConnection(){
        
        if(conn == null){
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/poo2-producao", "root", "");               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+ e);
            }           
        }
        return conn;
    }
    

}
