package fr.afpa.papeterie.dal;

public class DALException extends Exception
{
  
	private static final long serialVersionUID = 1L;

	public DALException() {
    }
    
    public DALException(final String message) {
        super(message);
    }
    
    public DALException(final String message, final Throwable exception) {
        super(message, exception);
    }
    
    @Override
    public String getMessage() {
        final StringBuffer sb = new StringBuffer("Couche DAL - ");
        sb.append(super.getMessage());
        return sb.toString();
    }
}