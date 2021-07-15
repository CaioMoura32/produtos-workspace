package br.com.tech4me.produto.service;

import java.util.List;


import br.com.tech4me.produto.sherad.ProdutoDto;

public interface ProdutoService {
    List<ProdutoDto> obterTodos();
    ProdutoDto cadastrarProduto(ProdutoDto pessoa);
    void removerProduto(String id);
    //Optional<ProdutoDto> obterPorCodigo(String codigo);
    ProdutoDto atualizarProduto(String id, ProdutoDto pessoa);
}
