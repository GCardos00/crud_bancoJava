/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.bean;

/**
 *
 * @author User
 */
public class PessoasConta {
    
    private int id;
    private int idP;
    private int idC;
    private String obs;
    private Pessoa p;
    private Conta c;

    public PessoasConta(int id) {
        this.id = id;
    }

    public PessoasConta(String obs) {
        this.obs = obs;
    }

    public PessoasConta(int idP, int idC, String obs) {
        this.idP = idP;
        this.idC = idC;
        this.obs = obs;
    }

    public PessoasConta(int id, int idP, int idC, String obs) {
        this.id = id;
        this.idP = idP;
        this.idC = idC;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public Conta getC() {
        return c;
    }

    public void setC(Conta c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "PessoasConta{" + "id=" + id + ", idP=" + idP + ", idL=" + idC + ", obs=" + obs + '}';
    }    
    
}
