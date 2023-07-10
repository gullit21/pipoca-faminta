package com.br.pipocafaminta.adapters.persistence.cliente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "clientes")
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String cpf;
    private String nome;
    private String email;
}
