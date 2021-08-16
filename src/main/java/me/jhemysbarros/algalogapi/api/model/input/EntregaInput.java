package me.jhemysbarros.algalogapi.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EntregaInput {

    @Valid
    @NotNull
    private ClienteIdinput cliente;

    @Valid
    @NotNull
    private Destinatarioinput destinatario;

    @NotNull
    private BigDecimal taxa;
}