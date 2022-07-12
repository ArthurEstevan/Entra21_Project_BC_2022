package br.com.entra21.backend.confirmar;
import br.com.entra21.backend.bd.Armazenar;
import br.com.entra21.backend.bd.Cliente;
import br.com.entra21.backend.bd.Funcionario;

import java.util.Scanner;


public class Confirmar {

    static Scanner input = new Scanner(System.in);


    public static Cliente confirmarCliente() {

        return null;
    }

    public static Funcionario confirmarFuncionario() {

        Funcionario funcionario = new Funcionario();

        System.out.print("Informe CPF do funcionario: ");
        funcionario.setCpf(input.nextLine());

        return Armazenar.funcionario.get(funcionario.getCpf());

    }

}
