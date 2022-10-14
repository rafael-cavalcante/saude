/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Cor;
import br.com.saude.model.Pessoa;
import br.com.saude.model.Telefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar as operações com a tabela telefone.
 * 
 * @author Rafael Cavalcante
 */
public class RepositoryTelefone {
    
    public void adicionar(Telefone telefone, Pessoa pessoa){
         try {
            String query = "INSERT INTO POSTINHO.TELEFONE (cpf_pessoa, numero) "
                    + "VALUES (?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, pessoa.getCpf());
            preparedStatement.setLong(2, telefone.getNumero());

            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }
    
    public List<Telefone> buscar(Pessoa pessoa){
        try {
            ArrayList<Telefone> telefones = new ArrayList<>();
            
            String query = "SELECT numero FROM POSTINHO.TELEFONE "
                    + "WHERE cpf_pessoa  = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, pessoa.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                telefones.add(new Telefone(resultSet.getLong("numero")));
            }
            
            return telefones;
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }
    
    public boolean existe(Telefone telefone, Pessoa pessoa){
        try {
            String query = "SELECT cpf_pessoa, numero FROM POSTINHO.TELEFONE "
                    + "WHERE cpf_pessoa = ? AND numero = ?;";
            
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, pessoa.getCpf());
            preparedStatement.setLong(2, telefone.getNumero());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
