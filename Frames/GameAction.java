package Frames;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class GameAction extends AbstractAction{

	int jogo;
	
	public GameAction(int jogo) {
		this.jogo = jogo;
	}
	
	public void actionPerformed(ActionEvent e) {
		new GameFrame(jogo);
	}

}
