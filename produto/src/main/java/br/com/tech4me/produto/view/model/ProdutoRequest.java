package br.com.tech4me.produto.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProdutoRequest {
    @NotBlank(message="O nome deve estar preenchido com caracteres válidos")
    @NotEmpty(message = "Nome não pode estar vazio")
    private String nome;
    private Double valor;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
