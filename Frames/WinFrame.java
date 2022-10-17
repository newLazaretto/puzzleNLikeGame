package Frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinFrame extends JFrame{
	JLabel textfield = new JLabel();

	public WinFrame() {
		
		textfield.setText("Você Ganhou");
		
		JPanel painel = new JPanel();
		painel.setBackground(new Color(150,150,150));
		
		setSize(720,480);
		setLocation(400,250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		painel.add(textfield);
		add(painel);
		setVisible(true);
		
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
