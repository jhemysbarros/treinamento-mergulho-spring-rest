package me.jhemysbarros.algalogapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;
import me.jhemysbarros.algalogapi.domain.model.StatusEntrega;

@Data
public class EntregaModel {

    private Long id;
    private ClienteResumoModel cliente;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
