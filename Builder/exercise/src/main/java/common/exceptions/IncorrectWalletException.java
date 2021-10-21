package common.exceptions;

public class IncorrectWalletException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Unknown wallet: ";

    public IncorrectWalletException(String errorMessage, Throwable err) {
        super(ERROR_MESSAGE + errorMessage, err);
    }

    public IncorrectWalletException(String errorMessage) {
        super(ERROR_MESSAGE + errorMessage);
    }

    public IncorrectWalletException() {
        super();
    }
}
