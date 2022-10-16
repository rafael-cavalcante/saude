/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.model;

import java.time.LocalDate;

/**
 *
 * @author tecin
 */
public class Consulta {
    
    private Paciente paciente;
    private Medico medico;
    private Prontuario prontuario;
    private LocalDate dataRealizacao;
    private String status;
    private int pressao;
    private double peso;
    private int prioridade;
    
    public Consulta(){
        
    }

    public Consulta(Paciente paciente, Medico medico, Prontuario prontuario, LocalDate dataRealizacao, String status, int prioridade) {
        this.paciente = paciente;
        this.medico = medico;
        this.prontuario = prontuario;
        this.dataRealizacao = dataRealizacao;
        this.status = status;
        this.prioridade = prioridade;
    }

    public Consulta(Paciente paciente, Medico medico, Prontuario prontuario, LocalDate dataRealizacao, String status, int pressao, double peso, int prioridade) {
        this.paciente = paciente;
        this.medico = medico;
        this.prontuario = prontuario;
        this.dataRealizacao = dataRealizacao;
        this.status = status;
        this.pressao = pressao;
        this.peso = peso;
        this.prioridade = prioridade;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }   
}
