package com.br.pipocafaminta.adapters.configuration;

import com.br.pipocafaminta.PipocaFamintaApplication;
import com.br.pipocafaminta.adapters.persistence.checkout.CheckoutRepository;
import com.br.pipocafaminta.adapters.persistence.cliente.ClienteRepository;
import com.br.pipocafaminta.adapters.persistence.pedido.PedidoRepository;
import com.br.pipocafaminta.adapters.persistence.produto.ProdutoRepository;
import com.br.pipocafaminta.adapters.web.mapper.cliente.ClienteWebMapper;
import com.br.pipocafaminta.adapters.web.mapper.pedido.PedidoWebMapper;
import com.br.pipocafaminta.application.services.checkout.CheckoutService;
import com.br.pipocafaminta.application.services.cliente.ClienteService;
import com.br.pipocafaminta.application.services.pedido.PedidoService;
import com.br.pipocafaminta.application.services.produto.ProdutoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PipocaFamintaApplication.class)
public class BeanConfiguration {

    @Bean
    ProdutoService produtoService(ProdutoRepository produtoRepository) {
        return new ProdutoService(produtoRepository, produtoRepository, produtoRepository, produtoRepository);
    }

    @Bean
    ClienteService clienteService(ClienteRepository clienteRepository, ClienteWebMapper clienteWebMapper) {
        return new ClienteService(clienteRepository, clienteRepository, clienteWebMapper);
    }

    @Bean
    PedidoService pedidoService(PedidoRepository pedidoRepository,
                                PedidoWebMapper pedidoWebMapper,
                                ClienteService clienteService,
                                ProdutoService produtoService) {
        return new PedidoService(pedidoRepository, pedidoRepository, pedidoWebMapper, clienteService, produtoService);
    }

    @Bean
    CheckoutService checkoutService(PedidoRepository pedidoRepository,
                                    CheckoutRepository checkoutRepository) {
        return new CheckoutService(pedidoRepository, pedidoRepository, checkoutRepository, checkoutRepository);
    }
}
