package common.validator;

import common.constant.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternValidatorTest {

    private final PatternValidator validator = new PatternValidator();

    @Test
    void shouldCorrectlyValidateInputForWallet() {
        var fieldName = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        var input1 = "Android";
        var input2 = "APPLE";
        var input3 = "samsung";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);

    }

    @Test
    void shouldIncorrectlyValidateInputForWallet() {
        var fieldName = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        var input1 = "ksiajomi";
        var input2 = "";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertFalse(result1);
        assertFalse(result2);

    }

    @Test
    void shouldCorrectlyValidateInputForTransactionDate() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName();
        var input1 = "2021-01-02 03:04:05";

        var result1 = validator.isValid(fieldName, input1);

        assertTrue(result1);

    }

    @Test
    void shouldIncorrectlyValidateInputForTransactionDate() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName();
        var input1 = "2021-01-02z03:04:05";
        var input2 = "2021-01-02T03:04:05";
        var input3 = "2021-01-02";
        var input4 = "03:04:05";
        var input5 = "2021-01-02 25:04:05";
        var input6 = "2021-13-02 03:04:05";
        var input7 = "2021-02-30 03:04:05";
        var input8 = "2021-01-02 03:60:05";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);
        var result4 = validator.isValid(fieldName, input4);
        var result5 = validator.isValid(fieldName, input5);
        var result6 = validator.isValid(fieldName, input6);
        var result7 = validator.isValid(fieldName, input7);
        var result8 = validator.isValid(fieldName, input8);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
        assertFalse(result6);
        assertFalse(result7);
        assertFalse(result8);

    }

    @Test
    void shouldCorrectlyValidateInputForDeviceType() {
        var fieldName = NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName();
        var input1 = "Android";
        var input2 = "samsung";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertTrue(result1);
        assertTrue(result2);

    }

    @Test
    void shouldIncorrectlyValidateInputForDeviceType() {
        var fieldName = NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName();
        var input1 = "ksiajomi";
        var input2 = "";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertFalse(result1);
        assertFalse(result2);

    }

    @Test
    void shouldCorrectlyValidateInputForIssuerId() {
        var fieldName = NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName();
        var input1 = "";
        var input2 = "0";
        var input3 = "9";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);

    }

    @Test
    void shouldIncorrectlyValidateInputForIssuerId() {
        var fieldName = NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName();
        var input1 = "10";
        var input2 = "-1";
        var input3 = "a";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);

    }

    @Test
    void shouldCorrectlyValidateInputForDeviceVersion() {
        var fieldName = NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName();
        var input1 = ".";
        var input2 = "a.";
        var input3 = ".1";
        var input4 = "1.0";
        var input5 = "a1c3e.1234";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);
        var result4 = validator.isValid(fieldName, input4);
        var result5 = validator.isValid(fieldName, input5);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertTrue(result5);

    }

    @Test
    void shouldIncorrectlyValidateInputForDeviceVersion() {
        var fieldName = NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName();
        var input1 = "";
        var input2 = ",,";
        var input3 = ".a";
        var input4 = "123456.";
        var input5 = ".12345";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);
        var result4 = validator.isValid(fieldName, input4);
        var result5 = validator.isValid(fieldName, input5);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);

    }

    @Test
    void shouldCorrectlyValidateInputForTransactionName() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName();
        var input1 = "";
        var input2 = "CustomName123";
        var input3 = "01234567890123456789012345678901234";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);

    }

    @Test
    void shouldIncorrectlyValidateInputForTransactionName() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName();
        var input1 = ",";
        var input2 = "012345678901234567890123456789012345";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertFalse(result1);
        assertFalse(result2);

    }

    @Test
    void shouldCorrectlyValidateInputForSecurity() {
        var fieldName = NotificationDetails.FIELD.APPLE.SECURITY.getFieldName();
        var input1 = "true";
        var input2 = "TRUE";
        var input3 = "TruE";
        var input4 = "false";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);
        var result4 = validator.isValid(fieldName, input4);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);

    }

    @Test
    void shouldIncorrectlyValidateInputForSecurity() {
        var fieldName = NotificationDetails.FIELD.APPLE.SECURITY.getFieldName();
        var input1 = "";
        var input2 = "!true";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertFalse(result1);
        assertFalse(result2);

    }

    @Test
    void shouldCorrectlyValidateInputForTransactionSum() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName();
        var input1 = "";
        var input2 = "0";
        var input3 = "1234567890";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);

    }

    @Test
    void shouldIncorrectlyValidateInputForTransactionSum() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName();
        var input1 = "a";
        var input2 = "-1";
        var input3 = "12345678901";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);

    }

    @Test
    void shouldCorrectlyValidateInputForTransactionNumber() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName();
        var input1 = "";
        var input2 = "0";
        var input3 = "1234567890";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);

    }

    @Test
    void shouldIncorrectlyValidateInputForTransactionNumber() {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName();
        var input1 = "a";
        var input2 = "-1";
        var input3 = "12345678901";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);
        var result3 = validator.isValid(fieldName, input3);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);

    }

    @Test
    void shouldCorrectlyValidateInputForNotificationCreationType() {
        var fieldName = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();
        var input1 = "fast";
        var input2 = "CUSTOM";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertTrue(result1);
        assertTrue(result2);

    }

    @Test
    void shouldIncorrectlyValidateInputForNotificationCreationType() {
        var fieldName = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();
        var input1 = "ksiajomi";
        var input2 = "";

        var result1 = validator.isValid(fieldName, input1);
        var result2 = validator.isValid(fieldName, input2);

        assertFalse(result1);
        assertFalse(result2);

    }

    @Test
    void shouldNotFindPatternForValidation() {
        var fieldName = "ksiajomi";

        var result1 = validator.isValid(fieldName, fieldName);

        assertFalse(result1);
    }

}
