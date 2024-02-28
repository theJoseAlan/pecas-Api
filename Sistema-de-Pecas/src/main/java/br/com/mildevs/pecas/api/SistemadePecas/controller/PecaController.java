package br.com.mildevs.pecas.api.SistemadePecas.controller;

import br.com.mildevs.pecas.api.SistemadePecas.dto.CriaPecaDTo;
import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import br.com.mildevs.pecas.api.SistemadePecas.exceptions.ErroDeNegocioException;
import br.com.mildevs.pecas.api.SistemadePecas.service.PecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    PecaService pecaService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Object inserePeca(@RequestBody @Valid CriaPecaDTo peca) throws ErroDeNegocioException {
        return pecaService.inserePeca(peca);
    }

    //Buscando por codBarras
    @GetMapping(path = "/{codBarras}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Peca buscaPeca(@PathVariable Long codBarras){
        return pecaService.consultaPeca(codBarras);
    }

    //Buscando por modelo de carro
    @GetMapping(path = "modelo/{modelo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Peca buscaPecaPorModelo(@PathVariable String modelo){
        return pecaService.consultaPecaPorModelo(modelo);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Peca> listaPeca(){
        return pecaService.listaPecas();
    }

    @DeleteMapping(path = "/{codBarras}")
    public String removePeca(@PathVariable Long codBarras){

        if(pecaService.removePeca(codBarras)){
            return "Peça deletada";
        }

        return "Peça não encontrada";
    }

}
