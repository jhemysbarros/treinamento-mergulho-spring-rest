package me.jhemysbarros.algalogapi.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClienteIdinput {

    @NotNull
    private Long id;

}