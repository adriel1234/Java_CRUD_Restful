package com.adriel.projeto04.adriel_projeto04.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriel.projeto04.adriel_projeto04.model.Produto;
import com.adriel.projeto04.adriel_projeto04.repository.ProdutoRepository;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos;
     */
    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.findById(id);
    }

    /**
     * Metodo para adicioanr produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        
        // Poderia ter alguma regra de negocio para validar o produto.
        return produtoRepository.save(produto);
    }

    /**
     * metodo para deletar o produto por id.
     * @param id do produto para ser deletado.
     */
    public void deletar(Integer id){

        produtoRepository.deleteById(id);
    }


     /**
     * metodo para deletar o produto por id.
     * @param id do produto para ser atualizado.
     * @param produto atualizado.
    * @return Retorna o produto atualizado.
     */
    public Produto atualizar(Integer id,Produto produto){
        produto.setId(id);

        return produtoRepository.save(produto);
    }
    
}
