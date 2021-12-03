/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Davi
 */
import db.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class controlaUsuario {
    
    Connection conn = conexao.getConnection();
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public boolean verificarUserSenha(String login, String senha){
        
        try {

            pst = conn.prepareStatement("select * from usuarios where login = ? and senha= ?");

            pst.setString(1, login);
            pst.setString(2, senha);

            rs = pst.executeQuery();

            if (rs.next()) {

                return true;

            } 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }        
        
        
        return false;
        
    }
    
}
