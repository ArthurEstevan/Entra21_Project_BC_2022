package br.com.entra21.backend.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class ArmazenarMenus {

    public static void entrar() {
        new MenuCliente("Login", new ArrayList<String>(Arrays.asList("Login Cliente", "Login Funcionario"))).executarMenu();
    }

    public static void cadastrar() {
        new MenuCadastrar("Cadastrar", new ArrayList<String>(Arrays.asList("Cadastrar Cliente", "Cadastrar Empresa"))).executarMenu();
    }


}
