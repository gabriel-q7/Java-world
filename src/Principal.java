
// ATP Métodos de pesquisa e ordenação em estrutura de dados
// Aluno: Gabriel Aquiar Aquino

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /*
        System.out.println("Entre com os termos a ser pesquisados (separados por espaço):");
        System.out.println("Os arquivos encontrados foram:");
        String entradaInicial = teclado.nextLine();
         */

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        arvore.insere("bola","arq1");
        arvore.insere("bola","arq1");
        arvore.insere("bola","arq2");
        arvore.insere("casa","arq1");
        arvore.insere("arvore","arq2");
        arvore.insere("dado","arq1");
        arvore.insere("dado","arq2");

        System.out.println(arvore.imprimirArvore(0));

        Buscador buscador = new Buscador(arvore);

        System.out.println(buscador.busca("bola").listar());

    }
}
