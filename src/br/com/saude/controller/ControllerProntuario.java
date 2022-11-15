/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Paciente;
import br.com.saude.model.Prontuario;
import br.com.saude.repository.RepositoryProntuario;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerProntuario {

    private final RepositoryProntuario repositoryProntuario;

    public ControllerProntuario() {
        this.repositoryProntuario = new RepositoryProntuario();
    }

    public List<Prontuario> listar(Paciente paciente) {
        return this.repositoryProntuario.buscar(paciente);
    }

    public List<Prontuario> buscar(String crm) {
        return this.repositoryProntuario.buscar(crm);
    }
}
