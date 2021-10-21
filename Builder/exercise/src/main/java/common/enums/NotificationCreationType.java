package common.enums;

public enum NotificationCreationType {

    FAST("Fast"),
    CUSTOM("Custom");

    private String creationType;

    NotificationCreationType(String creationType) {
        this.creationType = creationType;
    }

    public String getCreationType() {
        return creationType;
    }
}
