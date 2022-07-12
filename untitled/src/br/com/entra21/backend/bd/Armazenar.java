package br.com.entra21.backend.bd;

import br.com.entra21.backend.annotation.Help;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Armazenar {

    public static HashMap<String, Cliente> cliente = new HashMap();
    public static HashMap<String, Funcionario> funcionario = new HashMap();

    public static void massaDeDados() {

        gerarCliente();
        gerarFuncionario();

    }

    public static void gerarCliente() {

        LocalDate dataCadastro = LocalDate.now();

        cliente.put("167.220.508-58", new Cliente("Carlos Cláudio Lima", "167.220.508-58", "26.841.725-8", "06/07/1962", "Feminino",
                "Josefa Sueli", "Enzo Cauã Farias", "64218-780", "Rua Oeiras", 748, "Nova Parnaíba", "Parnaíba",
                "PI", "(86) 98857-3837", (byte) 60, "1473786-3", "6345", "OYJEHqQuae", new ArrayList<>(Arrays.asList("")),
                dataCadastro, "mariah_sabrina_farias@tigra.com.br", (double) 0));

        cliente.put("878.371.923-70", new Cliente("Sérgio Yuri Lopes", "878.371.923-70", "34.360.005-5", "02/04/1970", "Masculino",
                "Priscila Clarice", "Pedro Cauê Lopes", "94480-687", "Travessa Sete de Setembro", 844, "Santa Isabel", "Viamão",
                "RS", "(51) 98206-8933", (byte) 52, "1234116-4", "6345", "S53p6Cer1x", new ArrayList<>(Arrays.asList("")),
                dataCadastro, "sergio_yuri_lopes@focustg.com.br", (double) 0));

    }
    @Help(value = "Tiando K do HashMap para facilitar teste no código enquanto escrevo, lembrar de recolocar depois")
    public static void gerarFuncionario() {

        LocalDateTime baterPonto = LocalDateTime.now();
        LocalDate dataAdimissao = LocalDate.now();


        funcionario.put("", new Funcionario("Vicente Hugo Oliveira", "933.158.537-38", "16.596.020-6", "24/01/1953", "Masculino",
                "Gabriela Luzia Marlene", "Oliver Carlos Eduardo Oliveira", "38410-478", "Rua Anistia", 370 , "Laranjeiras", "Uberlândia",
                "MG", "(34) 98818-8534", (byte) 39, new ArrayList<>(Arrays.asList("")), baterPonto, "gLmHMpGgAO", dataAdimissao, null));

        funcionario.put("580.319.807-21", new Funcionario("Andreia Larissa Eloá Assis", "580.319.807-21", "36.554.363-9", "18/04/1963", "Feminino",
                "Alícia Tereza", "Fernando Paulo Benício Assis", "53437-740", "Rua Frei Caneca", 506, "Janga", "Paulista",
                "PE", "(81) 98868-5457", (byte) 59, new ArrayList<>(Arrays.asList("")), baterPonto, "YJW6gmdXq2", dataAdimissao, null));

    }
}
