package Game;
import java.util.Scanner;

import Board.Tabuleiro;
import Board.TabuleiroNum;

public class Main {

	
public static boolean jogar(TabuleiroNum tabuleiro,Jogador jogador, KeyListener keyPress){
	
		Scanner scanner = new Scanner(System.in);
		
		if (tabuleiro.checarAcerto() == true) {
			return false;
		}
		
		tabuleiro.printTabuleiro();
		keyPress.KeyPress(tabuleiro);
		System.out.println("Próxima iteração?");
		String next = scanner.nextLine();
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

	TabuleiroNum tabuleiro = new TabuleiroNum(ordemTabuleiro);
	Jogador jogador = new Jogador(playerName);
	
	tabuleiro.setPedrinhas();
	tabuleiro.criaTabuleiro();
	
	while(running) {
		running = jogar(tabuleiro, jogador, keyPress);
		
	}
	
}


}
