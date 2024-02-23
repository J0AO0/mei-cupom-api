package com.mei.vendasapi.repository;

import com.mei.vendasapi.domain.Estoque;
import com.mei.vendasapi.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    @Query(value = "SELECT * FROM estoque", nativeQuery = true)
    List<Estoque> findAll();

    @Query(value = "SELECT * FROM estoque where id = ?", nativeQuery = true)
    Estoque findPorId(Integer id);

    Estoque findByNome(String nome);
}

