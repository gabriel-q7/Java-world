import java.util.Scanner;

public class prog {

	// função básica
	static void imprimir(String texto) {
		System.out.println(texto);
	}

	public static void main(String args[]) {

		/////// Variaveis

		/*
		 * double numero; float numero = 32.34f; imprimir(numero);
		 */

		/*
		 * char letra = 'd'; imprimir(letra); //aspas simples
		 */

		/*
		 * String palavra = "teste"; imprimir(palavra); //aspas duplas
		 */

		// boolean bin = true;

		// Tomada de dados
		// Scanner teclado = new Scanner(System.in);

		/*
		 * imprimir("Digite o seu nome:"); String nome = teclado.next();
		 * 
		 * imprimir("Digite a sua idade:"); int k = teclado.nextInt();
		 * 
		 * imprimir("Voce se chama " + nome + " e tem " + k + " anos.");
		 */

		/*
		 * imprimir("Digite o preço do produto:"); double preco = teclado.nextDouble();
		 * 
		 * if (preco <= 100){ imprimir("preço bom"); }else{ imprimir("Muito caro"); }
		 */

		imprimir("Digite um valor inteiro:");
		int k = teclado.nextInt();

		switch (k) {
			case 1:
				imprimir("Segunda");
				break;
			case 2:
				imprimir("Terça");
				break;
			case 3:
				imprimir("Quarta");
				break;
			case 4:
				imprimir("Quinta");
				break;
			case 5:
				imprimir("Sexta");
				break;
			case 6:
				imprimir("Sabado");
				break;
			case 7:
				imprimir("Domingo");
				break;
			default:
				imprimir("Erro");

		}
	}

}
