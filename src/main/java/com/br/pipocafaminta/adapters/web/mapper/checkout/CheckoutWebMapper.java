package com.br.pipocafaminta.adapters.web.mapper.checkout;

import com.br.pipocafaminta.application.domain.checkout.Checkout;
import com.br.pipocafaminta.application.domain.checkout.CheckoutRS;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CheckoutWebMapper {

    CheckoutRS toCheckoutRS(Checkout checkout);
}
