package br.com.mildevs.pecas.api.SistemadePecas.exceptions;

//Aqui fica um metodo que seta uma mensagem para uma tratativa de erro

public class ErroDeNegocioException extends Exception{

    private static final long serialVersionUID =  118470146055125885L;

    public ErroDeNegocioException(String message){
        super(message);
    }

}
