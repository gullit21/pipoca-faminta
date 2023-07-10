package com.br.pipocafaminta.application.domain.produto;

import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private CategoriaEnum categoria;
    private BigDecimal preco;
    private String descricao;
    private String urlImagem;

}
