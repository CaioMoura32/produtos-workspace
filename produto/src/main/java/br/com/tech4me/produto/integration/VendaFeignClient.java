package br.com.tech4me.produto.integration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.produto.sherad.Venda;

@FeignClient(name= "produto-ms")
public class VendaFeignClient {
    @GetMapping(path= "/api/produto/{venda}/lista")
    List<Venda> obterPorVenda(@PathVariable String venda);
}
