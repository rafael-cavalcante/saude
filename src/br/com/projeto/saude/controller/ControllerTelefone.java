/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.controller;

import br.com.projeto.saude.model.Pessoa;
import br.com.projeto.saude.model.Telefone;
import br.com.projeto.saude.repository.RepositoryTelefone;
import java.util.List;

/**
 * Classe responsável por solicita as operações com o objeto telefone.
 * 
 * @author Rafael Cavalcante
 */
public class ControllerTelefone {
    
    private final RepositoryTelefone repositoryTelefone;
    
    public ControllerTelefone(){
        this.repositoryTelefone = new RepositoryTelefone();
    }
    
    public void cadastrar(Telefone telefone, Pessoa pessoa){
        if(!this.repositoryTelefone.existe(telefone, pessoa)){
            this.repositoryTelefone.adicionar(telefone, pessoa);
        }
    }
    
    public List<Telefone> listar(Pessoa pessoa){
        return this.repositoryTelefone.buscar(pessoa);
    }
}
