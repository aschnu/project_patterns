package notification;

import common.constant.CardName;
import common.constant.DeviceType;
import common.model.Issuer;
import common.tool.PseudoRandomGenerator;

import java.time.LocalDateTime;

public class AndroidNotification extends AbstractNotification {

    private DeviceType deviceType;
    private String deviceVersion;

    private AndroidNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum,
                                LocalDateTime transactionDate, DeviceType deviceType, String deviceVersion) {
        super(transactionNumber, transactionName, issuer, transactionSum, transactionDate);
        this.deviceType = deviceType;
        this.deviceVersion = deviceVersion;
    }

    @Override
    public String toString() {
        return "Android Notification {" +
                "Device Type = " + deviceType +
                ", Device Version = '" + deviceVersion + '\'' +
                "} " + super.toString();
    }

    public static final class AndroidNotificationBuilder {
        private long transactionNumber;
        private String transactionName;
        private Issuer issuer;
        private long transactionSum;
        private LocalDateTime transactionDate;
        private DeviceType deviceType;
        private String deviceVersion;

        private AndroidNotificationBuilder() {
        }

        public static AndroidNotificationBuilder anAndroidNotification() {
            return new AndroidNotificationBuilder();
        }

        public AndroidNotificationBuilder withCommonValues(long sum, CardName cardName) {
            this.transactionNumber = PseudoRandomGenerator.generateRandomLong();
            this.transactionName = generateTransactionName(cardName, sum);
            this.issuer = Issuer.generateIssuerFromCardName(cardName);
            this.transactionSum = sum;
            this.transactionDate = LocalDateTime.now();
            return this;
        }

        public AndroidNotificationBuilder withTransactionNumber(long transactionNumber) {
            this.transactionNumber = transactionNumber;
            return this;
        }

        public AndroidNotificationBuilder withTransactionName(String transactionName) {
            this.transactionName = transactionName;
            return this;
        }

        public AndroidNotificationBuilder withIssuer(Issuer issuer) {
            this.issuer = issuer;
            return this;
        }

        public AndroidNotificationBuilder withTransactionSum(long transactionSum) {
            this.transactionSum = transactionSum;
            return this;
        }

        public AndroidNotificationBuilder withTransactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public AndroidNotificationBuilder withDeviceType(DeviceType deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public AndroidNotificationBuilder withDeviceVersion(String deviceVersion) {
            this.deviceVersion = deviceVersion;
            return this;
        }

        public AndroidNotification build() {
            return new AndroidNotification(transactionNumber, transactionName, issuer, transactionSum, transactionDate, deviceType, deviceVersion);
        }

    }
}
