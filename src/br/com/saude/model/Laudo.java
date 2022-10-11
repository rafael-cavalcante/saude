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
public class Laudo {
    
    private int codigo;
    private LocalDate dataCriacao;
    private String descricao;

    public Laudo(){
        
    }
    
    public Laudo(int codigo){
        this.codigo = codigo;
    }
    
    public Laudo(int codigo, LocalDate dataCriacao){
        this.codigo = codigo;
        this.dataCriacao = dataCriacao;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
