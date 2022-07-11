package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Funcionario extends Pessoa {

    private ArrayList<String> feedback;
    private LocalDateTime baterPonto;
    private String senha;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;

    public Funcionario () {

    }

    public Funcionario(String nome, String cpf, String rg, String dataNascimento, String sexo, String mae, String pai, String cep, String endereco, int numero, String bairro, String cidade, String estado, String celular, byte idade, ArrayList<String> feedback, LocalDateTime baterPonto, String senha, LocalDate dataAdmissao, LocalDate dataDemissao) {
        super(nome, cpf, rg, dataNascimento, sexo, mae, pai, cep, endereco, numero, bairro, cidade, estado, celular, idade);
        this.feedback = feedback;
        this.baterPonto = baterPonto;
        this.senha = senha;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getBaterPonto() {
        return baterPonto;
    }

    public void setBaterPonto(LocalDateTime baterPonto) {
        this.baterPonto = baterPonto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
}
