package notification;

import common.constant.CardName;
import common.model.Issuer;
import common.tool.PseudoRandomGenerator;

import java.time.LocalDateTime;

public class AppleNotification extends AbstractNotification {

    private boolean security;

    private AppleNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum,
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

    public static final class AppleNotificationBuilder {
        private long transactionNumber;
        private String transactionName;
        private Issuer issuer;
        private long transactionSum;
        private LocalDateTime transactionDate;
        private boolean security;

        private AppleNotificationBuilder() {
        }

        public static AppleNotificationBuilder anAppleNotification() {
            return new AppleNotificationBuilder();
        }

        public AppleNotification.AppleNotificationBuilder withCommonValues(long sum, CardName cardName) {
            this.transactionNumber = PseudoRandomGenerator.generateRandomLong();
            this.transactionName = generateTransactionName(cardName, sum);
            this.issuer = Issuer.generateIssuerFromCardName(cardName);
            this.transactionSum = sum;
            this.transactionDate = LocalDateTime.now();
            return this;
        }

        public AppleNotificationBuilder withTransactionNumber(long transactionNumber) {
            this.transactionNumber = transactionNumber;
            return this;
        }

        public AppleNotificationBuilder withTransactionName(String transactionName) {
            this.transactionName = transactionName;
            return this;
        }

        public AppleNotificationBuilder withIssuer(Issuer issuer) {
            this.issuer = issuer;
            return this;
        }

        public AppleNotificationBuilder withTransactionSum(long transactionSum) {
            this.transactionSum = transactionSum;
            return this;
        }

        public AppleNotificationBuilder withTransactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public AppleNotificationBuilder withSecurity(boolean security) {
            this.security = security;
            return this;
        }

        public AppleNotification build() {
            return new AppleNotification(transactionNumber, transactionName, issuer, transactionSum, transactionDate, security);
        }

    }
}
