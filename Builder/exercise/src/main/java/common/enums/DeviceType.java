package common.enums;

public enum DeviceType {

    ANDROID("Android"),
    SAMSUNG("Samsung");

    String deviceType;

    DeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }
}
