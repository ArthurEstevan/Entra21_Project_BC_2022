package br.com.entra21.backend.exceptions;

public class FuncionarioExistenteException extends Exception {

    public FuncionarioExistenteException() {
        super("Nao e possivel utilizar esse CPF, pois ja esta em uso.");
    }
}
