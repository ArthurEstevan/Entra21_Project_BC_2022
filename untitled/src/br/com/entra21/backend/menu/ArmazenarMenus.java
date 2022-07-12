package br.com.entra21.backend.menu;

import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.confirmar.Confirmar;

import java.util.ArrayList;
import java.util.Arrays;

public class ArmazenarMenus {

    public static void entrar() {
        new MenuEntrar("Login", new ArrayList<String>(Arrays.asList("Conta Cliente", "Conta Funcionario"))).executarMenu();
    }

    public static void cliente() {
        new MenuCliente("Cliente", new ArrayList<String>(Arrays.asList("Dados Bancarios", "Deposito", "Sacar", "Transferencia", "Investimento", "Saldo")), new Cliente()).executarMenu();
    }

    public static void funcionario() {



        new MenuFuncionario("Funcionario",new ArrayList<String>(Arrays.asList("Meus Dados", "Listar", "Adicionar", "Editar", "Detalhe de Cliente", "Deletar")), Confirmar.confirmarFuncionario()).executarMenu();
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
