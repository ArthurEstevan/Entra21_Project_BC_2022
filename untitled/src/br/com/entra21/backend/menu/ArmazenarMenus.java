package br.com.entra21.backend.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class ArmazenarMenus {

    public static void entrar() {
        new MenuEntrar("Login", new ArrayList<String>(Arrays.asList("Conta Cliente", "Conta Funcionario"))).executarMenu();
    }

    public static void cliente() {
        new MenuCliente("Cliente", new ArrayList<String>(Arrays.asList("Dados Bancarios", "Deposito", "Sacar", "Transferencia", "Investimento", "Saldo"))).executarMenu();
    }

    public static void funcionario() {
        new MenuCliente("Funcionario",new ArrayList<String>(Arrays.asList("Meus Dados", "CRUD Clientes"))).executarMenu();
    }

    public static void cadastrar() {
        new MenuCadastrarCliente("Cadastrar", new ArrayList<String>(Arrays.asList("Cadastrar Cliente", "Enviar Curriculo"))).executarMenu();
    }
}
