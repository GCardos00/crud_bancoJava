/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.PessoasConta;
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
 * @author FATEC ZONA LESTE
 */
public class DaoPessoasConta {

private final Connection c;
    
    public DaoPessoasConta() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoasConta excluir(PessoasConta pescontEnt) throws SQLException{
        String sql = "delete from pessoas_conta WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pescontEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pescontEnt;
    }
    
    public PessoasConta buscar(PessoasConta pescontEnt) throws SQLException{
        String sql = "select * from pessoas_conta WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pescontEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoasConta pescontSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pescontSaida = new PessoasConta(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pescontSaida;
   }

    public PessoasConta inserir(PessoasConta pescontEnt) throws SQLException{
        String sql = "insert into pessoas_conta" + " (idP, idC, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,pescontEnt.getIdP());
        stmt.setInt(2,pescontEnt.getIdC());
        stmt.setString(3,pescontEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pescontEnt.setId(id);
        }
        stmt.close();
        return pescontEnt;
    }

    public PessoasConta alterar(PessoasConta pescontEnt) throws SQLException{
        String sql = "UPDATE pessoas_conta SET idP = ?, idC = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pescontEnt.getIdP());
        stmt.setInt(2,pescontEnt.getIdC());
        stmt.setString(3,pescontEnt.getObs());
        stmt.setInt(4,pescontEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pescontEnt;
    }

   public List<PessoasConta> listar(PessoasConta pescontEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<PessoasConta> pesconts = new ArrayList<>();
        
        String sql = "select * from pessoas_conta where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pescontEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoasConta pescont = new PessoasConta(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            pesconts.add(pescont);
        }
        
        rs.close();
        stmt.close();
        return pesconts;
   
   }

    
}
