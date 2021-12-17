/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

/**
 *
 * @author Davi
 */
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import db.conexao;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.swing.JOptionPane;

public class relatorioClientes {

    Connection conn = conexao.getConnection();
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public void visualizarTodosOsClientes() {

        try {

            st = conn.createStatement();
            rs = st.executeQuery("select * from clientes");

            URL arquivo = getClass().getResource("/relatorios/relatorioClientes.jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
            
            //inserindo parâmetro no relatório
            Map<String, Object> params = new HashMap<String, Object>();
            
            //resgate da chave userLogadoSistema
            String userLogadoSistema = System.getProperty("userLogadoSistema");            
            
            params.put("userLogado",userLogadoSistema);
            

            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, params, jrRS);
            JasperViewer.viewReport(print);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

}
