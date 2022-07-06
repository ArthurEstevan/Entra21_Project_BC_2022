package br.com.entra21.backend.menu;

import br.com.entra21.backend.menu.ArmazenarMenus;
import br.com.entra21.backend.menu.GeradorMenus;

import java.util.ArrayList;

public class MenuEntrar extends GeradorMenus {

        public MenuEntrar(String titulo, ArrayList<String> opcoes) {
            super(titulo, opcoes);
        }

        @Override
        public byte capturar() {

            byte opcao = super.capturar();

            switch (opcao) {

                case 2:
                    ArmazenarMenus.cliente();
                    break;

                case 3:
                    ArmazenarMenus.funcionario();
                    break;
            }

            return opcao;

        }
}
