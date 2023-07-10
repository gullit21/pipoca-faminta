package com.br.pipocafaminta.adapters.web;

import com.br.pipocafaminta.adapters.web.annotations.PipocaFamintaController;
import com.br.pipocafaminta.adapters.web.mapper.pedido.PedidoWebMapper;
import com.br.pipocafaminta.application.domain.pedido.PedidoRQ;
import com.br.pipocafaminta.application.domain.pedido.PedidoRS;
import com.br.pipocafaminta.application.port.incoming.pedido.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@PipocaFamintaController
public class PedidosController {

    private final FazerPedidoEtapaLancheUseCase fazerPedidoEtapaLancheUseCase;
    private final FazerPedidoEtapaAcompanhamentoUseCase fazerPedidoEtapaAcompanhamentoUseCase;
    private final FazerPedidoEtapaBebidaUseCase fazerPedidoEtapaBebidaUseCase;
    private final FazerPedidoEtapaSobremesaUseCase fazerPedidoEtapaSobremesaUseCase;
    private final FazerPedidoEtapaConfirmacaoUseCase fazerPedidoEtapaConfirmacaoUseCase;
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final PedidoWebMapper pedidoWebMapper;

    @PostMapping("/pedidos/etapa-lanche")
    public ResponseEntity<PedidoRS> etapaLanche(@RequestBody PedidoRQ pedidoRQ) {
        var pedidoSaved = fazerPedidoEtapaLancheUseCase.etapaLanche(pedidoRQ);

        return ResponseEntity.ok(pedidoWebMapper.toPedidoRS(pedidoSaved));
    }

    @PostMapping("/pedidos/etapa-acompanhamento")
    public ResponseEntity<PedidoRS> etapaAcompanhamento(@RequestBody PedidoRQ pedidoRQ) {
        var pedidoSaved = fazerPedidoEtapaAcompanhamentoUseCase.etapaAcompanhamento(pedidoRQ);

        return ResponseEntity.ok(pedidoWebMapper.toPedidoRS(pedidoSaved));
    }

    @PostMapping("/pedidos/etapa-bebida")
    public ResponseEntity<PedidoRS> etapaBebida(@RequestBody PedidoRQ pedidoRQ) {
        var pedidoSaved = fazerPedidoEtapaBebidaUseCase.etapaBebida(pedidoRQ);

        return ResponseEntity.ok(pedidoWebMapper.toPedidoRS(pedidoSaved));
    }

    @PostMapping("/pedidos/etapa-sobremesa")
    public ResponseEntity<PedidoRS> etapaSobremesa(@RequestBody PedidoRQ pedidoRQ) {
        var pedidoSaved = fazerPedidoEtapaSobremesaUseCase.etapaSobremesa(pedidoRQ);

        return ResponseEntity.ok(pedidoWebMapper.toPedidoRS(pedidoSaved));
    }

    @PostMapping("/pedidos/etapa-confirmacao")
    public ResponseEntity<PedidoRS> etapaConfirmacao(@RequestBody PedidoRQ pedidoRQ) {
        var pedidoSaved = fazerPedidoEtapaConfirmacaoUseCase.etapaConfirmacao(pedidoRQ);

        return ResponseEntity.ok(pedidoWebMapper.toPedidoRS(pedidoSaved));
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoRS>> listarTodos() {
        var pedidos = buscarPedidoUseCase.listarTodos();

        return ResponseEntity.ok(pedidoWebMapper.toPedidoRSList(pedidos));
    }
}