package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HowToPlayAction extends AbstractAction{

	
	public void actionPerformed(ActionEvent e) {
		
		ImageIcon icon = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\Puzzle-N-Like Game\\src\\icon.png");
		JOptionPane.showMessageDialog(null, "Em tabuleiros 2x2, 3x3 ou 4x4, ponha em ordem os números, caracteres ou blocos que compoem a imagem!\n"
				+ "Experimente também os níveis de maluquice, que vão de 0 a 3 e podem acabar embaralhando o seu jogo todo de novo!");
	}



}
