package br.com.entra21.backend.icrud;

import java.util.HashMap;

public interface ICrud<T> {

    public void listar(HashMap<String, T> lista);

    public void adicionar();

    public void buscar(T chave);

    public void editar(T chave);

    public void deletar(T chave);

    public T capturarChave();

    public T capturarValor();

    public void exibirDetalhes(T completo);

}
