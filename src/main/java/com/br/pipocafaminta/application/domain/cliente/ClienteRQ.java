package com.br.pipocafaminta.application.domain.cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRQ {

    @Schema(example = "12159042072")
    private String cpf;

    @Schema(example = "Gullit")
    private String nome;

    @Schema(example = "gmail@gmail.com")
    private String email;

}
