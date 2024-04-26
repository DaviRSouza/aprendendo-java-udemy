package exceptions2.model.exception;

public class ExceededLimit extends RuntimeException{

    public ExceededLimit(String msg){
        super(msg);
    }
}
