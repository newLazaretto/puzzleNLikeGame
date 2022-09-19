package Game;
import java.util.Scanner;

import Board.Tabuleiro;
import Board.TabuleiroChar;
import Board.TabuleiroNum;

public class Main {
//Testes
	

	

public static void main(String[] args){
	boolean running = true;
	int maluquice = 0;
	Scanner scanner = new Scanner(System.in);
	KeyListener keyPress = new KeyListener();
	
	System.out.println("Insira o nome do jogador: ");
	String playerName = scanner.nextLine();
	
	System.out.println("Insira a ordem do tabuleiro: ");
	int ordemTabuleiro = scanner.nextInt();
	
	System.out.println("Você deseja entrar com o puzzle-N Maluco? (Pressione 1 caso deseja)");
	int maluco = scanner.nextInt();
	
	if (maluco == 1) {
		System.out.println("Escolha o nível de maluquice: (1, 2 ou 3)");
		maluquice = scanner.nextInt();
	}

	TabuleiroNum tabuleiro = new TabuleiroNum(ordemTabuleiro);
	Jogador jogador = new Jogador(playerName);
	
	tabuleiro.setPedrinhas();
	tabuleiro.criaTabuleiro();
	Jogar jogo = new Jogar();
	
	while(running) {
		try {
			running = jogo.jogar(tabuleiro, jogador, maluco, maluquice);
		} catch (CheckValorException e) {
			e.printStackTrace();
		}
		
	}
	
}


}
