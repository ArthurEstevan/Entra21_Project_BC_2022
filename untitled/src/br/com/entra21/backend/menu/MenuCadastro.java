package br.com.entra21.backend.menu;

import br.com.entra21.backend.crud.FuncionarioCRUD;

import java.util.ArrayList;

public class MenuCadastro extends GeradorMenus{

    public MenuCadastro(String titulo, ArrayList<String> opcoes) {
        super(titulo, opcoes);
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {

            case 2 ->new FuncionarioCRUD().executarMenu();
            //case 2 ->
            //case 3 ->
        }


        return opcao;
    }
}
