package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import Board.Tabuleiro;
import Board.TabuleiroChar;
import Board.TabuleiroImg;
import Board.TabuleiroNum;
public class GameFrame extends JFrame implements ActionListener{
	
	Tabuleiro tabuleiro;
	static java.io.File diretorio = new java.io.File("C:\\Users\\user\\eclipse-workspace\\Puzzle-N-Like Game\\src");
	static java.io.File arquivoDificuldade = new java.io.File(diretorio, "arq_dif.txt");
	static java.io.File arquivoMaluquice = new java.io.File(diretorio, "arq_mal.txt");
	static java.io.File arquivoModalidade = new java.io.File(diretorio, "arq_mod.txt");
	static java.io.File arquivoSave = new java.io.File(diretorio, "savefile.txt");
	static int[] arrayDif = new int[1];
	static int[] arrayMal = new int[1];
	static int[] arrayMod = new int[1];
	int[] array;
	char[] charArray;
	int dificuldade;
	int maluquice;
	int modalidade;
	int jogo;
	JButton[] slots;
	JPanel buttonPanel = new JPanel();
	JPanel optionsPanel = new JPanel();
	JButton salvar = new JButton();
	JButton ajuda = new JButton();

	public GameFrame(int jogo) {
		
		this.jogo = jogo;
		
		arrayDif = readFiles(arquivoDificuldade);
		dificuldade = arrayDif[0];
		arrayMal = readFiles(arquivoMaluquice);
		maluquice = arrayMal[0];
		arrayMod = readFiles(arquivoModalidade);
		modalidade = arrayMod[0];
		
		if (modalidade == 1){
			tabuleiro = new TabuleiroNum(dificuldade + 1);
		}
		if (modalidade == 2) {
			tabuleiro = new TabuleiroChar(dificuldade + 1);
		}
		if (modalidade == 3) {
			tabuleiro = new TabuleiroImg(dificuldade + 1);
		}
		this.array = new int[(dificuldade + 1)*(dificuldade + 1)];
		slots = new JButton[tabuleiro.getOrdem() * tabuleiro.getOrdem()];
		
		if (jogo == 1) {
		tabuleiro.setPedrinhas();
		tabuleiro.criaTabuleiro();
		tabuleiro.returnArray(array);
		}
		if(jogo == 2) {
			
			array = readFiles(arquivoSave);
			tabuleiro.setArray(array);
		}
		for(int i = 0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		setTitle("Puzzle-Shuffle");
		
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
		
		setSize(720,480);
		setLocation(400,250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(50,50,50));
		
		Font f = new Font("Impact", Font.BOLD,40);
		
		salvar.setText("Salvar");
		salvar.setBackground(new Color(224,235,106));
		salvar.addActionListener(this);
		ajuda.setText("Ajuda");
		ajuda.setBackground(new Color(224,235,106));
			
		
		for(int i=0;i<tabuleiro.getOrdem() * tabuleiro.getOrdem();i++) {
			slots[i] = new JButton();
			buttonPanel.add(slots[i]);
			slots[i].setFocusable(false);
			slots[i].addActionListener(this);
		}
		
		buttonPanel.setLayout(new GridLayout(tabuleiro.getOrdem(),tabuleiro.getOrdem()));
		buttonPanel.setBackground(new Color(60,182,192));
		
		add(optionsPanel,BorderLayout.PAGE_END);
		add(buttonPanel,BorderLayout.CENTER);	
		optionsPanel.setBackground(new Color(60,182,192));
		optionsPanel.add(salvar,BorderLayout.EAST);
		optionsPanel.add(ajuda,BorderLayout.WEST);
		
		for(int i = 0;i<tabuleiro.getOrdem()*tabuleiro.getOrdem();i++) {
			slots[i].setText(String.valueOf(array[i]));
			if (array[i] == 0) {
				slots[i].setVisible(false);
			}
			slots[i].setBackground(new Color(224,235,106));
			slots[i].setFont(f);
		}
		setVisible(true);
		
	}
	public int[] readFiles(File f) {
		
		try {
			
			Scanner s = new Scanner(f);
			int ctr = 0;
			while(s.hasNextInt()) {
				ctr++;
				s.nextInt();
			}
			int[] arr = new int[ctr];
			
			Scanner s1 = new Scanner(f);
			
			for(int i = 0; i < arr.length; i++)
				arr[i] = s1.nextInt();
			
			return arr;
		}
		catch(Exception e) {
			return null;
		}
		
	}

	private static void escreverNum(int[] array){				
		try {
			FileWriter fileWriter = new FileWriter(arquivoSave, false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(int i = 0; i< array.length; i++) {
			printWriter.print(array[i]);
			printWriter.print(" ");
			printWriter.flush();
			}
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}							
	}
	private static void escreverChar(char[] array) {
		try {
			FileWriter fileWriter = new FileWriter(arquivoSave, false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(int i = 0; i< array.length; i++) {
			printWriter.print(array[i]);
			printWriter.print(" ");
			printWriter.flush();
			}
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	

	

	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<slots.length;i++) {
			if(e.getSource() == slots[i]) {
				if (i<tabuleiro.getOrdem() * tabuleiro.getOrdem() - tabuleiro.getOrdem() && array[i+tabuleiro.getOrdem()] == 0) {
					tabuleiro.movePedrinha('w');
					tabuleiro.returnArray(array);
					slots[i+tabuleiro.getOrdem()].setText(String.valueOf(array[i+tabuleiro.getOrdem()]));
					slots[i+tabuleiro.getOrdem()].setVisible(true);
					slots[i].setText("0");
					slots[i].setVisible(false);
				}
				
				else if(i>=tabuleiro.getOrdem() && array[i-tabuleiro.getOrdem()] == 0) {
					tabuleiro.movePedrinha('s');
					tabuleiro.returnArray(array);			
					slots[i-tabuleiro.getOrdem()].setText(String.valueOf(array[i-tabuleiro.getOrdem()]));
					slots[i-tabuleiro.getOrdem()].setVisible(true);
					slots[i].setText("0");
					slots[i].setVisible(false);
				}
				else if(i!=0 && i%tabuleiro.getOrdem()!=0 && array[i-1] == 0) {
					tabuleiro.movePedrinha('d');
					tabuleiro.returnArray(array);
					slots[i-1].setText(String.valueOf(array[i-1]));
					slots[i-1].setVisible(true);
					slots[i].setText("0");
					slots[i].setVisible(false);
				}
				else if(i != (i/tabuleiro.getOrdem()+1)*(tabuleiro.getOrdem())-1 && array[i+1] == 0) {
					tabuleiro.movePedrinha('a');
					tabuleiro.returnArray(array);
					slots[i+1].setText(String.valueOf(array[i+1]));
					slots[i+1].setVisible(true);
					slots[i].setText("0");
					slots[i].setVisible(false);
				}
					
			}
			
			if(array[i] == i+1) {
				slots[i].setBackground(new Color(110,255,125));
			}
			else {
				slots[i].setBackground(new Color(224,235,106));
			}
			
			if(tabuleiro.checarAcerto()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				new WinFrame();
				this.dispose();
				
			}
			if(maluquice != 0){
				tabuleiro.puzzleMaluco(maluquice);
				tabuleiro.returnArray(array);
				for(int j = 0;j<tabuleiro.getOrdem()*tabuleiro.getOrdem();i++) {
					slots[j].setText(String.valueOf(array[j]));
					if (array[j] == 0) {
						slots[j].setVisible(false);
					}
				}
				
			}
		}
		if(e.getSource() == salvar) {
			if(modalidade == 1) {
			escreverNum(array);}
			else if(modalidade == 2) {
			escreverChar(charArray);
			}
			JOptionPane.showMessageDialog(null, "O jogo foi salvo!");
		}
		
	}
}
