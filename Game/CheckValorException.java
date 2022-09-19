package Game;

public class CheckValorException extends Exception{

	public CheckValorException(int valor) {
		super("o valor "+valor+" não é suportado. Tente novamente com outro!!!");
	}
}
