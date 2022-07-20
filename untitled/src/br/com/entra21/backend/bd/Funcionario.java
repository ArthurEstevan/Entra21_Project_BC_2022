package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private ArrayList<String> feedback;
    private String senha;

    // ======================================== CONSTRUCTOR ======================================== //

    public Funcionario() {
        super();
        this.dataAdmissao = LocalDate.now();
    }

    public Funcionario(String nome) {
        super(nome);
        this.dataAdmissao = LocalDate.now();
    }

    public Funcionario(String nome, byte idade) {
        super(nome, idade);
        this.dataAdmissao = LocalDate.now();
    }

    public Funcionario(String nome, byte idade, String cpf) {
        super(nome, idade, cpf);
        this.senha = cpf;
        this.dataAdmissao = LocalDate.now();
    }

    public Funcionario(String nome, byte idade, String cpf, LocalDate dataAdmissao, LocalDate dataDemissao, ArrayList<String> feedback) {
        super(nome, idade, cpf);
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.feedback = feedback;
        this.senha = cpf;
        this.dataAdmissao = LocalDate.now();
    }

    // ======================================== CONSTRUCTOR ======================================== //

    // ======================================== SETTER ======================================== //

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // ======================================== SETTER ======================================== //

    // ======================================== GETTER ======================================== //

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public String getSenha() {
        return senha;
    }

    // ======================================== GETTER ======================================== //
}

