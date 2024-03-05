package cost.estimation.app.error;

public class MaterialGradeDicAlreadyExistException extends Exception {
    public MaterialGradeDicAlreadyExistException() {
    }

    public MaterialGradeDicAlreadyExistException(String message) {
        super(message);
    }

    public MaterialGradeDicAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaterialGradeDicAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public MaterialGradeDicAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
