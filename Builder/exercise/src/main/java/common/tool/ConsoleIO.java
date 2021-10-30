package common.tool;

import common.constant.ConsoleMessage;
import common.mapper.PatternMapper;
import common.validator.PatternValidator;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ConsoleIO {

    private static Scanner scanner;

    private PatternValidator validator = new PatternValidator();

    public ConsoleIO() {
        scanner = getScanner();
    }

    public String scanUntil(String expected) {
        return scanUntil(expected, ConsoleMessage.INPUT_EXCEPTION.getMessage());
    }

    public String scanUntil(Set<String> expected) {
        return scanUntil(expected, ConsoleMessage.INPUT_EXCEPTION.getMessage());
    }

    public String scanUntilValid(String fieldName) {
        return scanUntilValid(fieldName, ConsoleMessage.INPUT_PATTERN_EXCEPTION + PatternMapper.mapToPattern(fieldName));
    }

    public String scanUntil(String expected, String failMessage) {
        String input;
        boolean isEqual;

        do {
            input = scanner.nextLine();
            isEqual = isEqualTo(input, expected);
            if (!isEqual) {
                printFailureMessage(failMessage);
            }
        } while (!isEqual);

        return input;
    }

    public String scanUntil(Set<String> expected, String failMessage) {
        String input;
        boolean isEqual;

        do {
            input = scanner.nextLine();
            isEqual = isEqualToOneOf(input, expected);
            if (!isEqual) {
                printFailureMessage(failMessage);
            }
        } while (!isEqual);

        return input;
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

    private boolean isEqualTo(String input, String expected) {
        return expected.equalsIgnoreCase(input);
    }

    private boolean isEqualToOneOf(String input, Set<String> expected) {
        return expected.stream().anyMatch((e) -> e.equalsIgnoreCase(input));
    }

    private Scanner getScanner() {
        return Objects.requireNonNullElseGet(scanner, () -> new Scanner(System.in));
    }

}
