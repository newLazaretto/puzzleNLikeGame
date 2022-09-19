package Board;
import java.util.Scanner;
import java.util.Random;

import Game.CheckValorException;
import Game.ComandoInvalidoException;
import Game.Jogador;
//Classe abstrata do tabuleiro, futuramente implementará uma interface.
public abstract class Tabuleiro implements Board{
	
	private int ordemTabuleiro;
	
	public Tabuleiro(int ordemTabuleiro) {
		this.ordemTabuleiro = ordemTabuleiro;
	}
	
	public int getOrdem() {
		return ordemTabuleiro;
	}
	public abstract void printTabuleiro();
	public abstract boolean checarAcerto();
	public abstract void movePedrinha(char comando) throws ComandoInvalidoException;
	public abstract void criaTabuleiro();
	
	public void puzzleMaluco(int maluquice) throws CheckValorException{
		Random crazy = new Random();
		if (maluquice != 1 && maluquice != 2 && maluquice != 3) {
		CheckValorException e = new CheckValorException(maluquice);
				throw e;}
		if (maluquice == 1) {
			if (crazy.nextInt(10) == 0) {
				criaTabuleiro();
			}
		if (maluquice == 2) {
			if(crazy.nextInt(5) == 0) {
				criaTabuleiro();
			}
		}
		if (maluquice == 3) {
			if(crazy.nextInt(5) == 0) {
				criaTabuleiro();
			}
		}
		}
	}
}
