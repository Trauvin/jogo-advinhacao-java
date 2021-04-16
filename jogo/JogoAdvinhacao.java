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
			
			
			System.out.println("Selecione o intervalo de números que queres advinhar!");
			System.out.println("Ex: 0 a 100, onde o número inicial é 0 e o final é 100. \n");
			
			System.out.println("Qual o número inicial do intervalo? ");
			int numeroInicial = sc.nextInt();
			
			System.out.println("Qual o número final do intervalo? ");
			int numeroFinal = sc.nextInt();
			
			int intervalo = numeroFinal - numeroInicial;
			int numeroRandomico = random.nextInt(intervalo);
			
			
			//int numeroSecreto = numeroRandomico % (numeroFinal - numeroInicial);
			
			
			System.out.println("Selecione o nível de dificuldade: ");
			System.out.println("(1) Fácil, (2) Médio, (3) Difícil");
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
			
			// contabiliza as tentativas de acordo com o nível
			for (int i = 1; i <= totalDeTentativas; i++) {
				
				System.out.printf("Tentativa %d de %d ", i, totalDeTentativas);
				chute = sc.nextInt();
				
				
				if(chute < 0) {
					System.out.println("Número negativos são inválidos!");
					i--;
					continue;
				}

				if (chute == numeroRandomico) {
					break;
				} 
				else if (chute > numeroRandomico) {
					System.out.println("O número secreto é menor!\n");
				} 
				else {
					System.out.println("O número secreto é maior!\n");
				}
				
				// os pontos são calculados de acordo com a precisão do chute
				// quanto mais distante o chute do número correto, mais pontos serão perdidos
				double pontosPerdidos = (chute - numeroRandomico) / 2.0;
				
				if(chute < numeroRandomico) {
					// quando o chute é menor que o número secreto resulta em um número negativo
					// eis a razão para divisão por -2.0
					pontosPerdidos = (chute - numeroRandomico) / -2.0; 
				}
				
				pontos -= pontosPerdidos;

			}

			if (chute == numeroRandomico) {
				System.out.println("Você ganhou!");
				System.out.println("Sua pontuação nessa rodada foi: " + pontos);
			} 
			else {
				System.out.println("Você perdeu!");
			}

			System.out.println("Deseja jogar novamente? s/n");
			jogarNovamente = sc.next().charAt(0);
		}
		
		sc.close();
	}

}
