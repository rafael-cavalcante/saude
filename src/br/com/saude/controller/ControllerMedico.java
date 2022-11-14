/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Medico;
import br.com.saude.model.Paciente;
import br.com.saude.model.Prontuario;
import br.com.saude.model.Tecnico;
import br.com.saude.repository.RepositoryMedico;
import br.com.saude.repository.RepositoryPessoa;
import br.com.saude.repository.RepositoryTelefone;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerMedico {

    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryMedico repositoryMedico;
    private final RepositoryTelefone repositoryTelefone;

    public ControllerMedico() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositoryMedico = new RepositoryMedico();
        this.repositoryTelefone = new RepositoryTelefone();
    }

    public boolean cadastrar(Medico medico, Tecnico tecnico) {
        if (!repositoryPessoa.existe(medico)) {
            this.repositoryPessoa.adicionar(medico);
            return this.repositoryMedico.adicionar(medico, tecnico);
        }
        return false;
    }

    public Medico login(Medico medico) {
        medico = this.repositoryMedico.buscar(medico);
        if (medico != null) {
            medico.setTelefones(this.repositoryTelefone.buscar(medico));
        }
        return medico;
    }

    public List<Medico> listar() {
        return this.repositoryMedico.buscar();
    }
    
    public Medico procurar(Paciente paciente, Prontuario prontuario){
        return this.repositoryMedico.buscar(paciente, prontuario);
    }
}
