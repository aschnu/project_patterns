package builder.concrete;

import builder.Builder;
import common.model.Issuer;

import java.time.LocalDateTime;

public abstract class AbstractNotificationBuilder implements Builder {

    private long transactionNumber;
    private String transactionName;
    private Issuer issuer;
    private long transactionSum;
    private LocalDateTime transactionDate;

    @Override
    public void setTransactionNumber(long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    @Override
    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    @Override
    public void setTransactionSum(long transactionSum) {
        this.transactionSum = transactionSum;
    }

    @Override
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
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
}
