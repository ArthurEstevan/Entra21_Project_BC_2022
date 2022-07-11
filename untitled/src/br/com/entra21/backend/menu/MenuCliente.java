package br.com.entra21.backend.menu;

import br.com.entra21.backend.menu.GeradorMenus;

import java.util.ArrayList;


public class MenuCliente extends GeradorMenus {

    public MenuCliente(String titulo, ArrayList<String> opcoes) {
        super(titulo, opcoes);
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {
            case 2 -> System.out.println("oi");
            case 3 -> System.out.println("oi");
            case 4 -> System.out.println("oi");
            case 5 -> System.out.println("oi");
            case 6 -> System.out.println("oi");
        }
        return opcao;
    }
}
