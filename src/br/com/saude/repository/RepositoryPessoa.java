/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tecin
 */
public class RepositoryPessoa {

    public void adicionar(Pessoa pessoa) {
        try {
            String query = "INSERT INTO POSTINHO.PESSOA (cpf, senha, nome, rua, numero, bairro) "
                    + "VALUES (?,?,?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, pessoa.getCpf());
            preparedStatement.setString(2, pessoa.getSenha());
            preparedStatement.setString(3, pessoa.getNome());
            preparedStatement.setString(4, pessoa.getEndereco().getRua());
            preparedStatement.setInt(5, pessoa.getEndereco().getNumero());
            preparedStatement.setString(6, pessoa.getEndereco().getBairro());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }
    
    public boolean atualizar(Pessoa pessoa){
        try {
            String query = "UPDATE POSTINHO.PESSOA SET senha = ?, nome = ?, rua = ?, numero = ?, bairro = ? "
                    + "WHERE cpf = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, pessoa.getSenha());
            preparedStatement.setString(2, pessoa.getNome());
            preparedStatement.setString(3, pessoa.getEndereco().getRua());
            preparedStatement.setInt(4, pessoa.getEndereco().getNumero());
            preparedStatement.setString(5, pessoa.getEndereco().getBairro());
            preparedStatement.setString(6, pessoa.getCpf());

            preparedStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
