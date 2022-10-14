/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.model;

import java.util.List;

/**
 *
 * @author Rafael Cavalcante
 */
public class Pessoa {

    private long cpf = -1;
    private String senha;
    private String nome;
    private String rua;
    private long numero;
    private String bairro;
    private List<Telefone> telefones;

    public Pessoa() {

    }

    public Pessoa(long cpf) {
        this.cpf = cpf;
    }

    public Pessoa(String senha) {
        this.senha = senha;
    }

    public Pessoa(long cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa(long cpf, String senha, String nome, String rua, long numero, String bairro, List<Telefone> telefones) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.telefones = telefones;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
