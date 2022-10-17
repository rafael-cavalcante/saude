/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Estilo;
import br.com.saude.model.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tecin
 */
public class RepositoryAdministrador {

    public boolean adicionar(Administrador administrador) {
        try {
            String query = "INSERT INTO POSTINHO.ADMINISTRADOR (cpf_pessoa) "
                    + "VALUES (?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, administrador.getCpf());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public Administrador buscar(Administrador administrador) {
        try {
            String query = "SELECT cpf, senha, nome, rua, numero, bairro FROM POSTINHO.PESSOA, POSTINHO.ADMINISTRADOR "
                    + "WHERE cpf  = ? AND senha = ? AND cpf = cpf_pessoa;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, administrador.getCpf());
            preparedStatement.setString(2, administrador.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Administrador(
                        resultSet.getLong("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("rua"),
                        resultSet.getLong("numero"),
                        resultSet.getString("bairro"),
                        new ArrayList<>()
                );
            }
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public boolean existe(Administrador administrador) {
        try {
            String query = "SELECT cpf_pessoa FROM POSTINHO.ADMINISTRADOR "
                    + "WHERE cpf_pessoa = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, administrador.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
