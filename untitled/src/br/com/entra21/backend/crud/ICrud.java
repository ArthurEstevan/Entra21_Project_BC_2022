package br.com.entra21.backend.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public interface ICrud<T> {

    ArrayList<String> opcoes = new ArrayList<String>(Arrays.asList("Listar", "Buscar", "Editar", "Deletar"));

    public void listar(HashMap<String, T> lista);

    public void adicionar();

    public T buscar(T chave);

    public void editar(T chave);

    public void deletar(T chave);

    public T capturarChave();

    public T capturarValor();

    public void exibirDetalhes(T completo);

}
