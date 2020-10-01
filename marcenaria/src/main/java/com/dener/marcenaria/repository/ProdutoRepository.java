package com.dener.marcenaria.repository;

import com.dener.marcenaria.model.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

}
