package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;

    public class Cliente extends Pessoa {

        private LocalDate dataCadastro;
        private LocalDate dataAtualizacao;
        private ArrayList<String> reclamacoes;
        private String senha;

        private Double saldo;

        public Cliente() {
            super();
        }

    // ======================================== CONSTRUCTOR ======================================== //

    public Cliente(String nome) {
        super(nome);
        this.dataCadastro = LocalDate.now();
    }

    public Cliente(String nome, byte idade) {
        super(nome, idade);
        this.dataCadastro = LocalDate.now();
    }

    public Cliente(String nome, byte idade, String cpf, Double saldo) {
        super(nome, idade, cpf);
        this.saldo = saldo;
        this.senha = cpf;
        this.dataCadastro = LocalDate.now();
    }

    public Cliente(String nome, byte idade, String cpf, LocalDate dataCadastro, LocalDate dataAtualizacao, ArrayList<String> reclamacoes) {
        super(nome, idade, cpf);
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.reclamacoes = reclamacoes;
        this.senha = cpf;
        this.dataCadastro = LocalDate.now();
    }

    // ======================================== CONSTRUCTOR ======================================== //

    // ======================================== SETTER ======================================== //

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setReclamacoes(ArrayList<String> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSaldo(Double saldo) {
            this.saldo = saldo;
        }

    // ======================================== SETTER ======================================== //

    // ======================================== GETTER ======================================== //

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public ArrayList<String> getReclamacoes() {
        return reclamacoes;
    }

    public String getSenha() {
        return senha;
    }

    public Double getSaldo() {
            return saldo;
        }

    // ======================================== GETTER ======================================== //
    public String toString() {

        return "========================================\n" + "Dados do Funcionario\n" + "========================================\n" +

                "Nome: " + getNome() + "\n" + "Idade: " + getIdade() + "\n" + "Cpf: " + getCpf() + "\n" + "Data de Adimissao: " + getDataCadastro() + "\n" +

                "========================================";
    }

}
