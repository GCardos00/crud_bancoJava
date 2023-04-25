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
public class Conta {
    
    private int id;
    private String saldo;

    public Conta(int id) {
        this.id = id;
    }

    public Conta(String saldo) {
        this.saldo = saldo;
    }

    public Conta(int id, String saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", saldo=" + saldo + '}';
    }
    
    
}
