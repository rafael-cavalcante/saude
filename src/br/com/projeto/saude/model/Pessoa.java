/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.saude.model;

import java.util.List;

/**
 *
 * @author tecin
 */
public class Pessoa {

    private String cpf;
    private String senha;
    private String nome;
    private Endereco endereco;
    private List<Telefone> telefones;

    public Pessoa(){
        
    }
    
    public Pessoa(String cpf){
        this.cpf = cpf;
    }
    
    public Pessoa(String cpf, String senha){
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa(String cpf, String senha, String nome, Endereco endereco, List<Telefone> telefones) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
