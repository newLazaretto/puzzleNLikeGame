package Game;
import java.util.Scanner;

import Board.Tabuleiro;
import Board.TabuleiroChar;
import Board.TabuleiroNum;

public class Main {
//Testes
	
public static boolean jogar(Tabuleiro tabuleiro,Jogador jogador, int maluco){
	
		Scanner scanner = new Scanner(System.in);
		
		if (maluco == 1) {
			tabuleiro.puzzleMaluco();
		}
		tabuleiro.printTabuleiro();
		if (tabuleiro.checarAcerto() == true) {
			return false;
		}
		System.out.println("Próxima iteração?");
		char next = scanner.next().charAt(0);
		tabuleiro.movePedrinha(next);
		return true;
}
	

public static void main(String[] args){
	boolean running = true;
	
	Scanner scanner = new Scanner(System.in);
	KeyListener keyPress = new KeyListener();
	
	System.out.println("Insira o nome do jogador: ");
	String playerName = scanner.nextLine();
	
	System.out.println("Insira a ordem do tabuleiro: ");
	int ordemTabuleiro = scanner.nextInt();
	
	System.out.println("Você deseja entrar com o puzzle-N Maluco? (Pressione 1 caso deseja)");
	int maluco = scanner.nextInt();

	TabuleiroNum tabuleiro = new TabuleiroNum(ordemTabuleiro);
	Jogador jogador = new Jogador(playerName);
	
	tabuleiro.setPedrinhas();
	tabuleiro.criaTabuleiro();
	
	while(running) {
		running = jogar(tabuleiro, jogador, maluco);
		
	}
	
}


}
