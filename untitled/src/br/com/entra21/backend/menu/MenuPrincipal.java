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

            case 2 -> new MenuCadastro("Cadastros", new ArrayList<String>(Arrays.asList("Funcionarios", "Clientes","Empresas"))).executarMenu();
            case 3 -> new MenuRelatorio("Relatorios", new ArrayList<String>(Arrays.asList(""))).executarMenu();
        }

        return opcao;
    }
}
