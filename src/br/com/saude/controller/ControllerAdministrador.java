/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Administrador;
import br.com.saude.repository.RepositoryAdministrador;
import br.com.saude.repository.RepositoryPessoa;
import br.com.saude.repository.RepositoryTelefone;

/**
 *
 * @author tecin
 */
public class ControllerAdministrador {

    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryAdministrador repositoryAdministrador;
    private final RepositoryTelefone repositoryTelefone;

    public ControllerAdministrador() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositoryAdministrador = new RepositoryAdministrador();
        this.repositoryTelefone = new RepositoryTelefone();
    }

    public void cadastrar(Administrador administrador) {
        if (!this.repositoryAdministrador.existe(administrador)) {
            this.repositoryPessoa.adicionar(administrador);
            this.repositoryAdministrador.adicionar(administrador);
        }
    }

    public Administrador login(Administrador administrador) {
        administrador = this.repositoryAdministrador.buscar(administrador);
        if (administrador != null) {
            administrador.setTelefones(this.repositoryTelefone.buscar(administrador));
        }
        return administrador;
    }
}
