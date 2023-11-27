package com.example.paola.PrjEmpresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paola.PrjEmpresa.entities.Departamento;
import com.example.paola.PrjEmpresa.services.DepartametoService;


import jakarta.validation.Valid;

@Tag(name = "Departamentos", description = "API REST DE GERECIAMENTO DE DEPARTAMENTOS")
@RestController
@RequestMapping("/departamento")
public class DepartamenroController {
	

	private final DepartametoService departametoService;

	@Autowired
	public DepartamenroController(DepartametoService departametoService) {
		this.departametoService = departametoService;
	}

	@GetMapping("/{id}")
	@Operation(summary= "Localiza departamento por ID")
	public ResponseEntity<Departamento> findDepartamentobyId(@PathVariable Long depcodigo) {
		Departamento Departamento = departametoService.findDepartamentoById(depcodigo);
		if (Departamento != null) {
			return ResponseEntity.ok(Departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary= "Apresenta todos os departamentos")
	public ResponseEntity<List<Departamento>> findAllUsuarioscontrol() {
		List<Departamento> usuarios = departametoService.findAllDepartamento();
		return ResponseEntity.ok(usuarios);
	}

	@PostMapping("/")
	@Operation(summary= "Cadastra um departamento")
	public ResponseEntity<Departamento> insertDepartamentoControl(@RequestBody @Valid Departamento departamento) {
		Departamento novoDepartamento= departametoService.insertDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}

	@PutMapping("/id")
	@Operation(summary= "Altera um departamento")
	public ResponseEntity<Departamento> updateDepartamentoControl(@PathVariable Long depcodigo, @RequestBody @Valid Departamento departamento) {
		Departamento mudausuario = departametoService.updateDepartamento(depcodigo, departamento);
		if (mudausuario != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/id")
	@Operation(summary= "Exclui um departamento")
	public ResponseEntity<String> deleteDepartamentoControl(@PathVariable Long depcodigo) {
		boolean remover = departametoService.deleteDepartamento(depcodigo);
		if (remover) {
			return ResponseEntity.ok().body("departamento Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
