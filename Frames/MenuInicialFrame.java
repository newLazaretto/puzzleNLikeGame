package Frames;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class MenuInicialFrame extends JFrame{
	
	
	
	public MenuInicialFrame() {
		super("Puzzle-Shuffle");
		
		BufferedImage img = null;	
		try {
			img = ImageIO.read(new File("wallpaper.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    
		} catch (ClassNotFoundException e) {
		    
		} catch (InstantiationException e) {
		    
		} catch (IllegalAccessException e) {
		    
		}
		//getContentPane().setBackground(new java.awt.Color(R,G,B));
		JLabel label = new JLabel();
		setSize(614,661);
		setLocation(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(50,50,50));
		setResizable(false);
		
		Image dimg = img;
		ImageIcon imageIcon = new ImageIcon(dimg);
		label.setIcon(imageIcon);
		
		criarMenu();
		
		setVisible(true);
		add(label);
		
		
	}
	
	private void criarMenu() {
		
		
		JMenu jogar = new JMenu("Jogar");
		jogar.setMnemonic('J');
		JMenuItem novoJogo = new JMenuItem(new GameAction(1));
		novoJogo.setText("Novo Jogo");
		novoJogo.setMnemonic('N');
		jogar.add(novoJogo);
		JMenuItem continuaJogo = new JMenuItem(new GameAction(2));
		continuaJogo.setText("Continuar");
		continuaJogo.setMnemonic('C');
		jogar.add(continuaJogo);
		JMenuItem ranking = new JMenuItem("Ranking");
		ranking.setMnemonic('R');
		jogar.add(ranking);
		
		JMenu configuracoes = new JMenu("Configurações");
		configuracoes.setMnemonic('C');
		JMenuItem dificuldade = new JMenuItem(new DificuldadeAction());
		dificuldade.setText("Dificuldade");
		dificuldade.setMnemonic('D');
		configuracoes.add(dificuldade);
		JMenuItem modalidade = new JMenuItem(new ModalidadeAction());
		modalidade.setText("Modalidade");
		modalidade.setMnemonic('M');
		configuracoes.add(modalidade);
		JMenuItem maluquice = new JMenuItem(new MaluquiceAction());
		maluquice.setText("Maluquice");
		maluquice.setMnemonic('M');
		configuracoes.add(maluquice);
		
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('A');
		JMenuItem howToPlay = new JMenuItem(new HowToPlayAction());
		howToPlay.setText("Como Jogar");
		howToPlay.setMnemonic('C');
		ajuda.add(howToPlay);
		
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(jogar);
		barra.add(configuracoes);
		barra.add(ajuda);
		
	}
	
}

	

