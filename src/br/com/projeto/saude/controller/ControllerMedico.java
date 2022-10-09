/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.controller;

import br.com.projeto.saude.model.Medico;
import br.com.projeto.saude.model.Tecnico;
import br.com.projeto.saude.repository.RepositoryMedico;
import br.com.projeto.saude.repository.RepositoryPessoa;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerMedico {
    
    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryMedico repositoryMedico;

    public ControllerMedico() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositoryMedico = new RepositoryMedico();
    }

    public void cadastrar(Medico medico, Tecnico tecnico) {
        if (!this.repositoryMedico.existe(medico)) {
            this.repositoryPessoa.adicionar(medico);
            this.repositoryMedico.adicionar(medico, tecnico);
        }
    }

    public Medico login(Medico medico) {
        return this.repositoryMedico.buscar(medico);
    }
    
    public List<Medico> listar(){
        return this.repositoryMedico.buscar();
    }
}
