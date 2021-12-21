package fr.eni.papeterie.exception;

public class BLLException extends Exception {
  // Constructeurs
  public BLLException() {
    super();
  }

  public BLLException(String message) {
    super(message);
  }

  public BLLException(String message, Throwable exception) {
    super(message, exception);
  }

  // Méthodes
  @Override
  public String getMessage() {
    StringBuilder sb = new StringBuilder("Couche DAL - ");
    sb.append(super.getMessage());

    return sb.toString();
  }

}
