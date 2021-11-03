package notification;

import common.model.Issuer;

import java.time.LocalDateTime;

public class AppleNotification extends AbstractNotification {

    private boolean security;

    public AppleNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum,
                             LocalDateTime transactionDate, boolean security) {
        super(transactionNumber, transactionName, issuer, transactionSum, transactionDate);
        this.security = security;
    }

    @Override
    public String toString() {
        return "Apple Notification {" +
                "Security = " + security +
                "} " + super.toString();
    }

}
