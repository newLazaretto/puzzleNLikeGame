package Game;
import java.util.Scanner;

import Board.Tabuleiro;

public class Main {

	
public static boolean jogar(Tabuleiro tabuleiro,Jogador jogador){
	
		Scanner scanner = new Scanner(System.in);
		
		if (tabuleiro.checarAcerto() == true) {
			return false;
		}
		
		System.out.println("Insira o nome do jogador: ");
		String d = scanner.nextLine();
		tabuleiro.setPedrinhas();
		tabuleiro.criaTabuleiro();
		tabuleiro.printTabuleiro();
		return true;
}
	

public static void main(String[] args){
	boolean running = true;
	
	Scanner scanner = new Scanner(System.in);

	System.out.println("Insira o nome do jogador: ");
	String playerName = scanner.nextLine();
	
	System.out.println("Insira a ordem do tabuleiro: ");
	int ordemTabuleiro = scanner.nextInt();
	
	Tabuleiro tabuleiro = new Tabuleiro(ordemTabuleiro);
	Jogador jogador = new Jogador(playerName);
	
	while(running) {
		running = jogar(tabuleiro, jogador);
		
	}
	
}


}
