package com.br.pipocafaminta.adapters.persistence.pedido;

import com.br.pipocafaminta.adapters.persistence.pedido.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPedidoRepository extends JpaRepository<PedidoEntity, Long> {


}
