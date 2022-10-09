/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.repository;

import br.com.projeto.saude.configuracao.conexao.Conexao;
import br.com.projeto.saude.model.Laudo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tecin
 */
public class RepositoryLaudo {

    public void adicionar(Laudo laudo) {
        try {
            String query = "INSERT INTO POSTINHO.LAUDO (codigo, data_criacao, descricao) "
                    + "VALUES (?,?,?);";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setInt(1, laudo.getCodigo());
            preparedStatement.setDate(2, Date.valueOf(laudo.getDataCriacao()));
            preparedStatement.setString(3, laudo.getDescricao());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            Conexao.desconectar();
        }
    }
    
    public boolean existe(Laudo laudo){
        try {
            String query = "SELECT codigo FROM POSTINHO.LAUDO "
                    + "WHERE codigo = ?;";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(query);

            preparedStatement.setInt(1, laudo.getCodigo());

            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
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
