package com.adriel.projeto04.adriel_projeto04.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriel.projeto04.adriel_projeto04.model.Produto;
import com.adriel.projeto04.adriel_projeto04.model.exception.ResourceNotFoundException;
import com.adriel.projeto04.adriel_projeto04.repository.ProdutoRepository;
import com.adriel.projeto04.adriel_projeto04.shared.ProdutoDTO;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos;
     */
    public List<ProdutoDTO> obterTodos(){

        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso tenha encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        // Obtendo optional de produto pelo id
        Optional<Produto> produto = produtoRepository.findById(id);

        // se não encontar, lança um exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id: "+ id + " não existe");
        }
        // Convertendo o optonal de produto em um produtoDto
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);

        //Criando e retornando um optional de prodtuoDto
        return Optional.of(dto);
    }

    /**
     * Metodo para adicioanr produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        //remover o id para conseguir fazer o cadastro.
        produtoDto.setId(null);

        // Criar um objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        //converter produtoDTO em um produto
        Produto produto = mapper.map(produtoDto, Produto.class);

        // salvar o produto do banco
        produto = produtoRepository.save(produto);

        produtoDto.setId(produto.getId());

        // retornar o produtoDTO atualizado.
        return produtoDto;
    }

    /**
     * metodo para deletar o produto por id.
     * @param id do produto para ser deletado.
     */
    public void deletar(Integer id){

        //verifica se o produto existe
        Optional<Produto> produto = produtoRepository.findById(id);

        // se não existir lança uma exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi Possível deletar o produto com o id: "+id+" - produto não existe");
        }
        // deletar o produto pelo id
        produtoRepository.deleteById(id);
    }


     /**
     * metodo para deletar o produto por id.
     * @param id do produto para ser atualizado.
     * @param produto atualizado.
    * @return Retorna o produto atualizado.
     */
    public ProdutoDTO atualizar(Integer id,ProdutoDTO produtoDto){
        
        // Verificar se o produto existe no banco de dados
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        // se não encontar, lança um exception
        if(produtoOptional.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel atualizar o produto com id: "+id+" - produto não existe");
        }
        // passar o id para o prdutoDto
        produtoDto.setId(id);

        //criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        //converter  o prodtuoDTO em um produto
        Produto produto = mapper.map(produtoDto, Produto.class);

        //atualizar o produto no banco de dados
        produtoRepository.save(produto);

        //retroanr o produtoDto atualizado

        return produtoDto;
    }
    
}
