package chungnd.demo.exception;

public class CannotAuthenticateException extends RuntimeException{
    public CannotAuthenticateException(String actorName){
        super("The actor " + actorName + " does not have the ability to sign in to application");
    }
}
