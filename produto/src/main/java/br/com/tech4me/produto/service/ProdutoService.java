package br.com.tech4me.produto.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.produto.sherad.ProdutoDto;

public interface ProdutoService {
    List<ProdutoDto> obterTodos();
    ProdutoDto cadastrarProduto(ProdutoDto pessoa);
    void removerProduto(Integer codigo);
    Optional<ProdutoDto> obterPorCodigo(Integer codigo);
    ProdutoDto atualizarProduto(Integer codigo, ProdutoDto pessoa);
}
