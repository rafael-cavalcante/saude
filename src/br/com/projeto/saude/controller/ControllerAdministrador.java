/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.controller;

import br.com.projeto.saude.model.Administrador;
import br.com.projeto.saude.repository.RepositoryAdministrador;
import br.com.projeto.saude.repository.RepositoryPessoa;

/**
 *
 * @author tecin
 */
public class ControllerAdministrador {

    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryAdministrador repositoryAdministrador;

    public ControllerAdministrador() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositoryAdministrador = new RepositoryAdministrador();
    }

    public void cadastrar(Administrador administrador) {
        if (!this.repositoryAdministrador.existe(administrador)) {
            this.repositoryPessoa.adicionar(administrador);
            this.repositoryAdministrador.adicionar(administrador);
        }
    }

    public Administrador login(Administrador administrador) {
        return  this.repositoryAdministrador.buscar(administrador);
    }
}
