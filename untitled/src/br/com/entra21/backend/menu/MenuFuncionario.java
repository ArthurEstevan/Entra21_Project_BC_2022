package br.com.entra21.backend.menu;

import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.crud.ICrud;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuFuncionario extends GeradorMenus implements ICrud<Cliente> {


    public MenuFuncionario(String titulo, ArrayList<String> opcoes) {
        super(titulo, opcoes);
    }

    @Override
    public void listar(HashMap<String, Cliente> lista) {

    }

    @Override
    public void adicionar() {

    }

    @Override
    public Cliente buscar(Cliente chave) {
        return null;
    }

    @Override
    public void editar(Cliente chave) {

    }

    @Override
    public void deletar(Cliente chave) {

    }

    @Override
    public Cliente capturarChave() {
        return null;
    }

    @Override
    public Cliente capturarValor() {
        return null;
    }

    @Override
    public void exibirDetalhes(Cliente completo) {

    }
}
