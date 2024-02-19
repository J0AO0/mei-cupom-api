package com.mei.vendasapi.repository;

import com.mei.vendasapi.domain.Cliente;
import com.mei.vendasapi.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query(value = "SELECT * FROM empresa", nativeQuery = true)
    List<Empresa> findAllCat();

    @Query(value = "SELECT * FROM empresa where id = ?", nativeQuery = true)
    Empresa findPorId(Integer id);

}
