package builder.director;

import builder.Builder;
import common.constant.CardName;
import common.model.Issuer;
import common.tool.PseudoRandomGenerator;

import java.time.LocalDateTime;

public class Director {

    public void constructDefaultNotification(Builder builder, long sum, CardName cardName) {
        builder.setTransactionNumber(PseudoRandomGenerator.generateRandomLong());
        builder.setTransactionName(generateTransactionName(cardName, sum));
        builder.setIssuer(generateIssuerFromCardName(cardName));
        builder.setTransactionSum(sum);
        builder.setTransactionDate(LocalDateTime.now());
    }

    private Issuer generateIssuerFromCardName(CardName card) {
        return switch (card) {
            case VISA -> new Issuer(1, CardName.VISA);
            case MASTERCARD -> new Issuer(2, CardName.MASTERCARD);
        };
    }

    private String generateTransactionName(CardName cardName, long sum) {
        return "Recorded payment with " + cardName.getCardName() + " for amount: " + sum;
    }

}
