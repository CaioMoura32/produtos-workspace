package br.com.tech4me.produto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.produto.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, Integer> {
    
}
