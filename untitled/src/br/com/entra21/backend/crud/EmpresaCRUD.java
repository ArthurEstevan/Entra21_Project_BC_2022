package br.com.entra21.backend.crud;

import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.bd.Empresa;
import br.com.entra21.backend.bd.Funcionario;
import br.com.entra21.backend.menu.GeradorMenus;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class EmpresaCRUD extends GeradorMenus implements ICrud<Empresa> {

    private HashMap<String, Empresa> lista = Armazenar.empresas;

    public EmpresaCRUD() {
        super("Empresa", opcoes);
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
    public void listar(HashMap<String, Empresa> lista) {

        System.out.println("========================================");
        System.out.println("Listando Empresas");
        System.out.println("========================================");

        for (Empresa empresa : lista.values()) {
            System.out.println("Chave: " + empresa.getCnpj() + "\n" + "Nome: " + empresa.getNome() + "\n" + "Data de Cadastro: " + empresa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            System.out.println("========================================");
        }
    }

    @Override
    public void adicionar() {

        Empresa novo = capturarValor();

        if (buscar(novo) == null) {
            lista.put(novo.getCnpj(), novo);
            System.out.println("-empresa cadastrada-");
        } else {
            System.out.println("-registro já existente no cnpj: " + novo.getCnpj() + "-");
        }
    }

    @Override
    public Empresa buscar(Empresa chave) {
        return lista.get(chave.getCnpj());
    }

    @Override
    public void editar(Empresa chave) {

        Empresa empresa = buscar(chave);

        if (empresa == null) {
            System.out.println("-empresa no cnpj " + chave.getCnpj() + " não encontrado-");
        } else {
            lista.put(chave.getCnpj(), atualizar());
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public void deletar(Empresa chave) {

        Empresa empresa = buscar(chave);

        // Mantedo posição das chaves no banco de dado consigo ter um controlo de exclusão, como se fosse num sistema de bd, a chave sempre aumenta nunca fica no mesmo lugar de outra chave;
        Empresa bancoDados = new Empresa();
        // Aqui apenas faço algo mais visual atribuindo ao bancoDados uma visualização da sua chave;
        bancoDados.setCpf(chave.getCpf());

        if (empresa == null) {
            System.out.println("-empresa no cnpj " + chave.getCnpj() + " nao encontrado-");
        } else {
            lista.remove(chave.getCnpj());
            System.out.println("-dados atualizados-");
        }
    }

    @Override
    public Empresa capturarChave() {

        listar(lista);

        Empresa formulario = new Empresa();

        System.out.print("Informe a chave:");
        formulario.setCnpj(super.getInput().next());

        return formulario;
    }

    @Override
    public Empresa capturarValor() {

        Empresa formulario = new Empresa();
        String numero;

        System.out.println("========================================");
        System.out.println("Cadastrando Empresa");
        System.out.println("========================================");

        System.out.print("Informe razao social: ");
        super.getInput().nextLine();
        formulario.setNome(super.getInput().nextLine());


        // Gerador de cnpj para não dar conflito com futuros implementos
        // cnpj mantém um padrão porque é uma chave codificada passada pelo front-end
        if (formulario.getCnpj() == null) {
            for (int count = 1; count < 2; count++) {
                numero = "00" + (count + lista.size());
                formulario.setCnpj(numero);
            }
        }
        return formulario;
    }

    @Override
    public void exibirDetalhes(Empresa completo) {

        if (completo == null) {
            System.out.println("Registro não existente na chave: " + completo.getCnpj());
        } else {
            System.out.println(completo.toString());
        }

    }

    @Override
    public Empresa atualizar() {

        Empresa formulario = new Empresa();
        String numero;

        System.out.println("========================================");
        System.out.println("Cadastrando Empresa");
        System.out.println("========================================");

        System.out.print("Informe razao social: ");
        getInput().nextLine();
        formulario.setNome(getInput().next());

        // Gerador de cnpj para não dar conflito com futuros implementos
        // cnpj mantém um padrão porque é uma chave codificada passada pelo front-end
        if (formulario.getCnpj() == null) {
            for (int count = 1; count < 2; count++) {
                numero = "00" + (count + (lista.size() + 1));
                formulario.setCnpj(numero);
            }
        }
        return formulario;
    }

}
