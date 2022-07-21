package br.com.entra21.backend.crud;

import br.com.entra21.backend.annotation.HelpRemeber;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.menu.GeradorMenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionarioCRUD extends GeradorMenus implements ICrud<Funcionario> {


    public FuncionarioCRUD() {
        super("Funcionario", opcoes);
    }

    @Override
    public byte capturar() {
        return super.capturar();
    }

    @Override
    public void listar(HashMap<String, Funcionario> lista) {

    }

    @Override
    public void adicionar() {

    }

    @Override
    public Funcionario buscar(Funcionario chave) {
        return null;
    }

    @Override
    public void editar(Funcionario chave) {

    }

    @Override
    public void deletar(Funcionario chave) {

    }

    @Override
    public Funcionario capturarChave() {
        return null;
    }

    @HelpRemeber(value = "Crud capturar valor adicionei um captção de exception onde corrigo idades erradas;")
    @Override
    public Funcionario capturarValor() {

        Funcionario formulario = new Funcionario();

        byte opcao = 120;
        String funcoes[] = {"DevJunior", "DevPleno", "DevSenior"};

        System.out.println("========================================");
        System.out.println("Cargos Disponivel");
        System.out.println("========================================");

        for (int contador = 0; contador < funcoes.length; contador++) {
            System.out.println((contador + 1) + " - " + funcoes[contador]);
        }
        System.out.println("========================================");

        System.out.print("Informe o cargo: ");
        formulario.setNome(getInput().nextLine());

        do {
            try {
                System.out.print("Informe a idade: ");
                opcao = getInput().nextByte();

            } catch (InputMismatchException e) {
                setInput(new Scanner(System.in));
            }
        } while (opcao >= 118 || opcao <= 0);

        formulario.setIdade(opcao);
        return formulario;
    }

    @Override
    public void exibirDetalhes(Funcionario completo) {

    }
}
