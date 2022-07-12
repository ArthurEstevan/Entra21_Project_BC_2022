package br.com.entra21.backend.menu;

import br.com.entra21.backend.annotation.Lembrete;
import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.icrud.ICrud;

import java.util.ArrayList;
import java.util.HashMap;

@Lembrete(ordemDePrioridade = Lembrete.OrdemDePrioridade.TARDA, toDo = "Adicionar função para cada funcionario", autor = "Arthur Estevan Vargas")
public class MenuFuncionario extends GeradorMenus implements ICrud<Cliente> {

    private Funcionario funcionario;

    public MenuFuncionario(String titulo, ArrayList<String> opcoes, Funcionario funcionario) {
        super(titulo, opcoes);
        this.funcionario = funcionario;
    }

    @Override
    public byte capturar() {

        byte opcao = super.capturar();

        switch (opcao) {

            case 2 -> meusDados(funcionario);
            case 3 -> listar(Armazenar.cliente);
            case 4 -> adicionar();
            case 5 -> editar(capturarChave());
            case 6 -> exibirDetalhes(buscar(capturarChave()));
            case 7 -> deletar(capturarChave());

        }

        return opcao;
    }

    public void meusDados(Funcionario funcionario) {
        System.out.println("========================================");
        System.out.println("Meus Dados");
        System.out.println(funcionario.toString());
    }

    @Override
    public void listar(HashMap<String, Cliente> lista) {
        System.out.println("========================================");
        System.out.println("Lista de Clientes");
        System.out.println("========================================");

        for (Cliente clientes : lista.values()) {

            System.out.println("Nome: " + clientes.getNome());
            System.out.println("CPF: " + clientes.getCpf());
            System.out.println("Data de Nascimento: " + clientes.getDataNascimento());
            System.out.println("Estado: " + clientes.getEstado());
            System.out.println("Cidade: " + clientes.getCidade());
            System.out.println("Endereco: " + clientes.getEndereco());
            System.out.println("========================================");
        }
        System.out.println("Cadastros no DataBase: " + lista.size());
        System.out.println("========================================");
    }

    @Override
    public void adicionar() {

        Cliente novo = capturarValor();

        if (buscar(novo)==null) {
            System.out.println("========================================");
            Armazenar.cliente.put(novo.getCpf(), novo);
            System.out.println("-Cliente Adicionado-");
            System.out.println("========================================");
        } else {
            System.out.println("========================================");
            System.out.println("-Cliente Existente-");
            System.out.println("========================================");
        }
    }

    @Override
    public Cliente buscar(Cliente chave) {
        return Armazenar.cliente.get(chave.getCpf());
    }

    @Lembrete(ordemDePrioridade = Lembrete.OrdemDePrioridade.TARDA, toDo = "Implementa um método para perguntar qual dado o funcionario quer atualizar", autor = "Arthur Estevan Vargas")
    @Override
    public void editar(Cliente chave) {

        Cliente informacoes = buscar(chave);

        if (informacoes == null) {
            System.out.println("========================================");
            System.out.println("-Cliente Inexistente-");
            System.out.println("========================================");
        } else {
            Armazenar.cliente.put(chave.getCpf(), capturarValor());
            System.out.println("========================================");
            System.out.println("-Cliente Atualizado-");
            System.out.println("========================================");
        }
    }

    @Override
    public void deletar(Cliente chave) {
    }

    @Override
    public Cliente capturarChave() {

        listar(Armazenar.cliente);

        Cliente informacoes = new Cliente();
        System.out.print("Informe CPF do cliente: ");
        informacoes.setCpf(super.getInput().nextLine());
        informacoes.setCpf(super.getInput().nextLine());

        return informacoes;
    }

    @Override
    public Cliente capturarValor() {

        Cliente cliente = new Cliente();

        System.out.println("========================================");
        System.out.println("Adicioando ou Atualizando Cliente");
        System.out.println("========================================");

        System.out.print("Informe o nome completo: ");
        cliente.setNome(super.getInput().nextLine());

        System.out.print("Informe sua idade: ");
        cliente.setIdade(super.getInput().nextByte());

        if (cliente.getIdade() < 18) {
            System.out.println("-Cadastro Apenas para Maiores de Idade-");
            return null;
        } else {

            System.out.print("Informe CPF: ");
            cliente.setCpf(super.getInput().nextLine());

            System.out.print("Informe RG: ");
            cliente.setRg(super.getInput().nextLine());

            System.out.print("Informe data de nascimento: ");
            cliente.setDataNascimento(super.getInput().nextLine());

            System.out.print("Informe sexo: ");
            cliente.setSexo(super.getInput().nextLine());

            System.out.print("Informe nome da mae: ");
            cliente.setMae(super.getInput().nextLine());

            System.out.print("Informe nome do pai: ");
            cliente.setPai(super.getInput().nextLine());

            System.out.print("Informe seu CEP: ");
            cliente.setCep(super.getInput().nextLine());

            System.out.print("Informe seu endereco: ");
            cliente.setEndereco(super.getInput().nextLine());

            System.out.print("Informe seu numero de residencia: ");
            cliente.setNumero(super.getInput().nextInt());

            System.out.print("Informe seu bairro: ");
            cliente.setBairro(super.getInput().nextLine());
            cliente.setBairro(super.getInput().nextLine());

            System.out.print("Informe sua cidade: ");
            cliente.setCidade(super.getInput().nextLine());

            System.out.print("Informe seu numero de celular: ");
            cliente.setCelular(super.getInput().nextLine());

            return cliente;
        }

    }

    @Override
    public void exibirDetalhes(Cliente completo) {

        if (completo==null) {
            System.out.println("-Cliente Inexistente-");
        } else {
            System.out.println("========================================");
            System.out.println("Listando Dados");
            System.out.println(completo.toString());
        }

    }

}
