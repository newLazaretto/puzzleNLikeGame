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
import javax.swing.JPanel;

public class ModalidadeFrame extends JFrame{

	private static java.io.File diretorio = new java.io.File("C:\\Users\\user\\eclipse-workspace\\Puzzle-N-Like Game\\src");
	private static java.io.File arquivoModalidade = new java.io.File(diretorio, "arq_mod.txt");
	
	private static void escrever(int modalidade){				
		try {
			FileWriter fileWriter = new FileWriter(arquivoModalidade, false);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print(modalidade);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}							
	}
	public ModalidadeFrame() {
		
		super("Selecione a Modalidade");
		setSize(300,100);
		setLocation(610,445);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setBackground(Color.BLUE);
		add(p);
		
		JButton num = new JButton("Numeros");
		num.setBackground(Color.YELLOW);
		num.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(1);
				ModalidadeFrame.this.dispose();
			}
			
		});
		p.add(num);
		JButton carac = new JButton("Caracteres");
		carac.setBackground(Color.YELLOW);
		carac.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(2);
				ModalidadeFrame.this.dispose();
			}
			
		});
		p.add(carac);
		JButton img = new JButton("Imagens");
		img.setBackground(Color.YELLOW);
		img.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				escrever(3);
				ModalidadeFrame.this.dispose();
			}
			
		});
		p.add(img);
		
		setVisible(true);
		
	}
	
	
	
	
}
