package builder.concrete;

import builder.Builder;
import common.enums.CardName;
import common.model.Issuer;
import notification.AbstractNotification;

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

    @Override
    public void setIssuer(int id, CardName name) {
        this.issuer = new Issuer(id, name);
    }

}
