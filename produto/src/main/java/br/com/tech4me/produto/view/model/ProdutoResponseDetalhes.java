package br.com.tech4me.produto.view.model;

import java.util.List;

import br.com.tech4me.produto.sherad.Venda;

public class ProdutoResponseDetalhes {
    private Integer codigo;
    private String nome;
    private List<Venda> venda;

    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Venda> getVenda() {
        return venda;
    }
    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    
}
