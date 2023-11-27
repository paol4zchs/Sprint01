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

import com.example.paola.PrjEmpresa.entities.Funcionario;
import com.example.paola.PrjEmpresa.services.FuncionarioService;

import jakarta.validation.Valid;

@Tag(name = "Funcionarios", description = "API REST DE GERECIAMENTO DE Funcionarios")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{id}")
	@Operation(summary= "Localiza funcionario por ID")
	public ResponseEntity<Funcionario> findFuncionariobyId(@PathVariable Long id) {
		Funcionario Funcionario = funcionarioService.findFuncionarioById(id);
		if (Funcionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	@Operation(summary= "Apresenta todos os funcionarios")
	public ResponseEntity<List<Funcionario>> findAllUsuarioscontrol() {
		List<Funcionario> usuarios = funcionarioService.findAllFuncionario();
		return ResponseEntity.ok(usuarios);
	}

	@PostMapping("/")
	@Operation(summary= "Cadastra um funcionario")
	public ResponseEntity<Funcionario> insertUsuariosControl(@RequestBody @Valid Funcionario funcionario) {
		Funcionario novoFuncionario= funcionarioService.insertFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
	}

	@PutMapping("/id")
	@Operation(summary= "Altera um funcionario")
	
	public ResponseEntity<Funcionario> updateUsuarioControl(@PathVariable Long funcodigo, @RequestBody @Valid Funcionario funcionario) {
		Funcionario mudausuario = funcionarioService.updateFuncionario(funcodigo, funcionario);
		if (mudausuario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/id")
	@Operation(summary= "Exclui um funcionario")
	public ResponseEntity<String> deleteFuncionarioControl(@PathVariable Long funcodigo) {
		boolean remover = funcionarioService.deleteFuncionario(funcodigo);
		if (remover) {
			return ResponseEntity.ok().body("funcionario Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
