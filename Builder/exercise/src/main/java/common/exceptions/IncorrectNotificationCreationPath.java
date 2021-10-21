package common.exceptions;

public class IncorrectNotificationCreationPath extends RuntimeException {

    private static final String ERROR_MESSAGE = "Incorrect notification creation path: ";

    public IncorrectNotificationCreationPath(String errorMessage, Throwable err) {
        super(ERROR_MESSAGE + errorMessage, err);
    }

    public IncorrectNotificationCreationPath(String errorMessage) {
        super(ERROR_MESSAGE + errorMessage);
    }

    public IncorrectNotificationCreationPath() {
        super();
    }

}
