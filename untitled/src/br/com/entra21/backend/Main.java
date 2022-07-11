package br.com.entra21.backend;

import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.menu.ArmazenarMenus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Armazenar.massaDeDados();

        final byte ZERO = 0;
        byte opcao;

        do {
            menu();
            opcao = input.nextByte();

            switch (opcao) {
                case ZERO -> {
                    System.out.println("Volte sempre!");
                    System.exit(ZERO);
                }
                case 1 -> ArmazenarMenus.entrar();
                case 2 -> ArmazenarMenus.cadastrar();
                case 3 -> ArmazenarMenus.sobre();
            }
        } while (opcao != 0);
    }

    public static void menu() {

        LocalDate entrada = LocalDate.now();
        System.out.println("\n" + entrada);

        System.out.println("========================================");
        System.out.println("Bem vindo ao Green Banck");
        System.out.println("========================================");
        ArrayList<String> menu = new ArrayList<>(Arrays.asList("0) Sair", "1) Entrar", "2) Cadastrar", "3) Sobre"));
        for (String menus : menu) {
            System.out.println(menus);
        }
        System.out.println("========================================");
        System.out.print("Escolha uma opcao: ");
    }
}
