package Board;

import java.util.Random;

public class TabuleiroChar extends Tabuleiro{

	char[] caracteres;
	public TabuleiroChar(int ordemTabuleiro) {
		super(ordemTabuleiro);
		caracteres = new char[ordemTabuleiro*ordemTabuleiro];
	}
	public void setCaracteres() {
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
}
