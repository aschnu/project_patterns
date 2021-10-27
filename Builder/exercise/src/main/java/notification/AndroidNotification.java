package notification;

import common.constant.DeviceType;
import common.model.Issuer;

import java.time.LocalDateTime;

public class AndroidNotification extends AbstractNotification {

    private DeviceType deviceType;
    private String deviceVersion;

    public AndroidNotification(long transactionNumber, String transactionName, Issuer issuer, long transactionSum,
                               LocalDateTime transactionDate, DeviceType deviceType, String deviceVersion) {
        super(transactionNumber, transactionName, issuer, transactionSum, transactionDate);
        this.deviceType = deviceType;
        this.deviceVersion = deviceVersion;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    @Override
    public String toString() {
        return "Android Notification {" +
                "Device Type = " + deviceType +
                ", Device Version = '" + deviceVersion + '\'' +
                "} " + super.toString();
    }
}
