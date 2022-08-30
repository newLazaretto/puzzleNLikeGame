package Board;

import java.util.Random;
//Tabuleiro com letras do alfabeto, lógica funcionando bem
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
				if (matrizChar[i][j] == 0) {
					System.out.print("   |");
				}else {
				System.out.print(" "+matrizChar[i][j]+" |");
				} if (matrizChar[i][j] == (char) k) {
					System.out.print("*");
				}
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
	
	public void movePedrinha(char comando) {
		
	}
	public void help() {
		
	}
	
}
