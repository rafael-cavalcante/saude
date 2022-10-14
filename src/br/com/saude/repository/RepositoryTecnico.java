/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Cor;
import br.com.saude.model.Administrador;
import br.com.saude.model.Tecnico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tecin
 */
public class RepositoryTecnico {

    public void adicionar(Tecnico tecnico, Administrador administrador) {
        try {
            String query = "INSERT INTO POSTINHO.TECNICO (cpf_pessoa, cpf_administrador) "
                    + "VALUES (?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, tecnico.getCpf());
            preparedStatement.setLong(2, administrador.getCpf());

            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }

    public Tecnico buscar(Tecnico tecnico) {
        try {
            String query = "SELECT cpf, senha, nome, bairro, rua, numero FROM POSTINHO.PESSOA, POSTINHO.TECNICO "
                    + "WHERE cpf  = ? AND senha = ? AND cpf = cpf_pessoa;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, tecnico.getCpf());
            preparedStatement.setString(2, tecnico.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Tecnico tecnicoLogado = new Tecnico(
                        resultSet.getLong("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("rua"),
                        resultSet.getLong("numero"),
                        resultSet.getString("bairro"),
                        new ArrayList<>()
                );
                return tecnicoLogado;
            }
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public boolean existe(Tecnico tecnico) {
        try {
            String query = "SELECT cpf_pessoa FROM POSTINHO.TECNICO "
                    + "WHERE cpf_pessoa = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, tecnico.getCpf());

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
