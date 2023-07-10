package com.br.pipocafaminta.application.domain.produto;

import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRQ {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Big Mac")
    private String nome;

    @Schema(example = "LANCHE")
    private CategoriaEnum categoria;

    @Schema(example = "30.9")
    private BigDecimal preco;

    @Schema(example = "Pao, carne, queijo e molho especial")
    private String descricao;

    @Schema(example = "url da imagem")
    private String urlImagem;
}
