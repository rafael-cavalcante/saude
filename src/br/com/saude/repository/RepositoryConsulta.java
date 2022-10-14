/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Cor;
import br.com.saude.model.Consulta;
import br.com.saude.model.Medico;
import br.com.saude.model.Paciente;
import br.com.saude.model.Prontuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tecin
 */
public class RepositoryConsulta {

    public void adicionar(Consulta consulta) {
        try {
            String query = "INSERT INTO POSTINHO.CONSULTA (cpf_paciente, crm_medico, codigo_laudo, data_realizacao, status) "
                    + "VALUES (?,?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, consulta.getPaciente().getCpf());
            preparedStatement.setString(2, consulta.getMedico().getCrm());
            preparedStatement.setLong(3, consulta.getProntuario().getCodigo());
            preparedStatement.setDate(4, Date.valueOf(consulta.getDataRealizacao()));
            preparedStatement.setString(5, consulta.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }

    public List<Consulta> buscar(Paciente paciente) {
        try {
            List<Consulta> consultas = new ArrayList<>();

            String query = "SELECT cpf_paciente, crm_medico, codigo_laudo, status, peso, pressao, data_realizacao, prioridade FROM POSTINHO.CONSULTA "
                    + "WHERE cpf_paciente = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Consulta consulta = new Consulta(
                        new Paciente(resultSet.getLong("cpf_paciente")),
                        new Medico(resultSet.getString("crm_medico")),
                        new Prontuario(resultSet.getInt("codigo_prontuario")),
                        resultSet.getDate("data_realizacao").toLocalDate(),
                        resultSet.getString("status"),
                        resultSet.getInt("pressao"),
                        resultSet.getDouble("peso"),
                        resultSet.getInt("prioridade")
                );

                consultas.add(consulta);
            }

            return consultas;
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public boolean atualizar(Consulta consulta) {
        try {
            String query = "UPDATE POSTINHO.CONSULTA SET data_realizacao = ?, status = ?, pressao = ?, peso = ?, prioridade = ? "
                    + "WHERE cpf_paciente = ? AND crm_medico = ? AND codigo_laudo = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setDate(1, Date.valueOf(consulta.getDataRealizacao()));
            preparedStatement.setString(2, consulta.getStatus());
            preparedStatement.setInt(3, consulta.getPressao());
            preparedStatement.setDouble(4, consulta.getPeso());
            preparedStatement.setInt(5, consulta.getPrioridade());
            preparedStatement.setLong(6, consulta.getPaciente().getCpf());
            preparedStatement.setString(7, consulta.getMedico().getCrm());
            preparedStatement.setLong(8, consulta.getProntuario().getCodigo());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public boolean existe(Consulta consulta) {
        try {
            String query = "SELECT cpf_paciente, crm_medico, codigo_laudo FROM POSTINHO.CONSULTA "
                    + "WHERE cpf_paciente = ? AND crm_medico = ? AND codigo_laudo = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, consulta.getPaciente().getCpf());
            preparedStatement.setString(2, consulta.getMedico().getCrm());
            preparedStatement.setLong(3, consulta.getProntuario().getCodigo());

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
