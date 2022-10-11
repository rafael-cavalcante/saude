/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tecin
 */
public class Paciente extends Pessoa {

    private String rg;
    private LocalDate dataNascimento;

    public Paciente(){
        
    }

    public Paciente(String cpf) {
        super(cpf);
    }
    
    public Paciente(String cpf, String senha) {
        super(cpf, senha);
    }

    public Paciente(String cpf, String senha, String nome, Endereco endereco, List<Telefone> telefones, String rg, LocalDate dataNascimento) {
        super(cpf, senha, nome, endereco, telefones);
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}