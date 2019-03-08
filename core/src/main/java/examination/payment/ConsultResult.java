package examination.payment;

public class ConsultResult {
    private boolean isEnabled;
    private String errorCode;

    public ConsultResult(boolean isEnabled, String errorCode){
        this.isEnabled = isEnabled;
        this.errorCode = errorCode;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
