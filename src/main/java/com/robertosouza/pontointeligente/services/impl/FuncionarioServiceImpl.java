package com.robertosouza.pontointeligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertosouza.pontointeligente.entities.Funcionario;
import com.robertosouza.pontointeligente.repositories.FuncionarioRepository;
import com.robertosouza.pontointeligente.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistindo Funcionario", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}
	
	public Optional<Funcionario> buscaPorCpf(String cpf){
		log.info("Buscando funcionario pelo cpf: ", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}
	
	public Optional<Funcionario> buscaPorEmail(String email){
		log.info("Buscando funcionario pelo cpf: ", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}
	
	public Optional<Funcionario> buscaPorId(Long id){
		log.info("Buscando funcionario pelo cpf: ", id);
		return this.funcionarioRepository.findById(id);
	}

}
