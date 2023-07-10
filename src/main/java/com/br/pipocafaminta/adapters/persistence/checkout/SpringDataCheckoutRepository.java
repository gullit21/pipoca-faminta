package com.br.pipocafaminta.adapters.persistence.checkout;

import com.br.pipocafaminta.adapters.persistence.checkout.model.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataCheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

    Optional<CheckoutEntity> findByPedidoId(Long id);
}
