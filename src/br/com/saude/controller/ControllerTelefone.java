/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Pessoa;
import br.com.saude.model.Telefone;
import br.com.saude.repository.RepositoryTelefone;
import java.util.List;

/**
 * Classe responsável por solicita as operações com o objeto telefone.
 *
 * @author Rafael Cavalcante
 */
public class ControllerTelefone {

    private final RepositoryTelefone repositoryTelefone;

    public ControllerTelefone() {
        this.repositoryTelefone = new RepositoryTelefone();
    }

    public boolean cadastrar(Telefone telefone, Pessoa pessoa) {
        if (!this.repositoryTelefone.existe(telefone, pessoa)) {
            return this.repositoryTelefone.adicionar(telefone, pessoa);
        }
        return false;
    }

    public List<Telefone> listar(Pessoa pessoa) {
        return this.repositoryTelefone.buscar(pessoa);
    }
}
