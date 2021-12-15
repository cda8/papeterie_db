package fr.eni.papeterie.exception;

public class DALException extends Exception {
	//Constructeurs
	public DALException() {
		super();
	}

	public DALException(String message) {
		super(message);
	}

	public DALException(String message, Throwable exception) {
		super(message, exception);
	}

	//Méthodes
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder("Couche DAL - ");
		sb.append(super.getMessage());

		return sb.toString() ;
	}


}
