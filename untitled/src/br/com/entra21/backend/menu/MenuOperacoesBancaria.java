package br.com.entra21.backend.menu;

import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.crud.ClienteCRUD;
import br.com.entra21.backend.operacoes_bancaria.Investimentos;
import br.com.entra21.backend.operacoes_bancaria.Operacoes;

import java.time.LocalDate;
import java.util.ArrayList;

public class MenuOperacoesBancaria extends GeradorMenus implements Operacoes {

    public static Cliente clientelogado = null;
    private static final LocalDate entrada = LocalDate.now();

    public MenuOperacoesBancaria(String titulo, ArrayList<String> opcoes, Cliente cliente) {
        super(titulo, opcoes);
        clientelogado = cliente;
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

        System.out.printf(clientelogado.toString());
    }

    @Override
    public void deposito(double deposito) {

        System.out.println("========================================");
        System.out.println("Realizar Deposito ");
        System.out.println("========================================");
        System.out.printf("Saldo anterior: " + clientelogado.getSaldo() + "\n");

        clientelogado.setSaldo((clientelogado.getSaldo() + deposito));

        System.out.println("Salado posterior: " + clientelogado.getSaldo());
        System.out.println("========================================");
        System.out.println("-operacao realizada com sucesso-");

    }

    @Override
    public void sacar(double sacar) {

        System.out.println("========================================");
        System.out.println("Realizar Saque");
        System.out.println("========================================");
        System.out.printf("Saldo anterior: " + clientelogado.getSaldo() + "\n");
        if (clientelogado.getSaldo() > sacar) {
            clientelogado.setSaldo(sacar);
            System.out.print("-operacao realizada com sucesso-");
        } else {
            System.out.print("-saldo insuficiente-\n");
        }
    }

    @Override
    public void transferencia(double transferencia) {

        System.out.println("========================================");
        System.out.println("Realizar Transferencia");

        Cliente informacoes = new ClienteCRUD().capturarChave();

        if (transferencia <= clientelogado.getSaldo()) {

            if (informacoes.getCpf() != null) {
                clientelogado.setSaldo((clientelogado.getSaldo() - transferencia));
                Armazenar.clientes.get(informacoes.getCpf()).setSaldo(Armazenar.clientes.get(informacoes.getCpf()).getSaldo() + transferencia);
                System.out.printf("-transferencia realizada com sucesso-\n");
            } else {
                System.out.printf("-cliente informado não encontrado-");
            }
        } else {
            System.out.printf("-saldo insuficiente-");
        }
    }

    @Override
    public void investimento() {

        System.out.println("========================================");
        System.out.println("Realizar Investimento ");
        System.out.println("========================================");

        for (int contador = 0; contador < Investimentos.values().length; contador++) {
            System.out.println("Investimento = " + Investimentos.values()[contador].name());
            System.out.println("Preco Unitario = " + Investimentos.values()[contador].getPrecoUnitario());
            System.out.println("Rentabilidade = " + Investimentos.values()[contador].getRentabilidade());
            System.out.println("Data do Vencimento = " + Investimentos.values()[contador].getDataDeVencimento() + "\n");
        }

        String opcao;
        Double pValorMs, amount;

        System.out.print("Informe o ivestimento: ");
        opcao = super.getInput().next();

        System.out.print("Informe o aporte mensal: ");
        pValorMs = super.getInput().nextDouble();

        switch (opcao) {

            case "TESOURO_IPCA":
                for (int year = 1; year <= 4; ++year) {
                    amount = pValorMs * Math.pow(1.0 + 0.1703, year);
                    System.out.printf("\n\t%4d%,20.2f%n", year, amount);
                }
                clientelogado.setSaldo((clientelogado.getSaldo() - pValorMs));
                break;

            case "TESOURO_SELIC":
                for (int year = 1; year <= 3; ++year) {
                    amount = pValorMs * Math.pow(1.0 + 0.2445, year);
                    System.out.printf("\n\t%4d%,20.2f%n", year, amount);
                }
                clientelogado.setSaldo((clientelogado.getSaldo() - pValorMs));
                break;

            case "TESOURO_PREFIXADO":
                for (int year = 1; year <= 3; ++year) {
                    amount = pValorMs * Math.pow(1.0 + 0.1264, year);
                    System.out.printf("\n\t%4d%,20.2f%n", year, amount);
                }
                clientelogado.setSaldo((clientelogado.getSaldo() - pValorMs));
                break;
        }
    }

    @Override
    public void saldo() {

        System.out.println("========================================");
        System.out.println("Saldo do Cliente");
        System.out.println("========================================");
        System.out.printf("Saldo: " + clientelogado.getSaldo());

    }

    @Override
    public double capturarValor() {

        System.out.print("\nInforme o valor: ");
        double valor = super.getInput().nextDouble();

        return valor;
    }
}
