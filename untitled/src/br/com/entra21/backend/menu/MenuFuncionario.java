package br.com.entra21.backend.menu;

import java.util.ArrayList;

public class MenuFuncionario extends GeradorMenus {

    public MenuFuncionario(String titulo, ArrayList<String> opcoes) {
        super(titulo, opcoes);
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;
        }

        return opcao;
    }
}
