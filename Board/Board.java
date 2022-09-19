package Board;

import Game.ComandoInvalidoException;

public interface Board {
	public abstract int getOrdem();
	public abstract void setPedrinhas();
	public abstract void movePedrinha(char comando) throws ComandoInvalidoException;
	public abstract void help();
	
}
