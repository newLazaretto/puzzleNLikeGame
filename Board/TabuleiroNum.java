package Board;

import java.util.Random;
import java.util.Scanner;

import Game.ComandoInvalidoException;
import Game.KeyListener;
//Classe do tabuleiro numérico, lógica funcionando bem, mas comando de usuário incompleto.
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
		//Adição de um indicativo de que a peça está no lugar correto
		int k = 1;
		for (int i = 0; i<super.getOrdem(); i++) {
			System.out.print("|");
			for(int j=0;j<super.getOrdem();j++) {
				if (matrizNum[i][j] == 0) {
					System.out.print("   |");
				}else {
				System.out.print(" "+matrizNum[i][j]+" |");
				} /*if (matrizNum[i][j] == k) {
					System.out.print("*");
				}*/
			} k++;
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
	
		public void movePedrinha(char comando) throws ComandoInvalidoException{
			if (comando != 'w' && comando != 'a' && comando != 's' && comando != 'd') {
				ComandoInvalidoException e = new ComandoInvalidoException();
				throw e;
			}
			if (comando == 'w') {	
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
			if (comando == 'd') {
				for(int i = 0;i<super.getOrdem();i++) {
					for(int j=1;j>=0;j--) {
							if (this.matrizNum[i][j] == 0) {
								int tmp = this.matrizNum[i][j+1];
								this.matrizNum[i][j+1] = 0;
								this.matrizNum[i][j] = tmp;
						}
					}
				}
			}
			if (comando == 's') {
				for(int i = 1;i>=0;i--) {
					for(int j=0;j<super.getOrdem();j++) {
							if (this.matrizNum[i][j] == 0) {
								int tmp = this.matrizNum[i+1][j];
								this.matrizNum[i+1][j] = 0;
								this.matrizNum[i][j] = tmp;
						}
					}
				}
			}
			if(comando == 'a') {
				for(int i = 0;i<super.getOrdem();i++) {
					for(int j=1;j<super.getOrdem();j++) {
							if (this.matrizNum[i][j] == 0) {
								int tmp = this.matrizNum[i][j-1];
								this.matrizNum[i][j-1] = 0;
								this.matrizNum[i][j] = tmp;
						}
					}
				}
			}
	}
		public void help() {
			Scanner help = new Scanner(System.in);
			System.out.println("Em qual numero deseja ajuda?");
			char ajuda = help.next().charAt(0);
			for(int i=0;i<pedrinhas.length;i++) {
				if (ajuda == i+1) {
					System.out.println("A posição correta para seu caractere é a posição " + i+1);
				}
			}
		}
}