/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Conta;
import backenddm20231n.model.dao.DaoConta;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gu
 */
public class ControllerConta {
    
    DaoConta daoCont;

    public Conta inserir(Conta contEnt) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta();
        return daoCont.inserir(contEnt);
    }

    public Conta alterar(Conta contEnt) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta();
        return daoCont.alterar(contEnt);
    }

    public Conta buscar(Conta contEnt) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta();
        return daoCont.buscar(contEnt);
    }

    public Conta excluir(Conta contEnt) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta();
        return daoCont.excluir(contEnt);
    }

     public List<Conta> listar(Conta contEnt) throws SQLException, ClassNotFoundException {
        daoCont = new DaoConta();
        List<Conta> listaCont = daoCont.listar(contEnt);
        return listaCont;
     }
}
