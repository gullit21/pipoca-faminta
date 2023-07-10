package com.br.pipocafaminta.adapters.persistence.mapper.checkout;

import com.br.pipocafaminta.adapters.persistence.checkout.model.CheckoutEntity;
import com.br.pipocafaminta.application.domain.checkout.Checkout;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CheckoutPersistenceMapper {

    Checkout toCheckout(CheckoutEntity checkoutEntity);

    CheckoutEntity toCheckoutEntity(Checkout checkout);
}
