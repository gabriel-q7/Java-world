//Programa de enquete 23/05/20

import java.util.Scanner;

public class enquete {

    static void print(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {

        float WinSer = 0;
        float Unix = 0;
        float Linux = 0;
        float Netware = 0;
        float MasOS = 0;
        float Outro = 0;
        float total = 0;

        print("Enquete: Qual é o melhor sistema operacional para uso em servidores?");
        print("1 - Windows Server.");
        print("2 - Unix.");
        print("3 - Linux.");
        print("4 - Netware.");
        print("5 - Mac OS.");
        print("6 - Outros.");
        print("0 - Terminar enquete");
        print("");
        print("Digite sua escolha:");

        Scanner teclado = new Scanner(System.in);
        int opiniao = teclado.nextInt();

        while (opiniao != 0) {

            switch (opiniao) {
                case 1:
                    WinSer++;
                    break;
                case 2:
                    Unix++;
                    break;
                case 3:
                    Linux++;
                    break;
                case 4:
                    Netware++;
                    break;
                case 5:
                    MasOS++;
                    break;
                case 6:
                    Outro++;
                    break;
                default:
                    print("Digite uma opção válida...");

            }

            print("Digite sua escolha:");
            opiniao = teclado.nextInt();
        }

        total = WinSer + Unix + Linux + Netware + MasOS + Outro;

        print("Fim da enquete");
        print("");
        print("-------Resultado--------");
        print("Votos Windows Server: " + WinSer + ", " + WinSer / total * 100 + "%");
        print("Votos Unix: " + Unix + ", " + Unix / total * 100 + "%");
        print("Votos Linux: " + Linux + ", " + Linux / total * 100 + "%");
        print("Votos Netware: " + Netware + ", " + Netware / total * 100 + "%");
        print("Votos MasOS: " + MasOS + ", " + MasOS / total * 100 + "%");
        print("Votos Outros: " + Outro + ", " + Outro / total * 100 + "%");
    }
}