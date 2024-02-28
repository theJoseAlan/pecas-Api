package br.com.mildevs.pecas.api.SistemadePecas.service;

import br.com.mildevs.pecas.api.SistemadePecas.dto.CriaPecaDTo;
import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import br.com.mildevs.pecas.api.SistemadePecas.exceptions.ErroDeNegocioException;
import br.com.mildevs.pecas.api.SistemadePecas.repository.PecaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//O nome já é sugestivo, mas ficam os "serviços" que irão fazer as alterações
//A relação com o repository é importante porque o cod. de barras é o nosso parametro de verificação

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    //Create
    public Object inserePeca(CriaPecaDTo pecaDTo) throws ErroDeNegocioException {

        Peca peca = new Peca();
        BeanUtils.copyProperties(pecaDTo, peca);

       return pecaRepository.save(peca);

    }

    //Read
    public Peca consultaPeca(Long codBarras){
        Optional<Peca> pecaDb = pecaRepository.findByCodBarras(codBarras);

        if(pecaDb.isEmpty()){
            return null;
        }

        return pecaDb.get();
    }

    public Peca consultaPecaPorModelo(String modelo){
        return pecaRepository.findByModelo(modelo).get();
    }

    public List<Peca> listaPecas(){
        return pecaRepository.findAll();
    }

    //Update
    public boolean alteraPeca(Peca peca){

        if(!pecaRepository.existsByCodBarras(peca.getCodBarras())){
            return false;
        }

        pecaRepository.save(peca);
        return true;
    }

    //Delete
    public boolean removePeca(Long codBarras){

        if(!pecaRepository.existsByCodBarras(codBarras)){
            return false;
        }

        pecaRepository.deleteByCodBarras(codBarras);
        return true;
    }

}
