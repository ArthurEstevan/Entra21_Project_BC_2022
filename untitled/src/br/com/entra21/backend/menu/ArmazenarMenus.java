package br.com.entra21.backend.menu;

import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.crud.FuncionarioCRUD;
import br.com.entra21.backend.exceptions.FuncionarioExistenteException;
import br.com.entra21.backend.exceptions.SenhaIncorretaException;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArmazenarMenus {

    static Scanner input = new Scanner(System.in);
    public static Funcionario funcionarioLogado = null;

    public static void entrar(byte tentativa) {

        if (tentativa == 0) {
            System.out.println("-Desculpa Ocorreu um Erro-");
            return;
        } else {
            System.out.println("\n============== Login ==============\n");
            System.out.println(tentativa < 3 ? tentativa + "/3 " + "-senha ou usuario incorreto tente novamente-\n" : tentativa + "/3 " + "-confirme os dados abaixo-\n");
        }
        try {
            System.out.print("Informe CPF do funcionario: ");
            Funcionario funcionario = Armazenar.funcionarios.get(input.next().trim());

            System.out.println("Funcionario encontrado: " + funcionario.getNome());
            System.out.print("Informe a senha para liberar o acesso: ");

            if (!funcionario.getSenha().equals(input.next())) {
                throw new SenhaIncorretaException();
            } else {
                verificarSenha(funcionario);
                return;
            }
        } catch (NullPointerException e) {
            System.out.println("Nenhum funcionario encontrado com esse CPF");
            entrar(--tentativa);
            return;
        } catch (SenhaIncorretaException e) {
            System.out.println(e.getMessage());
            entrar(--tentativa);
            return;
        }
    }

    public static void cadastrar(byte tentativa) {

        String cpf = null;

        if (tentativa == 0) {
            System.out.println("-Desculpa Ocorreu um Erro-");
            return;
        } else {
            System.out.println("\n============== Register ==============\n");
            System.out.println(tentativa < 3 ? tentativa + "/3 " + "-cpf informado incorreto tente novamente-\n" : tentativa + "/3 " + "-confirme os dados abaixo-\n");
        }
        try {
            System.out.print("Informe CPF do novo funcionario: ");
            for (int count = 1; count < 2; count++) {
                cpf = "00" + (count + Armazenar.funcionarios.size());
            }

            Funcionario funcionario = Armazenar.funcionarios.get(cpf);

            if (funcionario != null) {
                throw new FuncionarioExistenteException();
            } else {
                funcionario = new FuncionarioCRUD().capturarValor();
                funcionario.setCpf(cpf);
                funcionario.setSenha(cpf);
                Armazenar.funcionarios.put(cpf, funcionario);
                System.out.println();
                System.out.println("-funcionario cadastrado-");
                System.out.println("IMPORTANTE: No primeiro acesso a senha e igual ao CPF e sera solicitado a mudanca:");
                System.out.println("~~~~~~~~~~~~ Bem Vindo " + funcionario.getNome() + " ~~~~~~~~~~~~");
                return;
            }
        } catch (FuncionarioExistenteException e) {
            System.out.println(e.getMessage());
            cadastrar(--tentativa);
            return;
        }
    }

    public static void sobre() {

        System.out.println("\n============== Sobre o Projeto ==============\n");

        System.out.println("Desenvolver um sistema bancario contendendo uma interface,crud, regra e negocio.\n" +
                            "Deve ser publicado versao oficial do projeto no GitHub do time (Time Verde).\n");

        System.out.println("- Organization: TimeVerde");
        System.out.println("- Author: Arthur Estevan Vargas | Rafael Macedo");
        System.out.println("- Version: GreenBank v2.0");
        System.out.println("- Language: Portuguese / English");

        System.out.println("============================================");


    }

    private static void verificarSenha(Funcionario funcionario) {

        if (funcionario.getSenha().equals(funcionario.getCpf()) || funcionario.getSenha().equals(funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")))) {
            atualizarSenha(funcionario);
            Armazenar.funcionarios.size();
        } else {
            definirFuncionarioLogado(funcionario);

            new MenuPrincipal("do Funcionario", new ArrayList<String>(Arrays.asList("Cadastro", "Relatorio"))).executarMenu();
        }
    }

    private static void definirFuncionarioLogado(Funcionario funcionario) {

        if (funcionario != null) {
            System.out.println("~~~~~~~~~~~~ Bem Vindo " + funcionario.getNome() + " ~~~~~~~~~~~~");
        } else {
            System.out.println("Até a proxima " + funcionario.getNome() + ", volte sempre que precisar.");
        }
        funcionarioLogado = funcionario;
    }

    private static void atualizarSenha(Funcionario funcionario) {

        System.out.print("Atualize sua senha, pois nao e seguro manter a senha igual ao cpf ou com a data de admissao: ");
        funcionario.setSenha(input.next());
        verificarSenha(funcionario);
    }

    public static void recuperarSenha(byte tentativa) {

        if (tentativa == 0) {
            System.out.println("-Desculpa Ocorreu um Erro-");
            return;
        } else {
            System.out.println("\n============== Menu Recuperacao de Senha ==============\n");
            System.out.println(tentativa < 3 ? tentativa + "/3 " + "-senha ou usuario incorreto tente novamente-\n" : tentativa + "/3 " + "-confirme os dados abaixo-\n");
        }
        try {
            System.out.print("Informe o CPF do funcionario: ");
            Funcionario funcionario = Armazenar.funcionarios.get(input.next().trim());

            System.out.println("Funcionario encontrado: " + funcionario.getNome());
            funcionario.setSenha(funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            Armazenar.funcionarios.put(funcionario.getCpf(), funcionario);

            System.out.println("A senha foi atualizada com a data de admissao no formato dd/MM/YYYY:");
            System.out.println("Funcionario atualizado, por favor realize o login:");

            System.out.println("==============================================");

        } catch (NullPointerException e) {

            System.out.println("Nenhum funcionario encontrado com esse CPF.");
            recuperarSenha(--tentativa);
            return;
        }
    }

}
