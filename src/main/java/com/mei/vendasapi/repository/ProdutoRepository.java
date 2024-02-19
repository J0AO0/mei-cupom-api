package com.mei.vendasapi.repository;

import com.mei.vendasapi.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query(value = "SELECT * FROM produto", nativeQuery = true)
    List<Produto> findAllCat();

    @Query(value = "SELECT * FROM produto where id = ?", nativeQuery = true)
    Produto findPorId(Integer id);

}
