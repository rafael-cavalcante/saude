/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Paciente;
import br.com.saude.repository.RepositoryPaciente;
import br.com.saude.repository.RepositoryPessoa;
import br.com.saude.repository.RepositoryTelefone;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerPaciente {

    private final RepositoryPessoa repositoryPessoa;
    private final RepositoryPaciente repositoryPaciente;
    private final RepositoryTelefone repositoryTelefone;

    public ControllerPaciente() {
        this.repositoryPessoa = new RepositoryPessoa();
        this.repositoryPaciente = new RepositoryPaciente();
        this.repositoryTelefone = new RepositoryTelefone();
    }

    public boolean cadastrar(Paciente paciente) {
        if (!this.repositoryPessoa.existe(paciente)) {
            this.repositoryPessoa.adicionar(paciente);
            return this.repositoryPaciente.adicionar(paciente);
        }
        return false;
    }

    public Paciente procurar(Paciente paciente) {
        return this.repositoryPaciente.buscar(paciente);
    }

    public Paciente login(Paciente paciente) {
        paciente = this.repositoryPaciente.buscar(paciente);
        if (paciente != null) {
            paciente.setTelefones(this.repositoryTelefone.buscar(paciente));
        }
        return paciente;
    }

    public List<Paciente> listar() {
        return this.repositoryPaciente.buscar();
    }

    public boolean alterar(Paciente paciente) {
        if (this.repositoryPaciente.existe(paciente)) {
            this.repositoryPessoa.atualizar(paciente);
            return this.repositoryPaciente.atualizar(paciente);
        }
        return false;
    }

    public Paciente buscar(String crmMedico, long codigoProntuario) {
        return this.repositoryPaciente.buscar(crmMedico, codigoProntuario);
    }
    
    public String buscarEmail(long cpf){
        return this.repositoryPaciente.buscarEmail(cpf);
    }
}
