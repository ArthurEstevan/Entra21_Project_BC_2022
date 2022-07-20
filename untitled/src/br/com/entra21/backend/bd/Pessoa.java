package br.com.entra21.backend.bd;

public class Pessoa {
    private String nome;
    private byte idade;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String sexo;
    private String mae;
    private String pai;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String celular;

    // ======================================== CONSTRUCTOR ======================================== //

    public Pessoa() {
        super();
    }

    public Pessoa(String nome) {
        super();
        this.nome = nome;
    }

    public Pessoa(String nome, byte idade) {
        this.idade = idade;
    }

    public Pessoa(String nome, byte idade, String cpf) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    // ======================================== CONSTRUCTOR ======================================== //

    // ======================================== SETTER ======================================== //

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // ======================================== SETTER ======================================== //

    // ======================================== GETTER ======================================== //

    public String getNome() {
        return nome;
    }

    public byte getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getMae() {
        return mae;
    }

    public String getPai() {
        return pai;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCelular() {
        return celular;
    }

    // ======================================== GETTER ======================================== //

}