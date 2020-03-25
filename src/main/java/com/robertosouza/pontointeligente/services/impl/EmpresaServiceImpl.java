package com.robertosouza.pontointeligente.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertosouza.pontointeligente.entities.Empresa;
import com.robertosouza.pontointeligente.repositories.EmpresaRepository;
import com.robertosouza.pontointeligente.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj){
		log.info("Buscando empresa por cnpj", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}
	
	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa:", empresa);
		return this.empresaRepository.save(empresa);
	}

}
