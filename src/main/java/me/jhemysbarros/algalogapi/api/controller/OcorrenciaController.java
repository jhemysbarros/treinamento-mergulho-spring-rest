package me.jhemysbarros.algalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import me.jhemysbarros.algalogapi.api.assembler.OcorrenciaAssembler;
import me.jhemysbarros.algalogapi.api.model.OcorrenciaModel;
import me.jhemysbarros.algalogapi.api.model.input.OcorrenciaInput;
import me.jhemysbarros.algalogapi.domain.model.Entrega;
import me.jhemysbarros.algalogapi.domain.model.Ocorrencia;
import me.jhemysbarros.algalogapi.domain.service.BuscaEntregaService;
import me.jhemysbarros.algalogapi.domain.service.RegistroOcorrenciaService;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private OcorrenciaModel registrar(@PathVariable Long entregaId,
            @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,
                ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollecModel(entrega.getOcorrencias());
    }
}