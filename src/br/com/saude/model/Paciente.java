/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author tecin
 */
public class Paciente extends Pessoa {

    private long rg;
    private LocalDate dataNascimento;
    private String email;

    public Paciente(){
        
    }

    public Paciente(long cpf) {
        super(cpf);
    }
    
    public Paciente(long cpf, String senha) {
        super(cpf, senha);
    }

    public Paciente(long cpf, String senha, String nome, String rua, long numero, String bairro, List<Telefone> telefones, long rg, LocalDate dataNascimento, String email) {
        super(cpf, senha, nome, rua, numero, bairro, telefones);
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
