package common.validator;

import common.enums.CardName;
import common.enums.DeviceType;
import common.enums.LocalPattern;
import common.exceptions.IncorrectPatternException;
import common.model.Issuer;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.regex.Pattern;

public class PatternValidator {


    public LocalDateTime validateTransactionDate(String transactionDate) {

        isValidPattern(transactionDate, LocalPattern.TRANSACTION_DATETIME);

        int[] dateTime = Arrays.stream(transactionDate.split("-|:|\\s|/|\\|T|t"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return LocalDateTime.of(dateTime[0], Month.of(dateTime[1]), dateTime[2], dateTime[3], dateTime[4], dateTime[5]);
    }

    public DeviceType validateDeviceType(String deviceType) {

        return DeviceType.valueOf(deviceType);
    }

    public Issuer validateIssuer(String issuerId, String issuerCardName) {

        isValidPattern(issuerId, LocalPattern.ISSUER_ID);
        return new Issuer(Integer.parseInt(issuerId), CardName.valueOf(issuerCardName));
    }

    public String validateDeviceVersion(String deviceVersion) {

        isValidPattern(deviceVersion, LocalPattern.DEVICE_VERSION);
        return deviceVersion;
    }

    public String validateTransactionName(String transactionName) {

        isValidPattern(transactionName, LocalPattern.TRANSACTION_NAME);
        return transactionName;
    }

    public boolean validateSecurity(String security) {

        if (security.toLowerCase().equals("true")) {
            return true;
        } else if(security.toLowerCase().equals("false")) {
            return false;
        } else {
            throw new IncorrectPatternException("true|false");
        }

    }

    public long validateTransactionSum(String transactionSum) {

        isValidPattern(transactionSum, LocalPattern.TRANSACTION_SUM);
        return Long.parseLong(transactionSum);
    }

    public long validateTransactionNumber(String transactionNumber) {

        isValidPattern(transactionNumber, LocalPattern.TRANSACTION_NUMBER);
        return Long.parseLong(transactionNumber);
    }

    private void isValidPattern(String input, @NotNull LocalPattern pattern) {

        var isValid = Pattern.matches(pattern.getPattern(), input);

        if(!isValid) {
            throw new IncorrectPatternException(pattern.toString());
        }
    }

}
