package br.com.mildevs.pecas.api.SistemadePecas.service;

import br.com.mildevs.pecas.api.SistemadePecas.entity.Peca;
import br.com.mildevs.pecas.api.SistemadePecas.exceptions.ErroDeNegocioException;
import br.com.mildevs.pecas.api.SistemadePecas.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//O nome já é sugestivo, mas ficam os "serviços" que irão fazer as alterações
//A relação com o repository é importante porque o cod. de barras é o nosso parametro de verificação

@Service
public class PecaService {

    @Autowired
    PecaRepository pecaRepository;

    //Create
    public boolean inserePeca(Peca peca) throws ErroDeNegocioException {
        if(pecaRepository.existsById(peca.getCodBarras())){
            throw new ErroDeNegocioException("Já existe uma peça com esse códido de barras");
        }

        pecaRepository.save(peca);

        return true;
    }

    //Read
    public Peca consultaPeca(Long codBarras){
        Optional<Peca> pecaDb = pecaRepository.findById(codBarras);

        if(pecaDb.isEmpty()){
            return null;
        }

        return pecaDb.get();
    }

    public List<Peca> listaPecas(){
        return pecaRepository.findAll();
    }
    //Update
    public boolean alteraPeca(Peca peca){
        if(!pecaRepository.existsById(peca.getCodBarras())){
            return false;
        }

        pecaRepository.save(peca);
        return true;
    }

    //Delete
    public boolean removePeca(Long codBarras){
        if(!pecaRepository.existsById(codBarras)){
            return false;
        }

        pecaRepository.deleteById(codBarras);
        return true;
    }


}
