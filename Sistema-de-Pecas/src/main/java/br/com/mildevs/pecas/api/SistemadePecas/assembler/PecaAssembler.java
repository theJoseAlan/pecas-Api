package br.com.mildevs.pecas.api.SistemadePecas.assembler;

import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PecaAssembler {

    private ModelMapper modelMapper;

    public PecaAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


}
