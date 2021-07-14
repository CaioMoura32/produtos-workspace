package br.com.tech4me.produto.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.produto.integration.VendaFeignClient;
import br.com.tech4me.produto.model.Produto;
import br.com.tech4me.produto.repository.ProdutoRepository;
import br.com.tech4me.produto.sherad.ProdutoDto;
import java.util.stream.Collectors;

@Service
public class ProdotoServiceIpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repositorio;

    @Autowired
    private VendaFeignClient produtoMs;

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produto = repositorio.findAll();

        return produto.stream()
        .map(prod -> new ModelMapper().map(produto, ProdutoDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto cadastrarProduto(ProdutoDto pessoa) {
        ModelMapper mapa = new ModelMapper();
        Produto pro = mapa.map(pessoa, Produto.class);
        pro = repositorio.save(pro);
        return mapa.map(pro, ProdutoDto.class);
    }

    @Override
    public void removerProduto(Integer codigo) {
        repositorio.deleteById(codigo);
        
    }

    @Override
    public Optional<ProdutoDto> obterPorCodigo(Integer codigo) {
        Optional<Produto> prod = repositorio.findById(codigo);

        if (prod.isPresent()) {
            ProdutoDto prodDto = new ModelMapper().map(prod.get(), ProdutoDto.class);
            prodDto.setVenda(produtoMs.obterPorVenda(codigo));
            
          return Optional.of(prodDto);
        }
        return Optional.empty();
    }

    @Override
    public ProdutoDto atualizarProduto(Integer codigo, ProdutoDto produto) {
        ModelMapper mapa = new ModelMapper();
        Produto prod = mapa.map(produto, Produto.class);
        prod.setCodigo(codigo);
        prod = repositorio.save(prod);

        return mapa.map(prod, ProdutoDto.class);
    }
}
