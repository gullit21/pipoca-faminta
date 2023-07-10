package com.br.pipocafaminta.adapters.web;

import com.br.pipocafaminta.adapters.web.annotations.PipocaFamintaController;
import com.br.pipocafaminta.adapters.web.mapper.produto.ProdutoWebMapper;
import com.br.pipocafaminta.application.domain.enums.CategoriaEnum;
import com.br.pipocafaminta.application.domain.produto.ProdutoRQ;
import com.br.pipocafaminta.application.domain.produto.ProdutoRS;
import com.br.pipocafaminta.application.port.incoming.produto.BuscarProdutoUseCase;
import com.br.pipocafaminta.application.port.incoming.produto.EditarProdutoUseCase;
import com.br.pipocafaminta.application.port.incoming.produto.RemoverProdutoUseCase;
import com.br.pipocafaminta.application.port.incoming.produto.SalvarProdutoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@PipocaFamintaController
public class ProdutosController {

    private final SalvarProdutoUseCase salvarProdutoUseCase;
    private final BuscarProdutoUseCase buscarProdutoUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final RemoverProdutoUseCase removerProdutoUseCase;
    private final ProdutoWebMapper produtoWebMapper;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoRS> create(@RequestBody ProdutoRQ produtoRQ) {
        var produto = produtoWebMapper.toProduto(produtoRQ);
        var produtoSaved = salvarProdutoUseCase.save(produto);

        return ResponseEntity.ok(produtoWebMapper.toProdutoRS(produtoSaved));
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoRS>> findAll() {
        var produtoList = buscarProdutoUseCase.findAll();
        return ResponseEntity.ok(produtoWebMapper.toProdutoRSList(produtoList));
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoRS> findById(@PathVariable final Long id) {
        var produto = buscarProdutoUseCase.findById(id);

        return ResponseEntity.ok(produtoWebMapper.toProdutoRS(produto));
    }

    @GetMapping("/produtos/categoria/{categoria}")
    public ResponseEntity<List<ProdutoRS>> findAllByCategoria(@PathVariable CategoriaEnum categoria) {
        var produtoList = buscarProdutoUseCase.findByCategoria(categoria);

        return ResponseEntity.ok(produtoWebMapper.toProdutoRSList(produtoList));
    }

    @PutMapping("/produtos/{id}")
    public  ResponseEntity<ProdutoRS> update(@PathVariable Long id,
                                             @RequestBody ProdutoRQ produtoRQ) {
        var produto = produtoWebMapper.toProduto(produtoRQ);
        var produtoUpdated = editarProdutoUseCase.update(id, produto);

        return ResponseEntity.ok(produtoWebMapper.toProdutoRS(produtoUpdated));
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        removerProdutoUseCase.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
