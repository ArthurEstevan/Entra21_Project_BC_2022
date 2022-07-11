package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa{

    private String contaCorrente;
    private String agencia;
    private String senha;
    private ArrayList<String> reclamacoes;
    private LocalDate dataCadastro;
    private String email;

    public Cliente () {

    }

    public Cliente(String nome, String cpf, String rg, String dataNascimento, String sexo, String mae, String pai, String cep, String endereco, String numero, String bairro, String cidade, String estado, String celular, byte idade, String contaCorrente, String agencia, String senha, ArrayList<String> reclamacoes, LocalDate dataCadastro, String email) {
        super(nome, cpf, rg, dataNascimento, sexo, mae, pai, cep, endereco, numero, bairro, cidade, estado, celular, idade);
        this.contaCorrente = contaCorrente;
        this.agencia = agencia;
        this.senha = senha;
        this.reclamacoes = reclamacoes;
        this.dataCadastro = dataCadastro;
        this.email = email;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<String> getReclamacoes() {
        return reclamacoes;
    }

    public void setReclamacoes(ArrayList<String> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
