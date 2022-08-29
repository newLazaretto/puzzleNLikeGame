package Board;

import java.util.Random;

import Game.KeyListener;

public class TabuleiroNum extends Tabuleiro{

	private int[] pedrinhas;
	private int[][] matrizNum;
	
	public TabuleiroNum(int ordemTabuleiro) {
		super(ordemTabuleiro);
		this.pedrinhas = new int[ordemTabuleiro * ordemTabuleiro];
		this.matrizNum = new int[ordemTabuleiro][ordemTabuleiro];
	}

	public void setPedrinhas() {
		for(int i = 0; i<(super.getOrdem() * super.getOrdem()); i++) {
			this.pedrinhas[i] = i ;
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
	
	public void setMatriz(int[] pedrinhas) {
		int acumula = 0;
		for(int i=0;i<super.getOrdem();i++) {
			for(int j=0;j<super.getOrdem();j++) {
				this.matrizNum[i][j] = pedrinhas[acumula];
				acumula +=1;
			}
		}
	}
	
	public void criaTabuleiro() {
		shufflePedrinhas(pedrinhas);
		setMatriz(pedrinhas);
	}
	public void printTabuleiro() {
		for (int i = 0; i<super.getOrdem(); i++) {
			System.out.print("|");
			for(int j=0;j<super.getOrdem();j++) {
				if (matrizNum[i][j] == 0) {
					System.out.print("   |");
				}else {
				System.out.print(" "+matrizNum[i][j]+" |");
				}
			}
			System.out.println("");
		}
	}
	
	public boolean checarAcerto() {
		int acumula = 0;
		int k = 1;
		for (int i=0;i<super.getOrdem();i++) {
			for(int j=0;j<super.getOrdem();j++) {
				if (matrizNum[i][j] == k) {
					acumula +=1;
				}
				k++;
			}
		}
		if (acumula == 8) {
			return true;
		}
		return false;
	}
	
	//Controlar a pedrinha numero 0 que será tida como invisível
		//Será criada uma matriz de ordem NxN que mudará a cada movimento do jogador
		//Se o índice + 1 da matriz for igual ao numero da pedrinha, ele ganha pontos
		//Se todos as pedrinhas estiverem no lugar correto o jogo é ganho e recomeça
		public void movePedrinha(String comando) {
			if (comando == "w") {	
				for(int i = 1;i<super.getOrdem();i++) {
					for(int j=0;j<super.getOrdem();j++) {
							if (this.matrizNum[i][j] == 0) {
								int tmp = this.matrizNum[i-1][j];
								this.matrizNum[i-1][j] = 0;
								this.matrizNum[i][j] = tmp;
						}
					}
				}
		}
			if (comando == "d") {
				
			}
	}
}
