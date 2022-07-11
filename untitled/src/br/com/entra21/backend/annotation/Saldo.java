package br.com.entra21.backend.annotation;

/*
*Precisa adicionar saldo em cliente, para fazer a vereificação de saldo nas operacões bancárias
*/

public @interface Saldo {

    public enum OrdemDePrioridade {
        IMPORTATE, RELEVANTE, IMEDIATO, TARDA
    };

    OrdemDePrioridade ordemDePrioridade() default OrdemDePrioridade.RELEVANTE;

    String toDo();

    String autor();
}
