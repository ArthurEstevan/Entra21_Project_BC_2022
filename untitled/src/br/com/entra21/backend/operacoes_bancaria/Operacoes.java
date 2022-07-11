package br.com.entra21.backend.operacoes_bancaria;

public interface Operacoes {

    public void dadosBancarios();

    public void deposito(double deposito);

    public void sacar(double sacar);

    public void transferencia(double transferencia);

    public void investimento();

    public void saldo();

    public double capturarValor();
}
