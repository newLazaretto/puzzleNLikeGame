package Game;
import java.io.IOException;
import Board.Tabuleiro;

public class Main {

public static void jogar(Tabuleiro tabuleiro, Jogador jogador){

	while(true) {

		tabuleiro.setPedrinhas();
		tabuleiro.criaTabuleiro();
		while(true) {
			if (tabuleiro.checarAcerto() == true) {
				break;
			}
			tabuleiro.printTabuleiro();
		}
	}
	
}
public static void main(String[] args){
	
	
	Tabuleiro tabuleiro = new Tabuleiro(3);
	Jogador jogador = new Jogador("Lazaro");
	
	jogar(tabuleiro, jogador);
	
	}


}
