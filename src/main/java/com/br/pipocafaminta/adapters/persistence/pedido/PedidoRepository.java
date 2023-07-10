package com.br.pipocafaminta.adapters.persistence.pedido;

import com.br.pipocafaminta.adapters.exceptions.notfound.PedidoNotFoundException;
import com.br.pipocafaminta.adapters.persistence.mapper.pedido.PedidoPersistenceMapper;
import com.br.pipocafaminta.application.domain.pedido.Pedido;
import com.br.pipocafaminta.application.port.outgoing.pedido.BuscarPedidoPort;
import com.br.pipocafaminta.application.port.outgoing.pedido.SalvarPedidoPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoRepository implements SalvarPedidoPort, BuscarPedidoPort {

    private final SpringDataPedidoRepository springDataPedidoRepository;
    private final PedidoPersistenceMapper pedidoPersistenceMapper;


    public PedidoRepository(SpringDataPedidoRepository springDataPedidoRepository,
                            PedidoPersistenceMapper pedidoPersistenceMapper) {
        this.springDataPedidoRepository = springDataPedidoRepository;
        this.pedidoPersistenceMapper = pedidoPersistenceMapper;
    }

    @Override
    public Pedido save(Pedido pedido) {
        var pedidoEntity = pedidoPersistenceMapper.toPedidoEntity(pedido);
        var pedidoSaved = springDataPedidoRepository.save(pedidoEntity);

        return pedidoPersistenceMapper.toPedidoList(pedidoSaved);
    }

    @Override
    public List<Pedido> listarTodos() {
        return pedidoPersistenceMapper.toPedidoList(springDataPedidoRepository.findAll());
    }

    @Override
    public Pedido findById(Long id) {
        var pedidoEntity = springDataPedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
        return pedidoPersistenceMapper.toPedidoList(pedidoEntity);
    }

}
