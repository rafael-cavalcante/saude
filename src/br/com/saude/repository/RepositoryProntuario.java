/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Estilo;
import br.com.saude.model.Paciente;
import br.com.saude.model.Prontuario;
import br.com.saude.service.DataService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public List<Prontuario> buscar(Paciente paciente) {
        try {
            List<Prontuario> prontuarios = new ArrayList<>();

            String query = "SELECT p.codigo, p.data_criacao, p.descricao FROM POSTINHO.PRONTUARIO p, POSTINHO.CONSULTA c "
                    + "WHERE p.codigo = c.codigo_prontuario AND c.cpf_paciente = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                prontuarios.add(new Prontuario(resultSet.getLong("codigo"), DataService.converter(resultSet.getDate("data_criacao")), resultSet.getString("descricao")));
            }

            return prontuarios;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
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
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
