package exceptions2.model.exception;

public class UnavailableBalance extends RuntimeException{

    public UnavailableBalance(String msg)  {
        super(msg);
    }
}
