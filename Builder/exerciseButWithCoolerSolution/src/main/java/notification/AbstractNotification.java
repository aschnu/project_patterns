package notification;

import common.constant.CardName;
import common.model.Issuer;

import java.time.LocalDateTime;

public abstract class AbstractNotification {

    private long transactionNumber;
    private String transactionName;
    private Issuer issuer;
    private long transactionSum;
    private LocalDateTime transactionDate;

    public Issuer getIssuer() {
        return issuer;
    }

    protected AbstractNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum, LocalDateTime transactionDate) {
        this.transactionNumber = transactionNumber;
        this.transactionName = transactionName;
        this.issuer = issuer;
        this.transactionSum = transactionSum;
        this.transactionDate = transactionDate;
    }

    protected static String generateTransactionName(CardName cardName, long sum) {
        return "Recorded payment with " + cardName.getCardName() + " for amount: " + sum;
    }

    @Override
    public String toString() {
        return "Notification {" +
                "Transaction Number = " + transactionNumber +
                ", Transaction Name = '" + transactionName + '\'' +
                ", Issuer id = " + issuer.getId() +
                ", Issuer card = " + issuer.getName() +
                ", transactionSum = " + transactionSum +
                ", transactionDate = " + transactionDate +
                '}';
    }

}
