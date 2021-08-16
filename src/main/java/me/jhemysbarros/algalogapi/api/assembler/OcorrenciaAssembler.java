package me.jhemysbarros.algalogapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import me.jhemysbarros.algalogapi.api.model.OcorrenciaModel;
import me.jhemysbarros.algalogapi.domain.model.Ocorrencia;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }

    public List<OcorrenciaModel> toCollecModel(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream().map(ocorrencia -> toModel(ocorrencia)).collect(Collectors.toList());
    }
}