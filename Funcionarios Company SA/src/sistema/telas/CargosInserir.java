/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sistema.BancoDeDados;
import sistema.entidades.Cargo;
import com.microsoft.sqlserver.jdbc.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BRUNOSILVA
 */
public class CargosInserir extends JPanel {

    JLabel labelTitulo, labelCargo;
    JTextField campoCargo;
    JButton botaoGravar;

    public CargosInserir() {
        criarComponentes();
        criarEventos();

    }

    private void criarComponentes() {
        setLayout(null);

        labelTitulo = new JLabel("Cadastros de Cargo", JLabel.CENTER);
        labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.PLAIN, 20));
        labelCargo = new JLabel("Nome do Cargo", JLabel.LEFT);
        campoCargo = new JTextField();
        botaoGravar = new JButton("Adicionar Cargo");

        labelTitulo.setBounds(20, 20, 660, 40);
        labelCargo.setBounds(150, 120, 400, 20);
        campoCargo.setBounds(150, 140, 400, 40);
        botaoGravar.setBounds(250, 380, 200, 40);

        add(labelTitulo);
        add(labelCargo);
        add(campoCargo);
        add(botaoGravar);

        setVisible(true);
    }

    private void criarEventos() {
        botaoGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cargo novoCargo = new Cargo();
                novoCargo.setNome(campoCargo.getText());

                sqlInserirCargo(novoCargo);
            }

        });
    }

    private void sqlInserirCargo(Cargo NovoCargo) {

        boolean temConexao = false;

        //validando nome
        if (campoCargo.getText().length() <= 3) {
            JOptionPane.showMessageDialog(null, "Por favor preencha o nome corretamente!");
        } else {
            //conexão
            Connection conexao = null;
            //instrução SQL
            Statement instrucaoSQL;
            //resultados
            ResultSet resultados;

            try {
                //conectando o Banco de Dados
                conexao = DriverManager.getConnection(BancoDeDados.stringConexao, BancoDeDados.usuario, BancoDeDados.senha);

                //criando a instrução SQL
                instrucaoSQL = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                instrucaoSQL.executeUpdate("insert into cargos (nome) values ('" + NovoCargo.getNome() + "')");
                temConexao = true;

                JOptionPane.showMessageDialog(null, "Cargo adicionado com sucesso");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o Cargo!!");
                Logger.getLogger(CargosInserir.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                if (temConexao) {
                    try {
                        conexao.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(CargosInserir.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Conexão não feita!!");
                    }
                }
            }
        }

    }

}
