/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Cor;
import br.com.saude.model.Prontuario;
import br.com.saude.service.DataService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tecin
 */
public class RepositoryProntuario {

    public boolean adicionar(Prontuario prontuario) {
        try {
            String query = "INSERT INTO POSTINHO.PRONTUARIO (codigo, data_criacao, descricao) "
                    + "VALUES (?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, prontuario.getCodigo());
            preparedStatement.setDate(2, DataService.converter(prontuario.getDataCriacao()));
            preparedStatement.setString(3, prontuario.getDescricao());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public boolean existe(Prontuario prontuario) {
        try {
            String query = "SELECT codigo FROM POSTINHO.PRONTUARIO "
                    + "WHERE codigo = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, prontuario.getCodigo());

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
