/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Estilo;
import br.com.saude.model.Medicamento;
import br.com.saude.model.Prontuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tecin
 */
public class RepositoryMedicamento {
    
    public List<Medicamento> buscar(Prontuario prontuario){
        try {
            List<Medicamento> medicamentos = new ArrayList<>();

            String query = "SELECT nome FROM POSTINHO.MEDICAMENTO "
                    + "WHERE codigo_prontuario = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, prontuario.getCodigo());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                medicamentos.add(new Medicamento(resultSet.getString("nome")));
            }

            return medicamentos;
        } catch (SQLException sQLException) {
            System.out.println(Estilo.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
        return null;
    }
}
