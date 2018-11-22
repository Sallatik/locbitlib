package sal.lat.locallib.api;

public class LocalBitcoinsException extends Exception {

    private int errorCode;

    public int getErrorCode(){ return errorCode; }

    LocalBitcoinsException(String message, int errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
