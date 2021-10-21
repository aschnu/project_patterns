package common.exceptions;

public class IncorrectPatternException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Field value should match regex pattern: ";

    public IncorrectPatternException(String errorMessage, Throwable err) {
        super(ERROR_MESSAGE + errorMessage, err);
    }

    public IncorrectPatternException(String errorMessage) {
        super(ERROR_MESSAGE + errorMessage);
    }

    public IncorrectPatternException() {
        super();
    }
}
