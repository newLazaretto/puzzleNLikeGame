package Game;

public class Jogador {
//Por enquanto sem muito uso, mas será responsável por integrar o ranking futuramente
	
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
