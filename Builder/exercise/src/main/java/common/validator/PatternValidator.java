package common.validator;

import common.constant.CardName;
import common.constant.DeviceType;
import common.constant.LocalPattern;
import common.constant.NotificationDetails;

import java.util.Arrays;
import java.util.regex.Pattern;

public class PatternValidator {

    public boolean isValid(String fieldName, String input) {
        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName())) {
            return isValidPattern(input, LocalPattern.TRANSACTION_DATETIME);
        }
//TODO: possible bug - investigate
        if (fieldName.equals(NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName())) {
            return Arrays.stream(DeviceType.values()).anyMatch((t) -> t.getDeviceType().equalsIgnoreCase(input));
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName())) {
            return isValidPattern(input, LocalPattern.ISSUER_ID);
        }
//TODO: possible bug - investigate
        if (fieldName.equals(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())) {
            return Arrays.stream(CardName.values()).anyMatch((t) -> t.getCardName().equalsIgnoreCase(input));
        }

        if (fieldName.equals(NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName())) {
            return isValidPattern(input, LocalPattern.DEVICE_VERSION);
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName())) {
            return isValidPattern(input, LocalPattern.TRANSACTION_NAME);
        }

        if (fieldName.equals(NotificationDetails.FIELD.APPLE.SECURITY.getFieldName())) {
            return isValidPattern(input, LocalPattern.SECURITY);
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())) {
            return isValidPattern(input, LocalPattern.TRANSACTION_SUM);
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName())) {
            return isValidPattern(input, LocalPattern.TRANSACTION_NUMBER);
        }
//TODO: possible bug - investigate
        if (fieldName.equals(NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName())) {
            return Arrays.stream(CardName.values()).anyMatch((t) -> t.getCardName().equalsIgnoreCase(input));
        }

        return false;
    }

    private boolean isValidPattern(String input, LocalPattern pattern) {
        return Pattern.matches(pattern.getPattern(), input);
    }

}
