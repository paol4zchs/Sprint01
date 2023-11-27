package com.example.paola.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paola.PrjEmpresa.entities.Funcionario;
import com.example.paola.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public  FuncionarioService( FuncionarioRepository  funcionarioRepository) {
		this.funcionarioRepository =  funcionarioRepository;
	}

	
		public Funcionario findFuncionarioById(Long funcodigo) {
			Optional<Funcionario> Funcionario = funcionarioRepository.findById(funcodigo);
			return Funcionario.orElse(null);
		}

		
		public List<Funcionario> findAllFuncionario() {
			return funcionarioRepository.findAll();
		}

		
		public Funcionario insertFuncionario(Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}

	
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoUsuario) {
			Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);
			if (funcionarioOptional.isPresent()) {
				Funcionario funcionarioExistente = funcionarioOptional.get();
				funcionarioExistente.setFunnome(novoUsuario.getFunnome());
				funcionarioExistente.setFunnascimento(novoUsuario.getFunnascimento());
				funcionarioExistente.setFuncodigo(novoUsuario.getFuncodigo());
				funcionarioExistente.setFunsalario(novoUsuario.getFunsalario());
				return funcionarioRepository.save(funcionarioExistente);
			} else {
				return null;
			}
		}

		
		public boolean deleteFuncionario(Long funcodigo) {
			Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(funcodigo);
			if (funcionarioExistente.isPresent()) {
				funcionarioRepository.deleteById(funcodigo);
				return true;
			} else {
				return false;
			}
		}
	


}
