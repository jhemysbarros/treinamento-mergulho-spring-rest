package me.jhemysbarros.algalogapi.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Destinatarioinput {

    @NotBlank
    private String nome;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String bairro;
}