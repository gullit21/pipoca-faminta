package com.br.pipocafaminta.adapters.persistence.produto;

import com.br.pipocafaminta.adapters.exceptions.notfound.ProdutoNotFoundException;
import com.br.pipocafaminta.adapters.persistence.mapper.produto.ProdutoPersistenceMapper;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.produto.Produto;
import com.br.pipocafaminta.application.port.outgoing.produto.BuscarProdutoPort;
import com.br.pipocafaminta.application.port.outgoing.produto.EditarProdutoPort;
import com.br.pipocafaminta.application.port.outgoing.produto.RemoverProdutoPort;
import com.br.pipocafaminta.application.port.outgoing.produto.SalvarProdutoPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoRepository implements SalvarProdutoPort, BuscarProdutoPort, EditarProdutoPort, RemoverProdutoPort {

    private final SpringDataProdutoRepository springDataProdutoRepository;
    private final ProdutoPersistenceMapper produtoPersistenceMapper;


    public ProdutoRepository(SpringDataProdutoRepository springDataProdutoRepository,
                             ProdutoPersistenceMapper produtoPersistenceMapper) {
        this.springDataProdutoRepository = springDataProdutoRepository;
        this.produtoPersistenceMapper = produtoPersistenceMapper;
    }

    @Override
    public Produto save(Produto produto) {
        var produtoEntity = produtoPersistenceMapper.toProdutoEntity(produto);
        var produtoEntitySaved = springDataProdutoRepository.save(produtoEntity);

        return produtoPersistenceMapper.toProduto(produtoEntitySaved);
    }

    @Override
    public Produto findById(Long id) {
        var produtoEntity = springDataProdutoRepository.findById(id)
                .orElseThrow(ProdutoNotFoundException::new);
        return produtoPersistenceMapper.toProduto(produtoEntity);
    }

    @Override
    public List<Produto> findByCategoria(CategoriaEnum categoria) {
        var produtoList = springDataProdutoRepository.findAllByCategoria(categoria);
        return produtoPersistenceMapper.toProdutoList(produtoList);
    }

    @Override
    public List<Produto> findAll() {
        var produtoList = springDataProdutoRepository.findAll();
        return produtoPersistenceMapper.toProdutoList(produtoList);
    }

    @Override
    public List<Produto> findAllById(List<Long> produtos) {
        var produtoList = springDataProdutoRepository.findAllById(produtos);
        return produtoPersistenceMapper.toProdutoList(produtoList);
    }

    @Override
    public Produto update(Long id, Produto produtoUpdate) {
        var produtoFound = findById(id);
        produtoPersistenceMapper.updateProduto(produtoFound, produtoUpdate);

        return save(produtoFound);
    }

    @Override
    public void deleteById(Long id) {
        springDataProdutoRepository.deleteById(id);
    }
}
