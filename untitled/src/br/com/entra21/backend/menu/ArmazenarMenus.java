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

    public static void sobre(){

        System.out.println("\n========================================");
        System.out.println("Projeto Conta Bancaria v2.0");
        System.out.println("========================================");
        System.out.println("Autor - Arthur Estevan Vargas;");
        System.out.println("Ideia - Update Conta Bancaria v1.0;");
        System.out.println("Referencias - Oliota e Time Verde;");
        System.out.println("========================================");

    }
}
