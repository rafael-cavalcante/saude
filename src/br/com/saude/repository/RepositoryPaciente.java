/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.model.Paciente;
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
public class RepositoryPaciente {

    public void adicionar(Paciente paciente) {
        try {
            String query = "INSERT INTO POSTINHO.PACIENTE (cpf_pessoa, rg, data_nascimento, email) "
                    + "VALUES (?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getCpf());
            preparedStatement.setLong(2, paciente.getRg());
            preparedStatement.setDate(3, DataService.converter(paciente.getDataNascimento()));
            preparedStatement.setString(4, paciente.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }

    public List<Paciente> buscar() {
        try {
            List<Paciente> pacientes = new ArrayList<>();

            String query = "SELECT cpf, nome FROM POSTINHO.PESSOA, POSTINHO.PACIENTE "
                    + "WHERE cpf = cpf_pessoa;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setCpf(resultSet.getLong("cpf"));
                paciente.setNome(resultSet.getString("nome"));

                pacientes.add(paciente);
            }

            return pacientes;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public Paciente buscar(Paciente paciente) {
        try {
            String query = "SELECT cpf, senha, nome, rua, numero, bairro, rg, data_nascimento, email FROM POSTINHO.PESSOA, POSTINHO.PACIENTE "
                    + "WHERE cpf = ? AND senha = ? AND cpf = cpf_pessoa;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getCpf());
            preparedStatement.setString(2, paciente.getSenha());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Paciente pacienteLogado = new Paciente(
                        resultSet.getLong("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        resultSet.getString("rua"),
                        resultSet.getLong("numero"),
                        resultSet.getString("bairro"),
                        new ArrayList<>(),
                        resultSet.getLong("rg"),
                        DataService.converter(resultSet.getDate("data_nascimento")),
                        resultSet.getString("email")
                );
                return pacienteLogado;
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public boolean atualizar(Paciente paciente) {
        try {
            String query = "UPDATE POSTINHO.PACIENTE SET rg = ?, data_nascimento = ? "
                    + "WHERE cpf_pessoa = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getRg());
            preparedStatement.setDate(2, DataService.converter(paciente.getDataNascimento()));
            preparedStatement.setLong(3, paciente.getCpf());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public boolean existe(Paciente paciente) {
        try {
            String query = "SELECT cpf_pessoa FROM POSTINHO.PACIENTE "
                    + "WHERE cpf_pessoa = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, paciente.getCpf());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
