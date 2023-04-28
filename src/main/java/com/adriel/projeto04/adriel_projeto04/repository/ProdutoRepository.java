package com.adriel.projeto04.adriel_projeto04.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.adriel.projeto04.adriel_projeto04.model.Produto;

@Repository
public class ProdutoRepository {
        
    private List<Produto> produtos= new ArrayList<Produto>();
    private Integer ultimoId=0;
    

    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos;
     */
    public List<Produto> obterTodos(){

        return produtos;
    }
    
    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso tenha encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){

        return produtos
                    .stream()
                    .filter(produto -> produto.getId() == id)
                    .findFirst();
    }


    /**
     * Metodo para adicioanr produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * metodo para deletar o produto por id.
     * @param id do produto para ser deletado.
    * @return Retorna o produto atualizado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId()==id);


    }

    /**
     * metodo para Atualizar.
     * @param id para atualizar produto re.
     */
    public Produto atualizar(Produto produto){

        Optional<Produto>  produtoEncontrado=obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }
}
