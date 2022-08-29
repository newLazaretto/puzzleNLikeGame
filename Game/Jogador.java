package Game;

public class Jogador {

	
	private int pontos = 0;
	private String nome;
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public int getPontos() {
		return this.pontos; 
	}
	public void increasePontos(int pontos) {
		this.pontos = pontos;
	}
}
