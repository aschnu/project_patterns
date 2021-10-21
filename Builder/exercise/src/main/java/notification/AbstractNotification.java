package notification;

import common.model.Issuer;

import java.time.LocalDateTime;

abstract public class AbstractNotification {

    private long transactionNumber;
    private String transactionName;
    private Issuer issuer;
    private long transactionSum;
    private LocalDateTime transactionDate;

    public AbstractNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum, LocalDateTime transactionDate) {
        this.transactionNumber = transactionNumber;
        this.transactionName = transactionName;
        this.issuer = issuer;
        this.transactionSum = transactionSum;
        this.transactionDate = transactionDate;
    }

    public long getTransactionNumber() {
        return transactionNumber;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public long getTransactionSum() {
        return transactionSum;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
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
