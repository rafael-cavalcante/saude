/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Medicamento;
import br.com.saude.model.Prontuario;
import br.com.saude.repository.RepositoryMedicamento;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerMedicamento {
    
    private final RepositoryMedicamento repositoryMedicamento;
    
    public ControllerMedicamento(){
        this.repositoryMedicamento = new RepositoryMedicamento();
    }
    
    public boolean adicionar(Prontuario prontuario, Medicamento medicamento){
        return this.repositoryMedicamento.adicionar(prontuario, medicamento);
    }
    
    public List<Medicamento> listar(Prontuario prontuario){
        return this.repositoryMedicamento.buscar(prontuario);
    }
}
