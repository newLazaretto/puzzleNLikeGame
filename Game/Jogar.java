package Game;

import java.util.Scanner;

import Board.Tabuleiro;

public class Jogar {
static //Melhor separação do método para iniciar o jogo futuramente
	
	Scanner scanner = new Scanner(System.in);
	
	public boolean jogar(Tabuleiro tabuleiro,Jogador jogador, int maluquice) throws CheckValorException{
		
		if (maluquice > 0) {
			tabuleiro.puzzleMaluco(maluquice);
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
}
