package com.br.pipocafaminta.adapters.persistence.checkout;

import com.br.pipocafaminta.adapters.exceptions.notfound.CheckoutNotFoundException;
import com.br.pipocafaminta.adapters.persistence.mapper.checkout.CheckoutPersistenceMapper;
import com.br.pipocafaminta.application.domain.checkout.Checkout;
import com.br.pipocafaminta.application.port.outgoing.checkout.BuscarCheckoutPort;
import com.br.pipocafaminta.application.port.outgoing.checkout.SalvarCheckoutPort;
import org.springframework.stereotype.Component;

@Component
public class CheckoutRepository implements SalvarCheckoutPort, BuscarCheckoutPort {

    private final SpringDataCheckoutRepository springDataCheckoutRepository;
    private final CheckoutPersistenceMapper checkoutPersistenceMapper;


    public CheckoutRepository(SpringDataCheckoutRepository springDataCheckoutRepository,
                              CheckoutPersistenceMapper checkoutPersistenceMapper) {
        this.springDataCheckoutRepository = springDataCheckoutRepository;
        this.checkoutPersistenceMapper = checkoutPersistenceMapper;
    }

    @Override
    public Checkout findById(Long id) {
        var checkoutEntity = springDataCheckoutRepository.findById(id)
                .orElseThrow(CheckoutNotFoundException::new);
        return checkoutPersistenceMapper.toCheckout(checkoutEntity);
    }

    @Override
    public Checkout findByPedidoId(Long id) {
        var checkoutEntity = springDataCheckoutRepository.findByPedidoId(id)
                .orElseThrow(CheckoutNotFoundException::new);
        return checkoutPersistenceMapper.toCheckout(checkoutEntity);
    }

    @Override
    public Checkout save(Checkout checkout) {
        var checkoutEntity = checkoutPersistenceMapper.toCheckoutEntity(checkout);
        var checkoutSaved = springDataCheckoutRepository.save(checkoutEntity);

        return checkoutPersistenceMapper.toCheckout(checkoutSaved);
    }
}