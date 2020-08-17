//Programa de cadastro de funcionarios de uma empresa

import java.util.ArrayList;
import java.util.Scanner;

public class FolhaPagamento {

    public static void main(String[] args) {

        int codigo;
        int contrato;
        double salarioBase;
        short tempo;
        byte n;
        byte dependentes;
        byte idade;

        Scanner teclado = new Scanner(System.in);
        Imprimir.l("Digite o numero de funcionários");

        do {
            Imprimir.n("(entre 1 a 100):");
            n = teclado.nextByte();
        } while (n < 1 || n > 100);

        Imprimir.l("");

        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        /********* Criação de cada funcionario ********/

        for (int i = 0; i < n; i++) {

            Imprimir.n("Digite o código do funcionário: ");
            codigo = teclado.nextInt();

            Imprimir.l("Digite o tipo de contrato");
            do {
                Imprimir.n("(1:concursado 2:temporario): ");
                contrato = teclado.nextInt();
            } while (contrato != 1 && contrato != 2);

            Imprimir.n("Digite o salário-base: ");
            salarioBase = teclado.nextDouble();

            if (contrato == 1) {
                Imprimir.n("Digite quantos anos de trabalho: ");
            }
            if (contrato == 2) {
                Imprimir.n("Digite quantos meses de trabalho: ");
            }
            tempo = teclado.nextShort();

            if (contrato == 1) {
                Funcionario funcionario = new FuncionarioConcursado(codigo, salarioBase, tempo);
                listaFuncionarios.add(funcionario);

            }

            if (contrato == 2) {
                Funcionario funcionario = new FuncionarioTemporario(codigo, salarioBase, tempo);
                listaFuncionarios.add(funcionario);
            }

            Imprimir.l("Digite o numero de dependentes");
            do {
                Imprimir.n("(De 0 a 5): ");
                dependentes = teclado.nextByte();
            } while (dependentes < 0 || dependentes > 5);

            for (int j = 0; j < dependentes; j++) {

                Imprimir.l("Digite a idade do dependente nº " + (j + 1) + " :");
                idade = teclado.nextByte();

                listaFuncionarios.get(i).addDependente(idade);
            }

            Imprimir.l(" ");

        } // fechamento criação de funcionario

        /***** Impressão do resultado *****/

        Imprimir.l("-----------------------------------");
        Imprimir.l("A saída impressa correspondente é:");
        Imprimir.l("");

        for (int j = 0; j < listaFuncionarios.size(); j++) {

            listaFuncionarios.get(j).imprimirInfoBasica();
            listaFuncionarios.get(j).imprimirInfoSubClasse();

            Imprimir.l("");
        }

    }// main

}