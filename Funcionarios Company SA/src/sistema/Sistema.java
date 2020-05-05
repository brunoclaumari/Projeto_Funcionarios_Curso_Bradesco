/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import sistema.telas.Inicio;
import sistema.telas.CargosInserir;

/**
 *
 * @author BRUNOSILVA
 */
public class Sistema {
    
    public static JPanel tela;
    public static JFrame frame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        criarComponentes();
        
    }
    
    private static void criarComponentes(){
        frame=new JFrame("Sistema");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        tela = new CargosInserir();
        tela.setVisible(true);
        frame.add(tela);
        
        frame.setVisible(true);
        
    }
    
}
