package br.com.entra21.backend.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuPrincipal extends GeradorMenus {

    public MenuPrincipal(String titulo, ArrayList<String> opcoes) {
        super(titulo, opcoes);
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {

            case 2 -> new MenuCadastro("Cadastros", new ArrayList<String>(Arrays.asList("Clientes", "Funcionarios", "Empresas"))).executarMenu();
            case 3 -> new MenuRelatorio("Relatorios", new ArrayList<String>(Arrays.asList(""))).executarMenu();
            case 4 -> new MenuOperacoesBancaria("Operacoes Bancarias", new ArrayList<String>(Arrays.asList("Dados Bancarios", "Deposito", "Sacar", "Transferencia", "Investimento", "Saldo", "Capturar Valores"))).executarMenu();
        }

        return opcao;
    }
}
