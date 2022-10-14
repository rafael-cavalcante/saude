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
public class Prontuario {
    
    private long codigo;
    private LocalDate dataCriacao;
    private String descricao;

    public Prontuario() {
    }

    public Prontuario(long codigo) {
        this.codigo = codigo;
    }

    public Prontuario(long codigo, LocalDate dataCriacao) {
        this.codigo = codigo;
        this.dataCriacao = dataCriacao;
    }

    public Prontuario(long codigo, LocalDate dataCriacao, String descricao) {
        this.codigo = codigo;
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
    }
    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  
}
