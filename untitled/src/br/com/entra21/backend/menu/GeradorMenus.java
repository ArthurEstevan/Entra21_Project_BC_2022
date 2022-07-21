package br.com.entra21.backend.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class GeradorMenus {

    private Scanner input;
    private String titulo;
    private ArrayList<String> opcoes;

    public GeradorMenus(String titulo, ArrayList<String> opcoes) {
        super();
        this.input = new Scanner(System.in);
        this.titulo = titulo;
        this.opcoes = opcoes;
    }

    public void executarMenu() {

        if (opcoes != null && !opcoes.isEmpty()) {

            do {
                System.out.println("\n============== Menu " + getTitulo() + " ==============");
                System.out.println("0) Sair");
                System.out.println("1) Voltar");

                for (int contador = 0; contador < opcoes.size(); contador++) {
                    System.out.println((contador + 2) + ") " + opcoes.get(contador));
                }
                System.out.println("=============================================");
                System.out.print("Escolha uma opcao: ");
            } while (capturar() != 1);

        } else {
            System.out.println("Informações invalidas");
        }
    }

    public byte capturar() {

        byte opcao;

        opcao = input.nextByte();

        switch (opcao) {

            case 0:
                System.exit(0);
                break;

            case 1:
                break;
        }
        return opcao;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getTitulo() {
        return titulo;
    }
}