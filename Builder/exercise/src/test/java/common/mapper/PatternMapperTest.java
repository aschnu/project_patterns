package common.mapper;

import common.constant.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class PatternMapperTest {

    @Test
    void shouldMapToNotificationCreationTypePattern() {

        var input = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();
        var expected = Arrays.toString(NotificationDetails.FIELD.CREATION_TYPE.values());

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToWalletPattern() {

        var input = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        var expected = Arrays.toString(Wallet.values());

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToTransactionDatePattern() {

        var input = NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName();
        var expected = LocalPattern.TRANSACTION_DATETIME.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToDeviceTypePattern() {

        var input = NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName();
        var expected = Arrays.toString(DeviceType.values());

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToIssuerIdPattern() {

        var input = NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName();
        var expected = LocalPattern.ISSUER_ID.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToCardNamePattern() {

        var input = NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName();
        var expected = Arrays.toString(CardName.values());

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToDeviceVersionPattern() {

        var input = NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName();
        var expected = LocalPattern.DEVICE_VERSION.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToTransactionNamePattern() {

        var input = NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName();
        var expected = LocalPattern.TRANSACTION_NAME.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToSecurityPattern() {

        var input = NotificationDetails.FIELD.APPLE.SECURITY.getFieldName();
        var expected = LocalPattern.SECURITY.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToTransactionSumPattern() {

        var input = NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName();
        var expected = LocalPattern.TRANSACTION_SUM.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldMapToTransactionNumberPattern() {

        var input = NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName();
        var expected = LocalPattern.TRANSACTION_NUMBER.getPattern();

        var result = PatternMapper.mapToPattern(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldFailToMapToPattern() {

        var input1 = NotificationDetails.FIELD.COMMON.WALLET.getFieldName().toUpperCase();
        var input2 = NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName().toLowerCase();
        var input3 = "none";

        var result1 = PatternMapper.mapToPattern(input1);
        var result2 = PatternMapper.mapToPattern(input2);
        var result3 = PatternMapper.mapToPattern(input3);

        assertNull(result1);
        assertNull(result2);
        assertNull(result3);

    }

}
