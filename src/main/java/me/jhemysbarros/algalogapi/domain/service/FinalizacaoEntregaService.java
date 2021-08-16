package me.jhemysbarros.algalogapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import me.jhemysbarros.algalogapi.domain.model.Entrega;
import me.jhemysbarros.algalogapi.domain.repository.EntregaRepository;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}