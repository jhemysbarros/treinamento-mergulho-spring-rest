package me.jhemysbarros.algalogapi.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.jhemysbarros.algalogapi.domain.model.Cliente;
import me.jhemysbarros.algalogapi.domain.model.Entrega;
import me.jhemysbarros.algalogapi.domain.model.StatusEntrega;
import me.jhemysbarros.algalogapi.domain.repository.EntregaRepository;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}