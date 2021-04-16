package jogo;

import java.util.Random;
import java.util.Scanner;

public class JogoAdvinhacao {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		char jogarNovamente = 's';
		

		while (jogarNovamente != 'n') {

			int totalDeTentativas;
			int chute = 0;
			double pontos = 1000.0;
			
			
			System.out.println("Selecione o intervalo de n�meros que queres advinhar!");
			System.out.println("Ex: 0 a 100, onde o n�mero inicial � 0 e o final � 100. \n");
			
			System.out.println("Qual o n�mero inicial do intervalo? ");
			int numeroInicial = sc.nextInt();
			
			System.out.println("Qual o n�mero final do intervalo? ");
			int numeroFinal = sc.nextInt();
			
			int intervalo = numeroFinal - numeroInicial;
			int numeroRandomico = random.nextInt(intervalo);
			
			
			//int numeroSecreto = numeroRandomico % (numeroFinal - numeroInicial);
			
			
			System.out.println("Selecione o n�vel de dificuldade: ");
			System.out.println("(1) F�cil, (2) M�dio, (3) Dif�cil");
			int nivel = sc.nextInt();

			switch (nivel) {
				case 1:
					totalDeTentativas = 20;
					break;
				case 2:
					totalDeTentativas = 10;
					break;
				case 3:
					totalDeTentativas = 5;
					break;
				default:
					totalDeTentativas = 3;
					break;

			}
			
			// contabiliza as tentativas de acordo com o n�vel
			for (int i = 1; i <= totalDeTentativas; i++) {
				
				System.out.printf("Tentativa %d de %d ", i, totalDeTentativas);
				chute = sc.nextInt();
				
				
				if(chute < 0) {
					System.out.println("N�mero negativos s�o inv�lidos!");
					i--;
					continue;
				}

				if (chute == numeroRandomico) {
					break;
				} 
				else if (chute > numeroRandomico) {
					System.out.println("O n�mero secreto � menor!\n");
				} 
				else {
					System.out.println("O n�mero secreto � maior!\n");
				}
				
				// os pontos s�o calculados de acordo com a precis�o do chute
				// quanto mais distante o chute do n�mero correto, mais pontos ser�o perdidos
				double pontosPerdidos = (chute - numeroRandomico) / 2.0;
				
				if(chute < numeroRandomico) {
					// quando o chute � menor que o n�mero secreto resulta em um n�mero negativo
					// eis a raz�o para divis�o por -2.0
					pontosPerdidos = (chute - numeroRandomico) / -2.0; 
				}
				
				pontos -= pontosPerdidos;

			}

			if (chute == numeroRandomico) {
				System.out.println("Voc� ganhou!");
				System.out.println("Sua pontua��o nessa rodada foi: " + pontos);
			} 
			else {
				System.out.println("Voc� perdeu!");
			}

			System.out.println("Deseja jogar novamente? s/n");
			jogarNovamente = sc.next().charAt(0);
		}
		
		sc.close();
	}

}
