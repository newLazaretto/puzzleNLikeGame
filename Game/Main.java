package Game;
import java.util.Scanner;

import Board.Tabuleiro;
import Board.TabuleiroNum;

public class Main {

	
public static boolean jogar(TabuleiroNum tabuleiro,Jogador jogador){
	
		Scanner scanner = new Scanner(System.in);
		
		if (tabuleiro.checarAcerto() == true) {
			return false;
		}
		
		tabuleiro.printTabuleiro();
		System.out.println("Insira o nome do jogador: ");
		String d = scanner.nextLine();
		tabuleiro.movePedrinha();
		
		return true;
}
	

public static void main(String[] args){
	boolean running = true;
	
	Scanner scanner = new Scanner(System.in);

	System.out.println("Insira o nome do jogador: ");
	String playerName = scanner.nextLine();
	
	System.out.println("Insira a ordem do tabuleiro: ");
	int ordemTabuleiro = scanner.nextInt();
	
	TabuleiroNum tabuleiro = new TabuleiroNum(ordemTabuleiro);
	Jogador jogador = new Jogador(playerName);
	
	tabuleiro.setPedrinhas();
	tabuleiro.criaTabuleiro();
	
	while(running) {
		running = jogar(tabuleiro, jogador);
		
	}
	
}


}
