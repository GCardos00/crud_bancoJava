/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerConta;
import backenddm20231n.model.bean.Conta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gu
 */
public class ManterConta {
    
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
        String saldo = JOptionPane.showInputDialog("Saldo:");
        Conta contEnt = new Conta(saldo);
        ControllerConta contCont = new ControllerConta();
        Conta contSaida = contCont.inserir(contEnt);
        JOptionPane.showMessageDialog(null,contSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
        String saldo = JOptionPane.showInputDialog("Saldo:");
        Conta contEnt = new Conta(id, saldo);
        ControllerConta contCont = new ControllerConta();
        Conta contSaida = contCont.alterar(contEnt);
        JOptionPane.showMessageDialog(null,contSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Conta contEnt = new Conta(id);
        ControllerConta contCont = new ControllerConta();
        Conta contSaida = contCont.buscar(contEnt);
        JOptionPane.showMessageDialog(null,contSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Conta contEnt = new Conta(id);
        ControllerConta contCont = new ControllerConta();
        Conta contSaida = contCont.excluir(contEnt);
        JOptionPane.showMessageDialog(null,contSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Conta contEnt = new Conta(id);
        ControllerConta contUsu = new ControllerConta();
        List<Conta> listaConts = contUsu.listar(contEnt);
        for (Conta contSaida : listaConts) {
            JOptionPane.showMessageDialog(null,contSaida.toString());
        }
    }


}
