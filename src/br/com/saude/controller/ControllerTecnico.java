/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Administrador;
import br.com.saude.model.Tecnico;
import br.com.saude.repository.RepositoryPessoa;
import br.com.saude.repository.RepositoryTecnico;
import br.com.saude.repository.RepositoryTelefone;

/**
 *
 * @author tecin
 */
public class ControllerTecnico {

    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryTecnico repositorytecnico;
    private final RepositoryTelefone repositoryTelefone;

    public ControllerTecnico() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositorytecnico = new RepositoryTecnico();
        this.repositoryTelefone = new RepositoryTelefone();
    }

    public boolean cadastrar(Tecnico tecnico, Administrador administrador) {
        if (!this.repositoryPessoa.existe(tecnico)) {
            this.repositoryPessoa.adicionar(tecnico);
            return this.repositorytecnico.adicionar(tecnico, administrador);
        }
        return false;
    }

    public Tecnico login(Tecnico tecnico) {
        tecnico = this.repositorytecnico.buscar(tecnico);
        if (tecnico != null) {
            tecnico.setTelefones(this.repositoryTelefone.buscar(tecnico));
        }
        return tecnico;
    }
}
