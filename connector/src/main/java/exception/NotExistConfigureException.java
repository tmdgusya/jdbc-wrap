package exception;

public class NotExistConfigureException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Check Your Configuration Files";

    public NotExistConfigureException() {
        super(ERROR_MESSAGE);
    }
}
