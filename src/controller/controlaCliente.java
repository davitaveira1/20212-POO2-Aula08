package controller;

import db.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Cliente;

public class controlaCliente {
    
    Connection conn = conexao.getConnection();
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    
    //método para adicionar
    public void adicionarCliente(Cliente c){
        
        conn = conexao.getConnection();
        try {
        
            pst = conn.prepareStatement("insert into clientes (nome,telefone) "
                    + "values (?,?)");
            
            pst.setString(1,c.getNome());
            pst.setString(2,c.getTelefone());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Inserção realizada com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+  e);
        }
        
        
    }
    
    
    //método para alterar
    
    //método para excluir
    
}
