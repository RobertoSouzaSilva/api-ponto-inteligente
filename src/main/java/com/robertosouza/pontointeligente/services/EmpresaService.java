package com.robertosouza.pontointeligente.services;

import java.util.Optional;

import com.robertosouza.pontointeligente.entities.Empresa;

public interface EmpresaService {
	
	Optional<Empresa> buscarPorCnpj(String cpnj);
	
	Empresa persistir(Empresa empresa);

}
