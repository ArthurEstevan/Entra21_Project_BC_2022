package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;


public class Empresa extends Pessoa {

    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private String cnpj;
    private ArrayList<String> reclamacoes;

    // ======================================== CONSTRUCTOR ======================================== //

    public Empresa() {
        super();
        this.dataCadastro = LocalDate.now();
    }

    public Empresa(String nome, String cnpj) {
        super(nome);
        this.dataCadastro = LocalDate.now();
        this.cnpj = cnpj;
    }

    public Empresa(String nome, String cnpj, LocalDate dataCadastro, LocalDate dataAtualizacao, ArrayList<String> reclamacoes) {
        super(nome);
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.reclamacoes = reclamacoes;
        this.cnpj = cnpj;
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

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setReclamacoes(ArrayList<String> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    // ======================================== SETTER ======================================== //

    // ======================================== GETTER ======================================== //

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<String> getReclamacoes() {
        return reclamacoes;
    }

    // ======================================== GETTER ======================================== //

    // ======================================== TO STRING ======================================== //

    @Override
    public String toString() {

        return "========================================\n" + "Dados do Funcionario\n" + "========================================\n" +

                "Nome: " + getNome() + "\n" + "Cnpj: " + getCnpj() + "\n" + "Data de Cadastro: " + getDataCadastro() + "\n" +

                "========================================";
    }
}
