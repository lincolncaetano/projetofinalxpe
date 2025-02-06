package br.com.lincolncaetano.projetofinal.service;

import br.com.lincolncaetano.projetofinal.model.Produto;
import br.com.lincolncaetano.projetofinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Long id, Produto produtoAtualizado) {

        Optional<Produto> produtoExistenteOpt = produtoRepository.findById(id);

        if (produtoExistenteOpt.isPresent()) {
            Produto produtoExistente = produtoExistenteOpt.get();

            if (produtoAtualizado.getNome() != null) {
                produtoExistente.setNome(produtoAtualizado.getNome());
            }
            if (produtoAtualizado.getDescricao() != null) {
                produtoExistente.setDescricao(produtoAtualizado.getDescricao());
            }
            if (produtoAtualizado.getPreco() != null) {
                produtoExistente.setPreco(produtoAtualizado.getPreco());
            }

            return produtoRepository.save(produtoExistente);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarPorNome(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public long contagem(){
        return produtoRepository.count();
    }

}
