package me.jhemysbarros.algalogapi.domain.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.jhemysbarros.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import me.jhemysbarros.algalogapi.domain.model.Entrega;
import me.jhemysbarros.algalogapi.domain.repository.EntregaRepository;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
        .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }    
}