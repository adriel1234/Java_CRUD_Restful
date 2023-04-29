package com.adriel.projeto04.adriel_projeto04.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriel.projeto04.adriel_projeto04.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
