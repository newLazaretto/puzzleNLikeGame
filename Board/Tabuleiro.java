package Board;
import java.util.Scanner;
import java.util.Random;

import Game.Jogador;
//Classe abstrata do tabuleiro, futuramente implementará uma interface.
public abstract class Tabuleiro {
	
	private int ordemTabuleiro;
	
	public Tabuleiro(int ordemTabuleiro) {
		this.ordemTabuleiro = ordemTabuleiro;
	}
	
	public int getOrdem() {
		return ordemTabuleiro;
	}
	public abstract void setPedrinhas();
	public abstract void criaTabuleiro();
	public abstract void printTabuleiro();
	public abstract boolean checarAcerto();
	public abstract void movePedrinha(char comando);
	public abstract void help();
	
}
