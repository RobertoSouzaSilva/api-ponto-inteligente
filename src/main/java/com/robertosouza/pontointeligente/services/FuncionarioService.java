package com.robertosouza.pontointeligente.services;

import java.util.Optional;

import com.robertosouza.pontointeligente.entities.Funcionario;

public interface FuncionarioService {

	Funcionario persistir(Funcionario funcionario);
	
	Optional<Funcionario> buscaPorCpf(String cpf);
		
	Optional<Funcionario> buscaPorEmail(String email);
	
	Optional<Funcionario> buscaPorId(Long id);

}
