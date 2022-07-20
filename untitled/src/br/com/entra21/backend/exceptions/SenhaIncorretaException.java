package br.com.entra21.backend.exceptions;

public class SenhaIncorretaException extends Exception {

    public SenhaIncorretaException() {

        super("A senha informada esta incorreta, tente novamente.");

    }
}
