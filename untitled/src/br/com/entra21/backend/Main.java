package br.com.entra21.backend;

import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.menu.ArmazenarMenus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // meus chamados
    private static LocalDate entrada = LocalDate.now();
    private static ArrayList<String> opcoes;
    private static byte LIMITE_TENTATIVAS = 3;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Armazenar.massaDeDados();

        final byte ZERO = 0;
        byte opcao;

        do {
            menu();

            // tratamento de erros para não quebrar o input.byte
            try {
                opcao = input.nextByte();
            } catch (InputMismatchException e) {
                opcao = -2;
                input = new Scanner(System.in);
            }

            switch (opcao) {
                case ZERO -> System.out.println("Volte sempre!");
                case 1 -> ArmazenarMenus.entrar(LIMITE_TENTATIVAS);
                case 2 -> ArmazenarMenus.cadastrar(LIMITE_TENTATIVAS);
                case 3 -> ArmazenarMenus.recuperarSenha(LIMITE_TENTATIVAS);
                case 4 -> ArmazenarMenus.sobre();
            }

        } while (opcao != 0);
    }

    public static void menu() {

        System.out.println("\n" + entrada);

        System.out.println("========================================");
        System.out.println("Bem vindo ao Green Banck");
        System.out.println("========================================");

        opcoes = new ArrayList<>(Arrays.asList("0) Sair", "1) Entrar", "2) Cadastrar","3) Recuperar Senha", "4) Sobre"));

        for (String menus : opcoes) {
            System.out.println(menus);
        }
        System.out.println("========================================");
        System.out.print("Escolha uma opcao: ");
    }
}
