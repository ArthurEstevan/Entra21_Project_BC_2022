package br.com.entra21.backend.crud;

import br.com.entra21.backend.annotation.HelpRemeber;
import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.menu.GeradorMenus;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionarioCRUD extends GeradorMenus implements ICrud<Funcionario> {

    private final HashMap<String, Funcionario> lista = Armazenar.funcionarios;

    public FuncionarioCRUD() {
        super("Funcionario", opcoes);
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {
            case 2 -> listar(lista);
            case 3 -> adicionar();
            case 4 -> exibirDetalhes(buscar(capturarChave()));
            case 5 -> editar(capturarChave());
            case 6 -> deletar(capturarChave());
        }
        return opcao;
    }

    @Override
    public void listar(HashMap<String, Funcionario> lista) {

        System.out.println("========================================");
        System.out.println("Listando Funcionarios");
        System.out.println("========================================");

        for (Funcionario funcionario : lista.values()) {
            System.out.println("Chave: " + funcionario.getCpf() + "\n" + "Nome: " + funcionario.getNome() + "\n" + "Idade: " + funcionario.getIdade() + "\n" + "Admisissao: " + funcionario.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("========================================");
        }
    }

    @Override
    public void adicionar() {

        Funcionario novo = capturarValor();

        if (buscar(novo) == null) {
            lista.put(novo.getCpf(), novo);
            System.out.println("-funcionario adicionado-");
        } else {
            System.out.println("-registro já existente na chave: " + novo.getCpf() + "-");
        }
    }

    @Override
    public Funcionario buscar(Funcionario chave) {
        return lista.get(chave.getCpf());
    }

    @Override
    public void editar(Funcionario chave) {

        Funcionario funcionario = buscar(chave);

        if (funcionario == null) {
            System.out.println("-funcionario no cpf " + chave.getCpf() + " não encontrado-");
        } else {
            lista.put(chave.getCpf(), atualizar());
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public void deletar(Funcionario chave) {

        Funcionario funcionario = buscar(chave);

        // Mantedo posição das chaves no banco de dado consigo ter um controlo de exclusão, como se fosse num sistema de bd, a chave sempre aumenta nunca fica no mesmo lugar de outra chave;
        Funcionario bancoDados = new Funcionario();
        // Aqui apenas faço algo mais visual atribuindo ao bancoDados uma visualização da sua chave;
        bancoDados.setCpf(chave.getCpf());

        if (funcionario == null) {
            System.out.println("-funcionario no cpf " + chave.getCpf() + " nao encontrado-");
        } else {
            lista.remove(chave.getCpf());
            lista.put(chave.getCpf(), bancoDados);
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public Funcionario capturarChave() {

        listar(lista);

        Funcionario formulario = new Funcionario();

        System.out.print("Informe a chave: ");
        formulario.setCpf(super.getInput().next());

        return formulario;
    }

    @HelpRemeber(value = "Crud capturar valor adicionei um captção de exception onde corrigo idades erradas;")
    @Override
    public Funcionario capturarValor() {

        Funcionario formulario = new Funcionario();

        byte opcao = 120;
        String numero;
        String[] funcoes = {"DevJunior", "DevPleno", "DevSenior"};

        System.out.println("========================================");
        System.out.println("Cargos Disponivel");
        System.out.println("========================================");

        for (int contador = 0; contador < funcoes.length; contador++) {
            System.out.println((contador + 1) + " - " + funcoes[contador]);
        }
        System.out.println("========================================");

        System.out.print("Informe o cargo: ");
        formulario.setNome(super.getInput().next());

        do {
            try {
                System.out.print("Informe a idade: ");
                opcao = super.getInput().nextByte();

            } catch (InputMismatchException e) {
                super.setInput(new Scanner(System.in));
            }
        } while (opcao >= 118 || opcao <= 0);
        formulario.setIdade(opcao);

        // Gerador de cpf para não dar conflito com o cadastro do início do (ementa) que também usa essa função
        // cpf mantém um padrão porque é uma chave codificada passada pelo front-end
        if (formulario.getCpf() == null) {
            for (int count = 1; count < 2; count++) {
                numero = "00" + (count + lista.size());
                formulario.setCpf(numero);
            }
        }
        return formulario;
    }

    @Override
    public void exibirDetalhes(Funcionario completo) {

        if (completo == null) {
            System.out.println("-registro não existente-");
        } else System.out.println(completo.toString());

    }

    @Override
    public Funcionario atualizar() {

        Funcionario formulario = new Funcionario();

        byte opcao = 120;
        String numero;
        String[] funcoes = {"DevJunior", "DevPleno", "DevSenior"};

        System.out.println("========================================");
        System.out.println("Cargos Disponivel");
        System.out.println("========================================");

        for (int contador = 0; contador < funcoes.length; contador++) {
            System.out.println((contador + 1) + " - " + funcoes[contador]);
        }
        System.out.println("========================================");

        System.out.print("Informe o cargo: ");
        formulario.setNome(getInput().next());

        do {
            try {
                System.out.print("Informe a idade: ");
                opcao = getInput().nextByte();

            } catch (InputMismatchException e) {
                setInput(new Scanner(System.in));
            }
        } while (opcao >= 118 || opcao <= 0);
        formulario.setIdade(opcao);

        // Aqui apenas inverto o for para que o cpf da pessoa atualizada não fica null
        if (formulario.getCpf() == null) {
            for (int count = 1; count < 2; count++) {
                numero = "00" + (count + (lista.size() - 1));
                formulario.setCpf(numero);
            }
        }
        return formulario;
    }
}
