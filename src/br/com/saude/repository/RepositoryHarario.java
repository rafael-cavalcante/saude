/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Estilo;
import br.com.saude.model.Horario;
import br.com.saude.model.Tecnico;
import br.com.saude.service.DataService;
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
public class RepositoryHarario {

    public boolean adicionar(Tecnico tecnico, Horario horario) {
        try {
            String query = "INSERT INTO POSTINHO.HORARIO (data, descricao, cpf_tecnico) "
                    + "VALUES (?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setDate(1, DataService.converter(horario.getData()));
            preparedStatement.setString(2, horario.getDescricao());
            preparedStatement.setLong(3, tecnico.getCpf());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return false;
    }

    public List<Horario> buscar(LocalDate localDate) {
        try {
            List<Horario> horarios = new ArrayList<>();

            String query = "SELECT data, descricao FROM POSTINHO.HORARIO "
                    + "WHERE data >= ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setDate(1, DataService.converter(localDate));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                horarios.add(new Horario(
                        resultSet.getDate("data").toLocalDate(),
                        resultSet.getString("descricao")
                )
                );
            }

            return horarios;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }
}
