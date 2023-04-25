/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerPessoasConta;
import backenddm20231n.model.bean.PessoasConta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterPessoasConta {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        int idC = Integer.parseInt(JOptionPane.showInputDialog("IDC"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasConta pcEnt = new PessoasConta(idP,idC,obs);
        ControllerPessoasConta contPC = new ControllerPessoasConta();
        PessoasConta pcSaida = contPC.inserir(pcEnt);
        JOptionPane.showMessageDialog(null,pcSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        int idC = Integer.parseInt(JOptionPane.showInputDialog("IDC"));
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasConta pcEnt = new PessoasConta(id,idP,idC,obs);
        ControllerPessoasConta contPC = new ControllerPessoasConta();
        PessoasConta pcSaida = contPC.alterar(pcEnt);
        JOptionPane.showMessageDialog(null,pcSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasConta pcEnt = new PessoasConta(id);
        ControllerPessoasConta contPC = new ControllerPessoasConta();
        PessoasConta pcSaida = contPC.buscar(pcEnt);
        JOptionPane.showMessageDialog(null,pcSaida.toString());
        JOptionPane.showMessageDialog(null,pcSaida.getP().toString());
        JOptionPane.showMessageDialog(null,pcSaida.getC().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoasConta pcEnt = new PessoasConta(id);
        ControllerPessoasConta contPC = new ControllerPessoasConta();
        PessoasConta pcSaida = contPC.excluir(pcEnt);
        JOptionPane.showMessageDialog(null,pcSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        PessoasConta pcEnt = new PessoasConta(obs);
        ControllerPessoasConta contPC = new ControllerPessoasConta();
        List<PessoasConta> listaPessoasConta = contPC.listar(pcEnt);
        for (PessoasConta pcSaida : listaPessoasConta) {
            JOptionPane.showMessageDialog(null,pcSaida.toString());
            JOptionPane.showMessageDialog(null,pcSaida.getP().toString());
            JOptionPane.showMessageDialog(null,pcSaida.getC().toString());
        }
    }


}
