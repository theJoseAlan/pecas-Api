package br.com.mildevs.pecas.api.SistemadePecas.controller;

import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import br.com.mildevs.pecas.api.SistemadePecas.exceptions.ErroDeNegocioException;
import br.com.mildevs.pecas.api.SistemadePecas.service.PecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    PecaService pecaService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public boolean inserePeca(@RequestBody @Valid Peca peca) throws ErroDeNegocioException {
        return pecaService.inserePeca(peca);
    }

    //Buscando por codBarras
    @GetMapping(path = "/{codBarras}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Peca buscaPeca(@PathVariable long codBarras){
        return pecaService.consultaPeca(codBarras);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Peca> buscaPeca(){
        return pecaService.listaPecas();
    }

    @DeleteMapping(path = "/{codBarras}")
    public boolean removePeca(@PathVariable Long codBarras){
        return pecaService.removePeca(codBarras);
    }

}
