package common.mapper;

import common.constant.CardName;
import common.constant.DeviceType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class InputMapperTest {

    InputMapper mapper = new InputMapper();

    @Test
    void shouldCorrectlyMapToCardName() {

        var input1 = "Visa";
        var input2 = "vIsA";
        var input3 = "masTer CARd";

        var result1 = mapper.mapToCardName(input1);
        var result2 = mapper.mapToCardName(input2);
        var result3 = mapper.mapToCardName(input3);

        assertEquals(CardName.VISA, result1);
        assertEquals(CardName.VISA, result2);
        assertEquals(CardName.MASTERCARD, result3);

    }

    @Test
    void shouldReturnNullTryingToMapToCardName() {

        var input = "sLaVe viSa";

        var result = mapper.mapToCardName(input);

        assertNull(result);

    }

    @Test
    void shouldCorrectlyMapToDeviceType() {

        var input1 = "ANDroiD";
        var input2 = "samSUNg";

        var result1 = mapper.mapToDeviceType(input1);
        var result2 = mapper.mapToDeviceType(input2);

        assertEquals(DeviceType.ANDROID, result1);
        assertEquals(DeviceType.SAMSUNG, result2);

    }

    @Test
    void shouldReturnNullTryingToMapToDeviceType() {

        var input = "ksiajomi";

        var result = mapper.mapToDeviceType(input);

        assertNull(result);

    }

    @Test
    void shouldCorrectlyMapToTransactionDate() {

        var input = "2021-01-02 01:02:03";
        var expected = LocalDateTime.of(2021, Month.of(1), 2, 1, 2, 3);

        var result = mapper.mapToTransactionDate(input);

        assertEquals(expected, result);

    }

    @Test
    void shouldFailTryingToMapToTransactionDate() {

        var input1 = "2021-01-02z01:02:03";
        var input2 = "2021-01-02";
        var input3 = "01:02:03";
        var input4 = "now";

        assertThrows(NumberFormatException.class, () -> mapper.mapToTransactionDate(input1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapper.mapToTransactionDate(input2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> mapper.mapToTransactionDate(input3));
        assertThrows(NumberFormatException.class, () -> mapper.mapToTransactionDate(input4));

    }

}
