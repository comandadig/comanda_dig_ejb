package exception;






public class ComandaException extends Exception {

	
	private static final long serialVersionUID = -7704947879239486816L;

   
    public ComandaException(String msg){
        super(msg);
    }

    public ComandaException(String msg, Throwable cause){
        super(msg, cause);
    }
	
}
