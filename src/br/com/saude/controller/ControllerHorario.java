/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Horario;
import br.com.saude.model.Tecnico;
import br.com.saude.repository.RepositoryHarario;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerHorario {

    private final RepositoryHarario repositoryHorario;

    public ControllerHorario() {
        this.repositoryHorario = new RepositoryHarario();
    }
    
    public boolean adicionar(Tecnico tecnico, Horario horario){
        return this.repositoryHorario.adicionar(tecnico, horario);
    }

    public List<Horario> listar(LocalDate localDate) {
        return this.repositoryHorario.buscar(localDate);
    }
}
