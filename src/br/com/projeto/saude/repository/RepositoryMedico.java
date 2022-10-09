/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.repository;

import br.com.projeto.saude.configuracao.conexao.Conexao;
import br.com.projeto.saude.model.Endereco;
import br.com.projeto.saude.model.Medico;
import br.com.projeto.saude.model.Tecnico;
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

    public void adicionar(Medico medico, Tecnico tecnico) {
        try {
            String query = "INSERT INTO POSTINHO.MEDICO (crm, cpf_pessoa, cpf_tecnico, especializacao) "
                    + "VALUES (?,?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, medico.getCrm());
            preparedStatement.setString(2, medico.getCpf());
            preparedStatement.setString(3, tecnico.getCpf());
            preparedStatement.setString(4, medico.getEspecializacao());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }
    
    public List<Medico> buscar(){
        try {
            ArrayList<Medico> medicos = new ArrayList<>();
            
            String query = "SELECT crm, nome FROM POSTINHO.PESSOA, POSTINHO.MEDICO "
                    + "WHERE cpf_pessoa = cpf;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medico medico = new Medico();
                medico.setCrm(resultSet.getString("crm"));
                medico.setNome(resultSet.getString("nome"));
                
                medicos.add(medico);
            }
            
            return medicos;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
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
                Medico medicoLogado = new Medico(
                        resultSet.getString("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("nome"),
                        new Endereco(
                                resultSet.getString("rua"),
                                resultSet.getInt("numero"),
                                resultSet.getString("bairro")
                        ),
                        new ArrayList<>(),
                        resultSet.getString("crm"),
                        resultSet.getString("especializacao")
                );
                return medicoLogado;
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }
    
    public boolean existe(Medico medico){
        try {
            String query = "SELECT crm FROM POSTINHO.MEDICO "
                    + "WHERE crm = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setString(1, medico.getCrm());

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
