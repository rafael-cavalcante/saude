/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.configuracao.conexao;

import br.com.saude.configuracao.estilo.Estilo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por realizar e finalizar a conexão com o banco de dados.
 *
 * @author Rafael Cavalcante
 */
public class Conexao {

    private final static String URL = "jdbc:postgresql://localhost/saude";
    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";
    private final static String DRIVER = "org.postgresql.Driver";
    private static Connection connection;

    public static Connection conectar() {
        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println(Estilo.ROXO.getCor() + classNotFoundException.getMessage());
        }
        return null;
    }

    public static void desconectar() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException sQLException) {
            System.out.println(Estilo.ROXO.getCor() + sQLException.getMessage());
        }
    }
}
