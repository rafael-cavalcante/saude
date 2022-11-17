/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Estilo;
import br.com.saude.model.Consulta;
import br.com.saude.model.Medico;
import br.com.saude.model.Paciente;
import br.com.saude.model.Prontuario;
import br.com.saude.service.DataService;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tecin
 */
public class RepositoryConsulta {

    public boolean adicionar(Consulta consulta) {
        try {
            String query = "INSERT INTO POSTINHO.CONSULTA (cpf_paciente, crm_medico, codigo_prontuario, data_realizacao, status, prioridade) "
                    + "VALUES (?,?,?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, consulta.getPaciente().getCpf());
            preparedStatement.setString(2, consulta.getMedico().getCrm());
            preparedStatement.setLong(3, consulta.getProntuario().getCodigo());
            preparedStatement.setDate(4, DataService.converter(consulta.getDataRealizacao()));
            preparedStatement.setString(5, consulta.getStatus());
            preparedStatement.setInt(6, consulta.getPrioridade());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public List<Consulta> buscar(Paciente paciente) {
        try {
            List<Consulta> consultas = new ArrayList<>();

            String query = "SELECT cpf_paciente, crm_medico, codigo_prontuario, status, peso, pressao, data_realizacao, prioridade FROM POSTINHO.CONSULTA "
                    + "WHERE cpf_paciente = ? AND status ILike 'Processamento';";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                consultas.add(
                        new Consulta(
                                new Paciente(resultSet.getLong("cpf_paciente")),
                                new Medico(resultSet.getString("crm_medico")),
                                new Prontuario(resultSet.getLong("codigo_prontuario")),
                                resultSet.getDate("data_realizacao").toLocalDate(),
                                resultSet.getString("status"),
                                resultSet.getInt("pressao"),
                                resultSet.getDouble("peso"),
                                resultSet.getInt("prioridade")
                        )
                );
            }

            return consultas;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<Consulta> buscar(Medico medico) {
        try {
            List<Consulta> consultas = new ArrayList<>();

            String query = "SELECT cpf_paciente, crm_medico, codigo_prontuario, data_realizacao FROM POSTINHO.CONSULTA "
                    + "WHERE crm_medico = ? AND status ILIKE 'Processamento' ORDER BY prioridade;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, medico.getCrm());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                consultas.add(
                        new Consulta(
                                new Paciente(resultSet.getLong("cpf_paciente")),
                                new Medico(resultSet.getString("crm_medico")),
                                new Prontuario(resultSet.getLong("codigo_prontuario")),
                                resultSet.getDate("data_realizacao").toLocalDate()
                        )
                );
            }

            return consultas;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<Consulta> buscar(LocalDate dataRealizacao) {
        try {
            List<Consulta> consultas = new ArrayList<>();

            String query = "SELECT cpf_paciente, crm_medico, codigo_prontuario, data_realizacao FROM POSTINHO.CONSULTA "
                    + "WHERE data_realizacao = ? AND status ILIKE 'Confirmada' ORDER BY prioridade;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setDate(1, DataService.converter(dataRealizacao));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                consultas.add(
                        new Consulta(
                                new Paciente(resultSet.getLong("cpf_paciente")),
                                new Medico(resultSet.getString("crm_medico")),
                                new Prontuario(resultSet.getLong("codigo_prontuario")),
                                resultSet.getDate("data_realizacao").toLocalDate()
                        )
                );
            }

            return consultas;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<Consulta> buscar(String crmMedico, LocalDate dataRealizacao) {
        try {
            List<Consulta> consultas = new ArrayList<>();

            String query = "SELECT cpf_paciente, crm_medico, codigo_prontuario, data_realizacao FROM POSTINHO.CONSULTA "
                    + "WHERE crm_medico = ? AND data_realizacao = ? AND status ILIKE 'Confirmada' ORDER BY prioridade DESC;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, crmMedico);
            preparedStatement.setDate(2, DataService.converter(dataRealizacao));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                consultas.add(
                        new Consulta(
                                new Paciente(resultSet.getLong("cpf_paciente")),
                                new Medico(resultSet.getString("crm_medico")),
                                new Prontuario(resultSet.getLong("codigo_prontuario")),
                                resultSet.getDate("data_realizacao").toLocalDate()
                        )
                );
            }

            return consultas;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<Consulta> buscar(LocalDate dataRealizacao, String status) {
        try {
            List<Consulta> consultas = new ArrayList<>();

            String query = "SELECT cpf_paciente, crm_medico, codigo_prontuario, data_realizacao FROM POSTINHO.CONSULTA "
                    + "WHERE data_realizacao = ? AND status ILIKE ? ORDER BY prioridade;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setDate(1, DataService.converter(dataRealizacao));
            preparedStatement.setString(2, status);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                consultas.add(
                        new Consulta(
                                new Paciente(resultSet.getLong("cpf_paciente")),
                                new Medico(resultSet.getString("crm_medico")),
                                new Prontuario(resultSet.getLong("codigo_prontuario")),
                                resultSet.getDate("data_realizacao").toLocalDate()
                        )
                );
            }

            return consultas;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public boolean atualizarStatus(Consulta consulta) {
        try {
            String query = "UPDATE POSTINHO.CONSULTA SET status = ? "
                    + "WHERE cpf_paciente = ? AND crm_medico = ? AND codigo_prontuario = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, consulta.getStatus());
            preparedStatement.setLong(2, consulta.getPaciente().getCpf());
            preparedStatement.setString(3, consulta.getMedico().getCrm());
            preparedStatement.setLong(4, consulta.getProntuario().getCodigo());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public boolean atualizar(Consulta consulta) {
        try {
            String query = "UPDATE POSTINHO.CONSULTA SET data_realizacao = ?, status = ?, pressao = ?, peso = ?, prioridade = ? "
                    + "WHERE cpf_paciente = ? AND crm_medico = ? AND codigo_prontuario = ?;";

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
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public boolean atualizar(long cpfPaciente, String crmMedico, long codigoProntuario, String statusConsulta) {
        try {
            String query = "UPDATE POSTINHO.CONSULTA SET status = ? "
                    + "WHERE cpf_paciente = ? AND crm_medico = ? AND codigo_prontuario = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, statusConsulta);
            preparedStatement.setLong(2, cpfPaciente);
            preparedStatement.setString(3, crmMedico);
            preparedStatement.setLong(4, codigoProntuario);

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public boolean existe(Consulta consulta) {
        try {
            String query = "SELECT cpf_paciente, crm_medico, codigo_prontuario FROM POSTINHO.CONSULTA "
                    + "WHERE cpf_paciente = ? AND crm_medico = ? AND codigo_prontuario = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, consulta.getPaciente().getCpf());
            preparedStatement.setString(2, consulta.getMedico().getCrm());
            preparedStatement.setLong(3, consulta.getProntuario().getCodigo());

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
