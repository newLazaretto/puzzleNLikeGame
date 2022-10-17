package Board;

import java.util.Random;
import java.util.Scanner;

import Game.ComandoInvalidoException;

public class TabuleiroChar extends Tabuleiro{

	char[] caracteres;
	char[][] matrizChar;
	public TabuleiroChar(int ordemTabuleiro) {
		super(ordemTabuleiro);
		caracteres = new char[ordemTabuleiro*ordemTabuleiro];
		matrizChar = new char[ordemTabuleiro][ordemTabuleiro];
	}
	public void setPedrinhas() {
		int acumula = 65;
		for(int i=0;i<caracteres.length;i++) {
			caracteres[i] = (char) acumula;
			acumula ++;
		}
	}
	public static void shufflePedrinhas(char[] caracteres) {
		Random random = new Random();
		for(int i=0; i<(caracteres.length - 1);i++) {
			int j = random.nextInt(caracteres.length);
			int tmp = caracteres[i];
			caracteres[i] = caracteres[j];
			caracteres[j] = (char) tmp;
		}
	}
	public void setMatriz(char[] caracteres) {
		int acumula = 0;
		for(int i=0;i<super.getOrdem();i++) {
			for(int j=0;j<super.getOrdem();j++) {
				this.matrizChar[i][j] = caracteres[(char) acumula];
				acumula +=1;
			}
		}
	}
	public void criaTabuleiro() {
			
			shufflePedrinhas(caracteres);
			setMatriz(caracteres);
		}

	public void printTabuleiro() {
		//Adição do indicativo de acerto
		int k = 65;
		for (int i = 0; i<super.getOrdem(); i++) {
			System.out.print("|");
			for(int j=0;j<super.getOrdem();j++) {
				if (matrizChar[i][j] == (char) (65+(super.getOrdem() * super.getOrdem())-1)) {
					System.out.print("   |");
				}else {
				System.out.print(" "+matrizChar[i][j]+" |");
				}// if (matrizChar[i][j] == (char) k) {
				//	System.out.print("*");
				//}
			} k++;
			System.out.println("");
		}
	}
	public boolean checarAcerto() {
		int acumulaPontos = 0;
		int acumulaChar = 65;
		for (int i=0;i<super.getOrdem();i++) {
			for(int j=0;j<super.getOrdem();j++) {
				if (matrizChar[i][j] == (char) acumulaChar) {
					acumulaPontos +=1;
				}
				acumulaChar ++;
			}
		}
		if (acumulaPontos == 8) {
			return true;
		}
		return false;
	}
	
	public void movePedrinha(char comando){
		if (comando == 'w') {	
			for(int i = 1;i<super.getOrdem();i++) {
				for(int j=0;j<super.getOrdem();j++) {
						if (this.matrizChar[i][j] == (char) (65+(super.getOrdem() * super.getOrdem())-1)) {
							char tmp = this.matrizChar[i-1][j];
							this.matrizChar[i-1][j] = 0;
							this.matrizChar[i][j] = tmp;
					}
				}
			}
	}
		if (comando == 'd') {
			for(int i = 0;i<super.getOrdem();i++) {
				for(int j=1;j>=0;j--) {
						if (this.matrizChar[i][j] == (char) (65+(super.getOrdem() * super.getOrdem())-1)) {
							char tmp = this.matrizChar[i][j+1];
							this.matrizChar[i][j+1] = 0;
							this.matrizChar[i][j] = tmp;
					}
				}
			}
		}
		if (comando == 's') {
			for(int i = 1;i>=0;i--) {
				for(int j=0;j<super.getOrdem();j++) {
						if (this.matrizChar[i][j] == (char) (65+(super.getOrdem() * super.getOrdem())-1)) {
							char tmp = this.matrizChar[i+1][j];
							this.matrizChar[i+1][j] = 0;
							this.matrizChar[i][j] = tmp;
					}
				}
			}
		}
		if(comando == 'a') {
			for(int i = 0;i<super.getOrdem();i++) {
				for(int j=1;j<super.getOrdem();j++) {
						if (this.matrizChar[i][j] == (char) (65+(super.getOrdem() * super.getOrdem())-1)) {
							char tmp = this.matrizChar[i][j-1];
							this.matrizChar[i][j-1] = 0;
							this.matrizChar[i][j] = tmp;
					}
				}
			}
		}
	}
	public void help() {
		int k = 65;
		Scanner help = new Scanner(System.in);
		System.out.println("Em qual caractere deseja ajuda?");
		char ajuda = help.next().charAt(0);
		for(int i=0;i<caracteres.length;i++) {
			if (ajuda == (char) k) {
				System.out.println("A posição correta para seu caractere é a posição " + i+1);
			}
		}
	}
	public void returnArray(int[] array) {
		
	}
	
}
