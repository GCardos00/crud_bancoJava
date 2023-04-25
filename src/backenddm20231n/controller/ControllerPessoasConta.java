/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Conta;
import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.PessoasConta;
import backenddm20231n.model.dao.DaoPessoasConta;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class ControllerPessoasConta {
    
    DaoPessoasConta daoPesCon;
    ControllerPessoa contP;
    ControllerConta contC;

    
    public PessoasConta inserir(PessoasConta pesconEnt) throws SQLException, ClassNotFoundException {
        daoPesCon = new DaoPessoasConta();
        return daoPesCon.inserir(pesconEnt);
    }

    public PessoasConta alterar(PessoasConta pesconEnt) throws SQLException, ClassNotFoundException {
        daoPesCon = new DaoPessoasConta();
        return daoPesCon.alterar(pesconEnt);
    }

    public PessoasConta buscar(PessoasConta pesconEnt) throws SQLException, ClassNotFoundException {
        daoPesCon = new DaoPessoasConta();
        PessoasConta pc = daoPesCon.buscar(pesconEnt);
        Pessoa p = new Pessoa(pc.getIdP());
        Conta c = new Conta(pc.getIdC());
        contP = new ControllerPessoa();
        contC = new ControllerConta();
        pc.setP(contP.buscar(p));
        pc.setC(contC.buscar(c));
        return pc;
    }

    public PessoasConta excluir(PessoasConta pesconEnt) throws SQLException, ClassNotFoundException {
        daoPesCon = new DaoPessoasConta();
        return daoPesCon.excluir(pesconEnt);
    }

     public List<PessoasConta> listar(PessoasConta pesconEnt) throws SQLException, ClassNotFoundException {
        daoPesCon = new DaoPessoasConta();
        List<PessoasConta> listapescon = daoPesCon.listar(pesconEnt);
        for (PessoasConta pcSaida : listapescon) {
            Pessoa p = new Pessoa(pcSaida.getIdP());
            contP = new ControllerPessoa();
            pcSaida.setP(contP.buscar(p));
            Conta c = new Conta(pcSaida.getIdC());
            contC = new ControllerConta();
            pcSaida.setC(contC.buscar(c));
        }


        return listapescon;
     }
   
}
