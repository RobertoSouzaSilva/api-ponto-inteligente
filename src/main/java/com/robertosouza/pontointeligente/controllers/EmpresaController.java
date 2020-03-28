package com.robertosouza.pontointeligente.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertosouza.pontointeligente.dtos.EmpresaDto;
import com.robertosouza.pontointeligente.entities.Empresa;
import com.robertosouza.pontointeligente.response.Response;
import com.robertosouza.pontointeligente.services.EmpresaService;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;

	public EmpresaController() {
	}
		
	@GetMapping(value = "/cnpj/{cnpj}")
	public ResponseEntity<Response<EmpresaDto>> buscaPorCnpj(@PathVariable("cnpj") String cnpj){
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		Optional<Empresa> empresa = empresaService.buscarPorCnpj(cnpj);
		
		if(!empresa.isPresent()) {
			response.getErrors().add("Empresa nao encontrada para o cnpj" + cnpj);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converteEmpresaDto(empresa.get()));
		return ResponseEntity.ok(response);
	}
	
	private EmpresaDto converteEmpresaDto(Empresa empresa) {
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setId(empresa.getId());
		empresaDto.setCnpj(empresa.getCnpj());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());
		return empresaDto;
	}
	

}
