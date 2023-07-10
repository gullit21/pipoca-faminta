package com.br.pipocafaminta.application.services.produto;

import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.produto.Produto;
import com.br.pipocafaminta.application.port.incoming.produto.BuscarProdutoUseCase;
import com.br.pipocafaminta.application.port.incoming.produto.EditarProdutoUseCase;
import com.br.pipocafaminta.application.port.incoming.produto.RemoverProdutoUseCase;
import com.br.pipocafaminta.application.port.incoming.produto.SalvarProdutoUseCase;
import com.br.pipocafaminta.application.port.outgoing.produto.BuscarProdutoPort;
import com.br.pipocafaminta.application.port.outgoing.produto.EditarProdutoPort;
import com.br.pipocafaminta.application.port.outgoing.produto.RemoverProdutoPort;
import com.br.pipocafaminta.application.port.outgoing.produto.SalvarProdutoPort;

import java.util.List;

public class ProdutoService implements SalvarProdutoUseCase, BuscarProdutoUseCase, EditarProdutoUseCase, RemoverProdutoUseCase {

    private final SalvarProdutoPort salvarProdutoPort;
    private final BuscarProdutoPort buscarProdutoPort;
    private final EditarProdutoPort editarProdutoPort;
    private final RemoverProdutoPort removerProdutoPort;

    public ProdutoService(SalvarProdutoPort salvarProdutoPort,
                          BuscarProdutoPort buscarProdutoPort,
                          EditarProdutoPort editarProdutoPort,
                          RemoverProdutoPort removerProdutoPort) {
        this.salvarProdutoPort = salvarProdutoPort;
        this.buscarProdutoPort = buscarProdutoPort;
        this.editarProdutoPort = editarProdutoPort;
        this.removerProdutoPort = removerProdutoPort;
    }

    @Override
    public Produto save(Produto produto) {
        return salvarProdutoPort.save(produto);
    }

    @Override
    public Produto findById(Long id) {
        return buscarProdutoPort.findById(id);
    }

    @Override
    public List<Produto> findByCategoria(CategoriaEnum categoriaEnum) {
        return buscarProdutoPort.findByCategoria(categoriaEnum);
    }

    @Override
    public List<Produto> findAll() {
        return buscarProdutoPort.findAll();
    }

    @Override
    public List<Produto> findAllById(List<Long> produtos) {
        return buscarProdutoPort.findAllById(produtos);
    }

    @Override
    public Produto update(Long id, Produto produto) {
        return editarProdutoPort.update(id, produto);
    }

    @Override
    public void deleteById(Long id) {
        removerProdutoPort.deleteById(id);
    }
}
