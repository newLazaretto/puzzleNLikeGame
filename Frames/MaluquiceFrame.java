package Frames;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaluquiceFrame extends JFrame{

	private static java.io.File diretorio = new java.io.File("C:\\Users\\user\\eclipse-workspace\\Puzzle-N-Like Game\\src");
	private static java.io.File arquivoMaluquice = new java.io.File(diretorio, "arq_mal.txt");
	
	private static void escrever(int maluquice){				
		try {
			FileWriter fileWriter = new FileWriter(arquivoMaluquice, false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(maluquice);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}							
	}
	public MaluquiceFrame() {
		super("Selecione o Nível de Maluquice");
		setSize(300, 100);
		setLocation(610,445);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(224,235,106));
		
		JPanel p = new JPanel();
		p.setBackground(new Color(224,235,106));
		add(p);
		
		JButton zero = new JButton("0");
		zero.setBackground(new Color(60,182,192));
		zero.setForeground(new Color(0,0,0));
		zero.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				escrever(0);
				MaluquiceFrame.this.dispose();
			}
			
		});
		p.add(zero);
		JButton one = new JButton("1");
		one.setBackground(new Color(60,182,192));
		one.setForeground(new Color(0,0,0));
		one.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(1);
				MaluquiceFrame.this.dispose();
			}
			
		});
		p.add(one);
		JButton two = new JButton("2");
		two.setBackground(new Color(60,182,192));
		two.setForeground(new Color(0,0,0));
		two.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(2);
				MaluquiceFrame.this.dispose();
			}
			
		});
		p.add(two);
		JButton three = new JButton("3");
		three.setBackground(new Color(60,182,192));
		three.setForeground(new Color(0,0,0));
		three.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(3);
				MaluquiceFrame.this.dispose();
			}
			
		});
		p.add(three);
		
		
		
		
		setVisible(true);
	}
	
	
}
