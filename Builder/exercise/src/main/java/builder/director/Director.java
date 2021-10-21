package builder.director;

import builder.Builder;
import common.enums.CardName;
import common.tool.PseudoRandomGenerator;

import java.time.LocalDateTime;

public class Director {

    public void constructDefaultVisaNotification(Builder builder, long sum) {
        builder.setTransactionNumber(PseudoRandomGenerator.generateRandomLong());
        builder.setTransactionName(generateTransactionName(CardName.VISA, sum));
        builder.setIssuer(1, CardName.VISA);
        builder.setTransactionSum(sum);
        builder.setTransactionDate(LocalDateTime.now());
    }

    public void constructDefaultMasterCardNotification(Builder builder, long sum) {
        builder.setTransactionNumber(PseudoRandomGenerator.generateRandomLong());
        builder.setTransactionName(generateTransactionName(CardName.MASTERCARD, sum));
        builder.setIssuer(2, CardName.MASTERCARD);
        builder.setTransactionSum(sum);
        builder.setTransactionDate(LocalDateTime.now());
    }

    private String generateTransactionName(CardName cardName, long sum) {
        return "Recorded payment with " + cardName.getCardName() + " for amount: " + sum;
    }

}
