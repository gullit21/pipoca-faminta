package com.br.pipocafaminta.application.services.pedido;

import com.br.pipocafaminta.adapters.exceptions.notfound.PedidoNotFoundException;
import com.br.pipocafaminta.adapters.web.mapper.pedido.PedidoWebMapper;
import com.br.pipocafaminta.application.domain.cliente.Cliente;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.pedido.Pedido;
import com.br.pipocafaminta.application.domain.pedido.PedidoRQ;
import com.br.pipocafaminta.application.domain.produto.Produto;
import com.br.pipocafaminta.application.port.incoming.pedido.*;
import com.br.pipocafaminta.application.port.incoming.produto.BuscarProdutoUseCase;
import com.br.pipocafaminta.application.port.outgoing.pedido.BuscarPedidoPort;
import com.br.pipocafaminta.application.port.outgoing.pedido.SalvarPedidoPort;
import com.br.pipocafaminta.application.services.cliente.ClienteService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoService implements FazerPedidoEtapaLancheUseCase,
        FazerPedidoEtapaAcompanhamentoUseCase,
        FazerPedidoEtapaBebidaUseCase,
        FazerPedidoEtapaSobremesaUseCase,
        FazerPedidoEtapaConfirmacaoUseCase,
        BuscarPedidoUseCase {

    private final SalvarPedidoPort salvarPedidoPort;
    private final BuscarPedidoPort buscarPedidoPort;
    private final PedidoWebMapper pedidoWebMapper;
    private final ClienteService clienteService;
    private final BuscarProdutoUseCase buscarProdutoUseCase;

    public PedidoService(SalvarPedidoPort salvarPedidoPort,
                         BuscarPedidoPort buscarPedidoPort,
                         PedidoWebMapper pedidoWebMapper,
                         ClienteService clienteService,
                         BuscarProdutoUseCase buscarProdutoUseCase) {
        this.salvarPedidoPort = salvarPedidoPort;
        this.buscarPedidoPort = buscarPedidoPort;
        this.pedidoWebMapper = pedidoWebMapper;
        this.clienteService = clienteService;
        this.buscarProdutoUseCase = buscarProdutoUseCase;
    }

    @Override
    public Pedido etapaLanche(PedidoRQ pedidoRQ) {
        var cliente = getCliente(pedidoRQ);
        var produtos = getProdutos(pedidoRQ);
        var pedidoEncontrado = getPedido(pedidoRQ.getId());

        pedidoWebMapper.toPedido(pedidoEncontrado, pedidoRQ, cliente, produtos, CategoriaEnum.LANCHE);

        pedidoEncontrado.calculaValorTotal();
        pedidoEncontrado.statusEmAndamento();
        return salvarPedidoPort.save(pedidoEncontrado);
    }

    @Override
    public Pedido etapaAcompanhamento(PedidoRQ pedidoRQ) {
        var cliente = getCliente(pedidoRQ);
        var produtos = getProdutos(pedidoRQ);
        var pedidoEncontrado = getPedido(pedidoRQ.getId());

        pedidoWebMapper.toPedido(pedidoEncontrado, pedidoRQ, cliente, produtos, CategoriaEnum.ACOMPANHAMENTO);

        pedidoEncontrado.calculaValorTotal();

        return salvarPedidoPort.save(pedidoEncontrado);
    }

    @Override
    public Pedido etapaBebida(PedidoRQ pedidoRQ) {
        var cliente = getCliente(pedidoRQ);
        var produtos = getProdutos(pedidoRQ);
        var pedidoEncontrado = getPedido(pedidoRQ.getId());

        pedidoWebMapper.toPedido(pedidoEncontrado, pedidoRQ, cliente, produtos, CategoriaEnum.BEBIDA);

        pedidoEncontrado.calculaValorTotal();

        return salvarPedidoPort.save(pedidoEncontrado);
    }

    @Override
    public Pedido etapaSobremesa(PedidoRQ pedidoRQ) {
        var cliente = getCliente(pedidoRQ);
        var produtos = getProdutos(pedidoRQ);
        var pedidoEncontrado = getPedido(pedidoRQ.getId());

        pedidoWebMapper.toPedido(pedidoEncontrado, pedidoRQ, cliente, produtos, CategoriaEnum.SOBREMESA);

        pedidoEncontrado.calculaValorTotal();

        return salvarPedidoPort.save(pedidoEncontrado);
    }

    @Override
    public Pedido etapaConfirmacao(PedidoRQ pedidoRQ) {
        var pedidoEncontrado = getPedido(pedidoRQ.getId());

        pedidoEncontrado.calculaValorTotal();
        pedidoEncontrado.statusConfirmado();
        return salvarPedidoPort.save(pedidoEncontrado);
    }

    @Override
    public List<Pedido> listarTodos() {
        return buscarPedidoPort.listarTodos();
    }

    private Cliente getCliente(PedidoRQ pedidoRQ) {
        if (Objects.isNull(pedidoRQ.getClienteId())) {
            return null;
        }
        return clienteService.findById(pedidoRQ.getClienteId());
    }

    private List<Produto> getProdutos(PedidoRQ pedidoRQ) {
        if (Objects.nonNull(pedidoRQ.getProdutoIdList())
            && !CollectionUtils.isEmpty(pedidoRQ.getProdutoIdList())) {

            return buscarProdutoUseCase.findAllById(pedidoRQ.getProdutoIdList());
        }

        return new ArrayList<>();
    }

    private Pedido getPedido(Long id) {
        if (Objects.isNull(id)) {
            return Pedido.builder().build();
        }

        try {
            return buscarPedidoPort.findById(id);

        } catch (PedidoNotFoundException exception) {
            return Pedido.builder().build();
        }
    }
}