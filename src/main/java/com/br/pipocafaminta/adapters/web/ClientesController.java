package com.br.pipocafaminta.adapters.web;

import com.br.pipocafaminta.adapters.web.annotations.PipocaFamintaController;
import com.br.pipocafaminta.adapters.web.mapper.cliente.ClienteWebMapper;
import com.br.pipocafaminta.application.domain.cliente.ClienteRQ;
import com.br.pipocafaminta.application.domain.cliente.ClienteRS;
import com.br.pipocafaminta.application.port.incoming.cliente.BuscarClienteUseCase;
import com.br.pipocafaminta.application.port.incoming.cliente.SalvarClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@PipocaFamintaController
public class ClientesController {

    private final SalvarClienteUseCase salvarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;
    private final ClienteWebMapper clienteWebMapper;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteRS> create(@RequestBody ClienteRQ clienteRQ) {
        var clienteSaved = salvarClienteUseCase.save(clienteRQ);

        return ResponseEntity.ok(clienteWebMapper.toClienteRS(clienteSaved));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteRS>> findAll() {
        var clienteRSList = buscarClienteUseCase.findAll();
        return ResponseEntity.ok(clienteWebMapper.toClienteRSList(clienteRSList));
    }

    @GetMapping("/clientes/{cpf}")
    public ResponseEntity<ClienteRS> findByCpf(@PathVariable final String cpf) {
        var cliente = buscarClienteUseCase.findByCpf(cpf);

        return ResponseEntity.ok(clienteWebMapper.toClienteRS(cliente));
    }
}
