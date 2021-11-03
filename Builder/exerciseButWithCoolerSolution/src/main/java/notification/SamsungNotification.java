package notification;

import common.constant.CardName;
import common.constant.DeviceType;
import common.model.Issuer;
import common.tool.PseudoRandomGenerator;

import java.time.LocalDateTime;

public class SamsungNotification extends AbstractNotification {

    private DeviceType deviceType;

    private SamsungNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum,
                               LocalDateTime transactionDate, DeviceType deviceType) {
        super(transactionNumber, transactionName, issuer, transactionSum, transactionDate);
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "Samsung Notification {" +
                "Device Type = " + deviceType +
                "} " + super.toString();
    }

    public static final class SamsungNotificationBuilder {
        private long transactionNumber;
        private String transactionName;
        private Issuer issuer;
        private long transactionSum;
        private LocalDateTime transactionDate;
        private DeviceType deviceType;

        private SamsungNotificationBuilder() {
        }

        public static SamsungNotificationBuilder aSamsungNotification() {
            return new SamsungNotificationBuilder();
        }

        public SamsungNotification.SamsungNotificationBuilder withCommonValues(long sum, CardName cardName) {
            this.transactionNumber = PseudoRandomGenerator.generateRandomLong();
            this.transactionName = generateTransactionName(cardName, sum);
            this.issuer = Issuer.generateIssuerFromCardName(cardName);
            this.transactionSum = sum;
            this.transactionDate = LocalDateTime.now();
            return this;
        }

        public SamsungNotificationBuilder withTransactionNumber(long transactionNumber) {
            this.transactionNumber = transactionNumber;
            return this;
        }

        public SamsungNotificationBuilder withTransactionName(String transactionName) {
            this.transactionName = transactionName;
            return this;
        }

        public SamsungNotificationBuilder withIssuer(Issuer issuer) {
            this.issuer = issuer;
            return this;
        }

        public SamsungNotificationBuilder withTransactionSum(long transactionSum) {
            this.transactionSum = transactionSum;
            return this;
        }

        public SamsungNotificationBuilder withTransactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public SamsungNotificationBuilder withDeviceType(DeviceType deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public SamsungNotification build() {
            return new SamsungNotification(transactionNumber, transactionName, issuer, transactionSum, transactionDate, deviceType);
        }
    }
}
