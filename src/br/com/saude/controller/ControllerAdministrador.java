/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Administrador;
import br.com.saude.repository.RepositoryAdministrador;
import br.com.saude.repository.RepositoryPessoa;

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
