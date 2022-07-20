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
            System.out.println("\n============== Menu Entrada ==============\n");
            System.out.println(tentativa < 3 ? tentativa + "/3 " + "-senha ou usuario incorreto tente novamente-\n": tentativa + "/3 " +"-confirme os dados abaixo-\n");
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

        String cpf;

        if (tentativa == 0) {
            System.out.println("-Desculpa Ocorreu um Erro-");
            return;
        } else {
            System.out.println("\n============== Menu de Cadastro ==============\n");
            System.out.println(tentativa < 3 ? tentativa + "/3 " + "-cpf informado incorreto tente novamente-\n": tentativa + "/3 " +"-confirme os dados abaixo-\n");
        }
        try {
            System.out.print("Informe CPF do novo funcionario: ");
            cpf = input.next().trim();
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
                return;
            }
        } catch (FuncionarioExistenteException e) {
            System.out.println(e.getMessage());
            cadastrar(--tentativa);
            return;
        }
    }

    private static void verificarSenha(Funcionario funcionario) {

        if (funcionario.getSenha().equals(funcionario.getCpf()) || funcionario.getSenha().equals(funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")))) {
            atualizarSenha(funcionario);
            Armazenar.funcionarios.size();
        } else {
            definirFuncionarioLogado(funcionario);

            new MenuFuncionario("Funcionario", new ArrayList<String>(Arrays.asList("Cadastro", "Relatorio"))).executarMenu();
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

}
