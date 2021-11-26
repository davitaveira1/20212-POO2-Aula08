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
    public void adicionarCliente(Cliente c) {

        try {

            pst = conn.prepareStatement("insert into clientes (nome,telefone) "
                    + "values (?,?)");

            pst.setString(1, c.getNome());
            pst.setString(2, c.getTelefone());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    //método pesquisar cliente
    public Cliente pesquisarCliente(int codigo) {

        try {

            pst = conn.prepareStatement("select * from clientes where codigo = ?");

            pst.setInt(1, codigo);

            rs = pst.executeQuery();

            if (rs.next()) {

                Cliente c = new Cliente();

                c.setCodigo(codigo);
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));

                return c;

            } else {
                JOptionPane.showMessageDialog(null, "Não retornou registro!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    //método para alterar
    public void alterarCliente(Cliente c) {

        try {

            pst = conn.prepareStatement("update clientes set nome=?,telefone=? where codigo=?");

            pst.setString(1, c.getNome());
            pst.setString(2, c.getTelefone());
            pst.setInt(3, c.getCodigo());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    //método para excluir
    public void excluirCliente(Cliente c) {

        try {

            pst = conn.prepareStatement("delete from clientes where codigo=?");

            pst.setInt(1, c.getCodigo());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }
}
