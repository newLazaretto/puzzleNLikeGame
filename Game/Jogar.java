package Game;

import java.util.Scanner;

import Board.Tabuleiro;

public class Jogar {
static //Melhor separação do método para iniciar o jogo futuramente
	
	Scanner scanner = new Scanner(System.in);
	
	public boolean jogar(Tabuleiro tabuleiro,Jogador jogador, int maluco, int maluquice) throws CheckValorException{
		
		if (maluco == 1) {
			tabuleiro.puzzleMaluco(maluquice);
		}
		tabuleiro.printTabuleiro();
		if (tabuleiro.checarAcerto() == true) {
			return false;
		}
		System.out.println("Próxima iteração?");
		char next = scanner.next().charAt(0);
		try {
			tabuleiro.movePedrinha(next);
		} catch (ComandoInvalidoException e) {
			e.printStackTrace();
		}
		return true;
}
}
