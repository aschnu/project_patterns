package builder.concrete;

import builder.Builder;
import common.model.Issuer;
import notification.AppleNotification;

import java.time.LocalDateTime;

public class AppleNotificationBuilder extends AbstractNotificationBuilder implements Builder {

    private boolean security;

    public AppleNotification generateNotification(long transactionNumber, String transactionName, Issuer issuer,
                                                  long transactionSum, LocalDateTime transactionDate,
                                                  boolean security) {
        return new AppleNotification(transactionNumber, transactionName, issuer, transactionSum, transactionDate,
                security);
    }

    public AppleNotification generateNotification() {
        return new AppleNotification(getTransactionNumber(), getTransactionName(), getIssuer(), getTransactionSum(),
                getTransactionDate(), security);
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }
}
