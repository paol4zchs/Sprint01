package com.example.paola.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paola.PrjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
