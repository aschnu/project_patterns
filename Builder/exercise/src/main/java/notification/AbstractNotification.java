package notification;

import common.model.Issuer;

import java.time.LocalDateTime;

public abstract class AbstractNotification {

    private final long transactionNumber;
    private final String transactionName;
    private final Issuer issuer;
    private final long transactionSum;
    private final LocalDateTime transactionDate;

    public AbstractNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum, LocalDateTime transactionDate) {
        this.transactionNumber = transactionNumber;
        this.transactionName = transactionName;
        this.issuer = issuer;
        this.transactionSum = transactionSum;
        this.transactionDate = transactionDate;
    }

    public Issuer getIssuer() {
        return issuer;
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
