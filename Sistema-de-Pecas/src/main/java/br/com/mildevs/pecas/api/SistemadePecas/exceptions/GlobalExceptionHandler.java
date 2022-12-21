package br.com.mildevs.pecas.api.SistemadePecas.exceptions;

import br.com.mildevs.pecas.api.SistemadePecas.dto.ErroValidacaoResponseDTO;
import br.com.mildevs.pecas.api.SistemadePecas.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

//Aqui ficam as tratativas das excessões que podem ser disparadas

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final int POSICAO_ERRO = 0;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ErroDeNegocioException.class)
    public @ResponseBody ResponseDTO handleBusinessErrors(Exception e){
        return new ResponseDTO(e.getMessage());
    }

    //Agora os erros são listados, não aprecem mais mensagem tão grandes de erro, apenas os erros
    //Relacionados aquele atributo específico
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public @ResponseBody List<ErroValidacaoResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        List<ErroValidacaoResponseDTO> resposta = new ArrayList<ErroValidacaoResponseDTO>();

        for(ObjectError erro: e.getBindingResult().getAllErrors()){
            String erroInteiro = erro.getCodes()[POSICAO_ERRO];
            String nomeCampo = erroInteiro.substring(erroInteiro.lastIndexOf(".")+1, erroInteiro.length());

            resposta.add(new ErroValidacaoResponseDTO(nomeCampo,erro.getDefaultMessage()));

        }
        //Aqui irá retornar o erro de uma forma mais específica e organizada
        //O JSON no postman vai mostrar o o campo (atributo) e o erro relacionado a ele
        //Falicita muito a vida de quem vai sonsumir a API
        return resposta;
    }

}
