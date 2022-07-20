package br.com.entra21.backend.bd;

import java.util.HashMap;

public class Armazenar {

    public static HashMap<String, Cliente> clientes = new HashMap();
    public static HashMap<String, Funcionario> funcionarios = new HashMap();
    public static HashMap<String, Empresa> empresas = new HashMap();

    public static void massaDeDados() {

        gerarCliente();
        gerarFuncionario();
        gerarEmpresa();

    }

    public static void gerarCliente() {

        clientes.put("001", new Cliente("Lavinia Vera Luzia Rezende", (byte) 70, "001"));
        clientes.put("002", new Cliente("Luciana Elisa Assunção", (byte) 48, "002"));
        clientes.put("003", new Cliente("Marina Marlene Mariane Drumond", (byte) 78, "003"));

    }

    public static void gerarEmpresa() {

        empresas.put("001", new Empresa("Henry e Isaac Mudanças Ltda", "88.904.346/0001-65"));
        empresas.put("002", new Empresa("Vanessa e Pedro Henrique Gráfica Ltda", "54.822.538/0001-00"));
        empresas.put("003", new Empresa("Emanuel e Josefa Assessoria Jurídica Ltda", "80.522.904/0001-16"));

    }

    public static void gerarFuncionario() {

        Funcionario admin = new Funcionario("Admin", (byte) 32, "001");
        admin.setSenha("123");
        funcionarios.put("001", admin);

        funcionarios.put("002", new Funcionario("Dono", (byte) 54, "002"));
        funcionarios.put("003", new Funcionario("Estagiario", (byte) 23, "003"));

    }

}
