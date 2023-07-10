package com.br.pipocafaminta.adapters.persistence.cliente;

import com.br.pipocafaminta.adapters.persistence.cliente.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByCpf(String cpf);

}
