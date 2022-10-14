/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.repository;

import br.com.saude.configuracao.conexao.Conexao;
import br.com.saude.configuracao.estilo.Cor;
import br.com.saude.model.Prontuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tecin
 */
public class RepositoryProntuario {

    public void adicionar(Prontuario prontuario) {
        try {
            String query = "INSERT INTO POSTINHO.LAUDO (codigo, data_criacao, descricao) "
                    + "VALUES (?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, prontuario.getCodigo());
            preparedStatement.setDate(2, Date.valueOf(prontuario.getDataCriacao()));
            preparedStatement.setString(3, prontuario.getDescricao());

            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            System.out.println(Cor.VERMELHO.getCor() + sQLException.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }
    
    public boolean existe(Prontuario prontuario){
        try {
            String query = "SELECT codigo FROM POSTINHO.LAUDO "
                    + "WHERE codigo = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setLong(1, prontuario.getCodigo());

            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
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
