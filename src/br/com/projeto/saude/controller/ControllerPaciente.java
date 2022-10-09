/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.controller;

import br.com.projeto.saude.model.Paciente;
import br.com.projeto.saude.repository.RepositoryPaciente;
import br.com.projeto.saude.repository.RepositoryPessoa;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerPaciente {
    
    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryPaciente repositoryPaciente;

    public ControllerPaciente() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositoryPaciente = new RepositoryPaciente();
    }

    public void cadastrar(Paciente paciente) {
        if (!this.repositoryPaciente.existe(paciente)) {
            this.repositoryPessoa.adicionar(paciente);
            this.repositoryPaciente.adicionar(paciente);
        }
    }

    public Paciente login(Paciente paciente) {
        return this.repositoryPaciente.buscar(paciente);
    }
    
    public List<Paciente> listar(){
        return this.repositoryPaciente.buscar();
    }
    
    public boolean alterar(Paciente paciente){
        if(this.repositoryPaciente.existe(paciente)){
            this.repositoryPessoa.atualizar(paciente);
            return this.repositoryPaciente.atualizar(paciente);
        }
        return false;
    }
}
