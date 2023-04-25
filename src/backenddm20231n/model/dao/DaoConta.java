/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Conta;
import backenddm20231n.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gu
 */
public class DaoConta {
    
    private final Connection c;
    
    public DaoConta() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Conta excluir(Conta contEnt) throws SQLException{
        String sql = "delete from conta WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,contEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return contEnt;
    }
    
    public Conta buscar(Conta contEnt) throws SQLException{
        String sql = "select * from conta WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,contEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Conta contSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                contSaida = new Conta(
                    rs.getInt(1));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return contSaida;
   }

    public Conta inserir(Conta contEnt) throws SQLException{
        String sql = "insert into conta" + " (saldo)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,contEnt.getSaldo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            contEnt.setId(id);
        }
        stmt.close();
        return contEnt;
    }

    public Conta alterar(Conta contEnt) throws SQLException{
        String sql = "UPDATE conta SET saldo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,contEnt.getSaldo());
        stmt.setInt(2,contEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return contEnt;
    }

   public List<Conta> listar(Conta contEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Conta> conts = new ArrayList<>();
        
        String sql = "select * from conta where saldo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + contEnt.getSaldo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Conta cont = new Conta(
                rs.getInt(1));
            // adiciona o usu à lista de usus
            conts.add(cont);
        }
        
        rs.close();
        stmt.close();
        return conts;
   
   }
}
