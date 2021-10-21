package notification;

import common.enums.DeviceType;
import common.model.Issuer;

import java.time.LocalDateTime;

public class SamsungNotification extends AbstractNotification {

    private DeviceType deviceType;

    public SamsungNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum,
                               LocalDateTime transactionDate, DeviceType deviceType) {
        super(transactionNumber, transactionName, issuer, transactionSum, transactionDate);
        this.deviceType = deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "Samsung Notification {" +
                "Device Type = " + deviceType +
                "} " + super.toString();
    }
}