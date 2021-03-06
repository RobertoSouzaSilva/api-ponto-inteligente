package com.robertosouza.pontointeligente.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.robertosouza.pontointeligente.entities.Lancamento;
import com.robertosouza.pontointeligente.repositories.LancamentoRepository;
import com.robertosouza.pontointeligente.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	//private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Page<Lancamento> buscaPorFuncionarioId(Long funcionarioId, PageRequest pageRequest){
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	public Optional<Lancamento> buscaPorId(Long id){
		return this.lancamentoRepository.findById(id);
	}
	
	public Lancamento persistir(Lancamento lancamento) {
		return this.lancamentoRepository.save(lancamento);
	}
	
	public void remover(Long id) {
		this.lancamentoRepository.deleteById(id);
	}

}
