package Frames;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DificuldadeFrame extends JFrame{
	
	private static java.io.File diretorio = new java.io.File("C:\\Users\\user\\eclipse-workspace\\Puzzle-N-Like Game\\src");
	private static java.io.File arquivoDificuldade = new java.io.File(diretorio, "arq_dif.txt");
	
	private static void escrever(int dificuldade){				
		try {
			FileWriter fileWriter = new FileWriter(arquivoDificuldade, false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(dificuldade);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}							
	}
	
	public DificuldadeFrame() {
		
		
		super("Selecione a Dificuldade");
		setSize(300,100);
		setLocation(610,445);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(224,235,106));
		setBackground(new Color(0,0,0));
		JPanel p = new JPanel();
		p.setBackground(new Color(224,235,106));
		add(p);
		JButton facil = new JButton("Fácil 2x2");
		facil.setBackground(new Color(60,182,192));
		facil.setForeground(new Color(0,0,0));
		facil.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(1);
				DificuldadeFrame.this.dispose();
			}
			
		});
		p.add(facil);
		JButton medio = new JButton("Médio 3x3");
		medio.setBackground(new Color(60,182,192));
		medio.setForeground(new Color(0,0,0));
		medio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(2);
				DificuldadeFrame.this.dispose();
			}
			
		});
		p.add(medio);
		JButton dificil = new JButton("Difícil 4x4");
		dificil.setBackground(new Color(60,182,192));
		dificil.setForeground(new Color(0,0,0));
		dificil.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(3);
				DificuldadeFrame.this.dispose();
			}
			
		});
		p.add(dificil);
		
		setVisible(true);
	}
	
	
	
	
}
