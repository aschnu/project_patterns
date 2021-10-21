package builder.concrete;

import builder.Builder;
import common.enums.DeviceType;
import common.model.Issuer;
import notification.AndroidNotification;

import java.time.LocalDateTime;

public class AndroidNotificationBuilder extends AbstractNotificationBuilder implements Builder {

    private DeviceType deviceType;
    private String deviceVersion;

    public AndroidNotification generateNotification(long transactionNumber, String transactionName, Issuer issuer,
                                                    long transactionSum, LocalDateTime transactionDate,
                                                    DeviceType deviceType, String deviceVersion) {
        return new AndroidNotification(transactionNumber, transactionName, issuer, transactionSum, transactionDate,
                deviceType, deviceVersion);
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

}
