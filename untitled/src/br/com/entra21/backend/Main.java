package br.com.entra21.backend;

import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.menu.ArmazenarMenus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // os meus chamados
    private static final LocalDate entrada = LocalDate.now();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Armazenar.massaDeDados();

        final byte ZERO = 0;
        byte opcao;

        do {
            menu();

            // tratamento de erros para não quebrar a entrada.‘byte’
            try {
                opcao = input.nextByte();
            } catch (InputMismatchException e) {
                opcao = -2;
                input = new Scanner(System.in);
            }

            byte LIMITE_TENTATIVAS = 3;
            switch (opcao) {
                case ZERO -> System.out.println("Volte sempre!");
                case 1 -> ArmazenarMenus.entrarFuncionario(LIMITE_TENTATIVAS);
                case 2 -> ArmazenarMenus.entrarCliente(LIMITE_TENTATIVAS);
                case 3 -> ArmazenarMenus.cadastrar(LIMITE_TENTATIVAS);
                case 4 -> ArmazenarMenus.recuperarSenhaFuncionario(LIMITE_TENTATIVAS);
                case 5 -> ArmazenarMenus.recuperarSenhaCliente(LIMITE_TENTATIVAS);
                case 6 -> ArmazenarMenus.sobre();
            }

        } while (opcao != 0);
    }

    public static void menu() {

        System.out.println("\n" + entrada);

        System.out.println("========================================");
        System.out.println("Bem vindo ao Green Banck");
        System.out.println("========================================");

        ArrayList<String> opcoes = new ArrayList<>(Arrays.asList("0) Sair", "1) Conta Funcionario", "2) Conta Cliente", "3) Cadastrar", "4) Recuperar Senha Funcionario", "5) Recuperar Senha Cliente", "6) Sobre"));

        for (String menus : opcoes) {
            System.out.println(menus);
        }
        System.out.println("========================================");
        System.out.print("Escolha uma opcao: ");
    }
}
