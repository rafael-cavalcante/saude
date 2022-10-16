/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Cor;
import br.com.saude.model.Medico;
import br.com.saude.model.Tecnico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tecin
 */
public class RepositoryMedico {

    public boolean adicionar(Medico medico, Tecnico tecnico) {
        try {
            String query = "INSERT INTO POSTINHO.MEDICO (crm, cpf_pessoa, cpf_tecnico, especializacao) "
                    + "VALUES (?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, medico.getCrm());
            preparedStatement.setLong(2, medico.getCpf());
            preparedStatement.setLong(3, tecnico.getCpf());
            preparedStatement.setString(4, medico.getEspecializacao());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public Medico buscar(Medico medico) {
        try {
            String query = "SELECT crm, especializacao, cpf, senha, nome, bairro, rua, numero FROM POSTINHO.PESSOA, POSTINHO.MEDICO "
                    + "WHERE crm = ? AND cpf_pessoa = cpf AND senha = ? ;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, medico.getCrm());
            preparedStatement.setString(2, medico.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Medico(
                        resultSet.getLong("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("rua"),
                        resultSet.getLong("numero"),
                        resultSet.getString("bairro"),
                        new ArrayList<>(),
                        resultSet.getString("crm"),
                        resultSet.getString("especializacao")
                );
            }
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<Medico> buscar() {
        try {
            List<Medico> medicos = new ArrayList<>();

            String query = "SELECT crm FROM POSTINHO.MEDICO;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                medicos.add(new Medico(resultSet.getString("crm")));
            }

            return medicos;
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public boolean existe(Medico medico) {
        try {
            String query = "SELECT crm FROM POSTINHO.MEDICO "
                    + "WHERE crm = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, medico.getCrm());

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
