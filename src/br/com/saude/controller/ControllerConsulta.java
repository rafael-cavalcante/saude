/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.controller;

import br.com.saude.model.Consulta;
import br.com.saude.model.Paciente;
import br.com.saude.repository.RepositoryConsulta;
import br.com.saude.repository.RepositoryLaudo;
import java.util.List;

/**
 *
 * @author tecin
 */
public class ControllerConsulta {
    
    private final RepositoryConsulta repositoryConsulta;
    private final RepositoryLaudo repositoryLaudo;
    
    public ControllerConsulta(){
        this.repositoryConsulta = new RepositoryConsulta();
        this.repositoryLaudo = new RepositoryLaudo();
    }
    
    public void solicitar(Consulta consulta){
        if(!this.repositoryConsulta.existe(consulta)){
            this.repositoryLaudo.adicionar(consulta.getLaudo());
            this.repositoryConsulta.adicionar(consulta);
        }
    }
    
    public List<Consulta> listar(Paciente paciente){
        return this.repositoryConsulta.buscar(paciente);
    }
    
    public boolean alterar(Consulta consulta){
        if(this.repositoryConsulta.existe(consulta)){
            return this.repositoryConsulta.atualizar(consulta);
        }
        return false;
    }
}