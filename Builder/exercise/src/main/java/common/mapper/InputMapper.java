package common.mapper;

import common.constant.CardName;
import common.constant.DeviceType;
import common.model.Issuer;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class InputMapper {

    public DeviceType mapToDeviceType(String deviceType) {
        return DeviceType.valueOf(deviceType.toUpperCase());
    }

    public LocalDateTime mapToTransactionDate(String transactionDate) {
        int[] dateTime = Arrays.stream(transactionDate.split("-|:|\\s|/|\\|T|t"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return LocalDateTime.of(dateTime[0], Month.of(dateTime[1]), dateTime[2], dateTime[3], dateTime[4], dateTime[5]);
    }


    public Issuer mapToIssuer(String issuerId, String issuerCardName) {
        return new Issuer(Integer.parseInt(issuerId), CardName.valueOf(issuerCardName.toUpperCase()));
    }


    public boolean mapToSecurity(String security) {
        return security.equalsIgnoreCase("true");
    }

    public long mapToTransactionSumOrNumber(String transaction) {
        return Long.parseLong(transaction);
    }

}
