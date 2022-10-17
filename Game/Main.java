package Game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

import Board.Tabuleiro;
import Board.TabuleiroChar;
import Board.TabuleiroNum;
import Frames.MenuInicialFrame;
import Frames.WinFrame;

public class Main {
	
	
	
	
public static void main(String[] args) throws IOException{
	
	
	//int dificuldade = 3;
	//int maluquice = 0;
	MenuInicialFrame menu = new MenuInicialFrame();
	boolean running = true;
	Scanner scanner = new Scanner(System.in);
	
	
/*	System.out.println("Insira o nome do jogador: ");
	String playerName = scanner.nextLine();
	
	Tabuleiro tabuleiro = new TabuleiroNum(dificuldade + 1);
	
	Jogador jogador = new Jogador(playerName);
	
	tabuleiro.setPedrinhas();
	tabuleiro.criaTabuleiro();
	Jogar jogo = new Jogar();
	
	
	while(running) {
		try {
			running = jogo.jogar(tabuleiro, jogador, maluquice);
		} catch (CheckValorException e) {
			e.printStackTrace();
		}
		
	}*/
	
}


}
