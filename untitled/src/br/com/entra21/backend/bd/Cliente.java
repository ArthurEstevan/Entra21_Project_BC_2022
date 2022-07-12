package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa {

    private String contaCorrente;
    private String agencia;
    private String senha;
    private ArrayList<String> reclamacoes;
    private LocalDate dataCadastro;
    private String email;

    private Double saldo;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String rg, String dataNascimento, String sexo, String mae, String pai, String cep, String endereco, int numero, String bairro, String cidade, String estado, String celular, byte idade, String contaCorrente, String agencia, String senha, ArrayList<String> reclamacoes, LocalDate dataCadastro, String email, Double saldo) {
        super(nome, cpf, rg, dataNascimento, sexo, mae, pai, cep, endereco, numero, bairro, cidade, estado, celular, idade);
        this.contaCorrente = contaCorrente;
        this.agencia = agencia;
        this.senha = senha;
        this.reclamacoes = reclamacoes;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.saldo = saldo;
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {

        return "========================================\n" +
                "Nome: " + getNome() + "\n" +
                "Idade: " + getIdade() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "RG: " + getRg() + "\n" +
                "Data Nascimento: " + getDataNascimento() + "\n" +
                "Sexo: " + getSexo() + "\n" +
                "Mae: " + getMae() + "\n" +
                "Pai: " + getPai() + "\n" +
                "CEP: " + getCep() + "\n" +
                "Endereco: " + getEndereco() + "\n" +
                "Numero: " + getNumero() + "\n" +
                "Bairro: " + getBairro() + "\n" +
                "Cidade: " + getCidade() + "\n" +
                "Estado: " + getEstado() + "\n" +
                "Celular: " + getCelular() + "\n" +
                "Conta Corrente: " + getContaCorrente() + "\n" +
                "Agencia: " + getAgencia() + "\n" +
                "Data de Cadastro: " + getDataCadastro() + "\n" +
                "========================================";
    }
}
