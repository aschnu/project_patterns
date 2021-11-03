package common.tool;

import common.constant.ConsoleMessage;
import common.mapper.PatternMapper;
import common.validator.PatternValidator;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleIO {

    private static Scanner scanner;

    private final PatternValidator validator = new PatternValidator();

    public ConsoleIO() {
        scanner = getScanner();
    }

    public String scanUntilValid(String fieldName) {
        return scanUntilValid(fieldName, ConsoleMessage.INPUT_PATTERN_EXCEPTION + PatternMapper.mapToPattern(fieldName));
    }

    public String scanUntilValid(String fieldName, String failMessage) {
        String input;
        boolean isValid;

        do {
            input = scanner.nextLine();
            isValid = validator.isValid(fieldName, input);
            if (!isValid) {
                printFailureMessage(failMessage);
            }
        } while (!isValid);

        return input;
    }

    private void printFailureMessage(String message) {
        System.out.println(message);
    }

    private Scanner getScanner() {
        return Objects.requireNonNullElseGet(scanner, () -> new Scanner(System.in));
    }

}
