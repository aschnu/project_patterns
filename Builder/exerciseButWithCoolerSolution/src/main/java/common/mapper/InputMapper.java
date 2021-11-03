package common.mapper;

import common.constant.CardName;
import common.constant.DeviceType;
import common.model.Issuer;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Optional;

public class InputMapper {

    public CardName mapToCardName(String cardName) {
        Optional<CardName> optionalCardName = Arrays.stream(CardName.values())
                .filter(c -> c.getCardName().equalsIgnoreCase(cardName))
                .findFirst();

        return optionalCardName.orElse(null);
    }

    public DeviceType mapToDeviceType(String deviceType) {

        Optional<DeviceType> optionalDeviceType = Arrays.stream(DeviceType.values())
                .filter(d -> d.getDeviceType().equalsIgnoreCase(deviceType))
                .findFirst();

        return optionalDeviceType.orElse(null);
    }

    public LocalDateTime mapToTransactionDate(String transactionDate) {
        int[] dateTime = Arrays.stream(transactionDate.split("-|:|\\s|/|\\|T|t"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return LocalDateTime.of(dateTime[0], Month.of(dateTime[1]), dateTime[2], dateTime[3], dateTime[4], dateTime[5]);
    }


    public Issuer mapToIssuer(String issuerId, String issuerCardName) {
        CardName cardName = mapToCardName(issuerCardName);

        return new Issuer(Integer.parseInt(issuerId), cardName);
    }


    public boolean mapToSecurity(String security) {
        return security.equalsIgnoreCase("true");
    }

    public long mapToTransactionSumOrNumber(String transaction) {
        return Long.parseLong(transaction);
    }

}
