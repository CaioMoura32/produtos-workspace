package br.com.tech4me.produto.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4me.produto.model.Produto;
import br.com.tech4me.produto.repository.ProdutoRepository;
import br.com.tech4me.produto.sherad.ProdutoDto;
import java.util.stream.Collectors;

@Service
public class ProdotoServiceIpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repositorio;

   

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produto = repositorio.findAll();

        return produto.stream()
        .map(prod -> new ModelMapper().map(produto, ProdutoDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto cadastrarProduto(ProdutoDto produto) {
        ModelMapper mapa = new ModelMapper();
        Produto pro = mapa.map(produto, Produto.class);
        pro = repositorio.save(pro);
        return mapa.map(pro, ProdutoDto.class);
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
        
    }

    /*@Override
    public Optional<ProdutoDto> obterPorCodigo(Integer codigo) {
        Optional<Produto> prod = repositorio.findById(codigo);

        if (prod.isPresent()) {
            ProdutoDto prodDto = new ModelMapper().map(prod.get(), ProdutoDto.class);
            prodDto.setVenda(produtoMs.obterPorVenda(codigo));
            
          return Optional.of(prodDto);
        }
        return Optional.empty();
    }*/

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produto) {
        ModelMapper mapa = new ModelMapper();
        Produto prod = mapa.map(produto, Produto.class);
        prod.setId(id);
        prod = repositorio.save(prod);

        return mapa.map(prod, ProdutoDto.class);
    }
}
