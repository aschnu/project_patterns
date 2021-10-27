package builder.concrete;

import builder.Builder;
import common.constant.DeviceType;
import common.model.Issuer;
import notification.SamsungNotification;

import java.time.LocalDateTime;

public class SamsungNotificationBuilder extends AbstractNotificationBuilder implements Builder {

    private DeviceType deviceType;

    public SamsungNotification generateNotification(long transactionNumber, String transactionName, Issuer issuer,
                                                    long transactionSum, LocalDateTime transactionDate,
                                                    DeviceType deviceType) {
        return new SamsungNotification(transactionNumber, transactionName, issuer, transactionSum, transactionDate,
                deviceType);
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
