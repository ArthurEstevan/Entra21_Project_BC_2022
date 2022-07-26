package br.com.entra21.backend.bd;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa {

    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private ArrayList<String> reclamacoes;

    public Cliente() {
        super();
    }

    // ======================================== CONSTRUCTOR ======================================== //

    public Cliente(String nome) {
        super(nome);
    }

    public Cliente(String nome, byte idade) {
        super(nome, idade);
    }

    public Cliente(String nome, byte idade, String cpf) {
        super(nome, idade, cpf);
    }

    public Cliente(String nome, byte idade, String cpf, ArrayList<String> reclamacoes) {
        super(nome, idade, cpf);
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = this.dataCadastro;
        this.reclamacoes = reclamacoes;
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

    // ======================================== GETTER ======================================== //


}
