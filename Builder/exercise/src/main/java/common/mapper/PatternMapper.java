package common.mapper;

import common.constant.CardName;
import common.constant.DeviceType;
import common.constant.LocalPattern;
import common.constant.NotificationDetails;

import java.util.Arrays;

public class PatternMapper {

    public static String mapToPattern(String fieldName) {

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName())) {
            return LocalPattern.TRANSACTION_DATETIME.getPattern();
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName())) {
            return Arrays.toString(DeviceType.values());
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName())) {
            return LocalPattern.ISSUER_ID.getPattern();
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())) {
            return Arrays.toString(CardName.values());
        }

        if (fieldName.equals(NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName())) {
            return LocalPattern.DEVICE_VERSION.getPattern();
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName())) {
            return LocalPattern.TRANSACTION_NAME.getPattern();
        }

        if (fieldName.equals(NotificationDetails.FIELD.APPLE.SECURITY.getFieldName())) {
            return LocalPattern.SECURITY.getPattern();
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())) {
            return LocalPattern.TRANSACTION_SUM.getPattern();
        }

        if (fieldName.equals(NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName())) {
            return LocalPattern.TRANSACTION_NUMBER.getPattern();
        }

        return null;

    }

}
