/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Administrador;
import br.com.saude.model.Tecnico;
import br.com.saude.repository.RepositoryPessoa;
import br.com.saude.repository.RepositoryTecnico;

/**
 *
 * @author tecin
 */
public class ControllerTecnico {

    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryTecnico repositorytecnico;

    public ControllerTecnico() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositorytecnico = new RepositoryTecnico();
    }

    public void cadastrar(Tecnico tecnico, Administrador administrador) {
        if (!this.repositorytecnico.existe(tecnico)) {
            this.repositoryPessoa.adicionar(tecnico);
            this.repositorytecnico.adicionar(tecnico, administrador);
        }
    }

    public Tecnico login(Tecnico tecnico) {
        return this.repositorytecnico.buscar(tecnico);
    }
}
