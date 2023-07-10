package com.br.pipocafaminta.application.domain.pedido;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRQ {

    private Long id;

    @Schema(example = "1")
    private Long clienteId;

    private List<Long> produtoIdList;
    
}
