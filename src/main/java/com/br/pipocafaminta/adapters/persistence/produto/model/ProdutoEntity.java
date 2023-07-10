package com.br.pipocafaminta.adapters.persistence.produto.model;

import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;
    private BigDecimal preco;
    private String descricao;
    private String urlImagem;
}
