package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import Board.Tabuleiro;

public class KeyListener extends JFrame{
	
	public void KeyPress(Tabuleiro tabuleiro) {
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int codigo = e.getKeyCode();
				
				if (codigo == KeyEvent.VK_UP) {
					tabuleiro.movePedrinha('w');
				}
				if(codigo == KeyEvent.VK_RIGHT) {
					tabuleiro.movePedrinha('d');
				}
				if(codigo == KeyEvent.VK_DOWN) {
					tabuleiro.movePedrinha('s');
				}
				if (codigo == KeyEvent.VK_LEFT) {
					tabuleiro.movePedrinha('a');
				}
			}
		});
	}
	
}
		
	
	

