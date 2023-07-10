package com.br.pipocafaminta.adapters.persistence.produto;

import com.br.pipocafaminta.adapters.persistence.produto.model.ProdutoEntity;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findAllByCategoria(CategoriaEnum categoria);

}
