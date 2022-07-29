package br.com.entra21.backend.menu;

import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.operacoes_bancaria.Operacoes;

import java.util.ArrayList;

public class MenuOperacoesBancaria extends GeradorMenus implements Operacoes {

    public static Cliente clientelogado = null;

    public MenuOperacoesBancaria(String titulo, ArrayList<String> opcoes, Cliente cliente) {
        super(titulo, opcoes);
        this.clientelogado = cliente;
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {

            case 2 -> dadosBancarios();
            case 3 -> deposito(capturarValor());
            case 4 -> sacar(capturarValor());
            case 5 -> transferencia(capturarValor());
            case 6 -> investimento();
            case 7 -> saldo();
        }


        return opcao;
    }

    @Override
    public void dadosBancarios() {

    }

    @Override
    public void deposito(double deposito) {

    }

    @Override
    public void sacar(double sacar) {

    }

    @Override
    public void transferencia(double transferencia) {

    }

    @Override
    public void investimento() {

    }

    @Override
    public void saldo() {

    }

    @Override
    public double capturarValor() {
        return 0;
    }
}
