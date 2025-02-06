package br.com.lincolncaetano.projetofinal.controller;

import br.com.lincolncaetano.projetofinal.model.Produto;
import br.com.lincolncaetano.projetofinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> produtos = service.listarTodos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaPorId(@PathVariable Long id) {
        Optional<Produto> produto = service.buscarPorId(id);
        return produto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = service.update(id, produtoAtualizado);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Produto>> buscaPorNome(@RequestParam String nome) {
        List<Produto> produtos = service.buscarPorNome(nome);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/contagem")
    public ResponseEntity<Long> contarProdutos() {
        long total = service.contagem();
        return ResponseEntity.ok(total);
    }
}
