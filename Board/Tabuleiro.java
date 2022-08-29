package Board;
import java.util.Random;

import Game.Jogador;

public class Tabuleiro {
	
	private int ordemTabuleiro;
	private int[] pedrinhas;
	private int[][] matriz;
	
	public Tabuleiro(int ordemTabuleiro) {
		this.ordemTabuleiro = ordemTabuleiro;
		this.pedrinhas = new int[ordemTabuleiro * ordemTabuleiro];
		this.matriz = new int[ordemTabuleiro][ordemTabuleiro];
	}
	
	public void setPedrinhas() {
		for(int i = 0; i<(ordemTabuleiro * ordemTabuleiro); i++) {
			this.pedrinhas[i] = i ;
		}
	}
	public void setMatriz(int[] pedrinhas) {
		int acumula = 0;
		for(int i=0;i<ordemTabuleiro;i++) {
			for(int j=0;j<ordemTabuleiro;j++) {
				this.matriz[i][j] = pedrinhas[acumula];
				acumula +=1;
			}
		}
	}
	public static void shufflePedrinhas(int [] pedrinhas) {
		Random random = new Random();
		for(int i=0; i<(pedrinhas.length - 1);i++) {
			int j = random.nextInt(pedrinhas.length);
			int tmp = pedrinhas[i];
			pedrinhas[i] = pedrinhas[j];
			pedrinhas[j] = tmp;
		}
	}
	//Controlar a pedrinha numero 0 que será tida como invisível
	//Será criada uma matriz de ordem NxN que mudará a cada movimento do jogador
	//Se o índice + 1 da matriz for igual ao numero da pedrinha, ele ganha pontos
	//Se todos as pedrinhas estiverem no lugar correto o jogo é ganho e recomeça
	public void movePedrinha() {
		//A fazer
	}
	public void criaTabuleiro() {
		
		shufflePedrinhas(pedrinhas);
		setMatriz(pedrinhas);
	
	}
	public void printTabuleiro() {
		for (int i = 0; i<ordemTabuleiro; i++) {
			System.out.print("|");
			for(int j=0;j<ordemTabuleiro;j++) {
				if (matriz[i][j] == 0) {
					System.out.print("   |");
				}else {
				System.out.print(" "+matriz[i][j]+" |");
				}
			}
			System.out.println("");
		}
	}
	public boolean checarAcerto() {
		int acumula = 0;
		for (int i=0;i<ordemTabuleiro;i++) {
			for(int j=0;j<ordemTabuleiro;j++) {
				if (matriz[i][j] == i+1 && matriz[i][j] == j + 1) {
					acumula +=1;
				}
			}
		}
		if (acumula == 8) {
			return true;
		}
		return false;
	}

}
