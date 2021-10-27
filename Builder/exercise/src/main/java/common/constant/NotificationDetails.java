package common.constant;

public interface NotificationDetails {

    enum CREATION_TYPE implements NotificationDetails {

        FAST("Fast"),
        CUSTOM("Custom");

        private final String creationType;

        CREATION_TYPE(String creationType) {
            this.creationType = creationType;
        }

        public String getCreationType() {
            return creationType;
        }
    }

    interface FIELD extends NotificationDetails {

        enum COMMON implements FIELD {

            WALLET("Wallet"),
            NOTIFICATION_CREATION_TYPE("Notification creation type"),

            TRANSACTION_NUMBER("Transaction number"),
            TRANSACTION_NAME("Transaction name"),
            ISSUER_ID("Issuer id"),
            CARD_NAME("Card name"),
            TRANSACTION_SUM("Transaction sum"),
            TRANSACTION_DATE("Transaction date"),

            DEVICE_TYPE("Device type");

            private final String fieldName;

            COMMON(String fieldName) {
                this.fieldName = fieldName;
            }

            public String getFieldName() {
                return fieldName;
            }
        }

        enum ANDROID implements FIELD {

            DEVICE_VERSION("Device version");

            private final String fieldName;

            ANDROID(String fieldName) {
                this.fieldName = fieldName;
            }

            public String getFieldName() {
                return fieldName;
            }

        }

        enum APPLE implements FIELD {

            SECURITY("Security");

            private final String fieldName;

            APPLE(String fieldName) {
                this.fieldName = fieldName;
            }

            public String getFieldName() {
                return fieldName;
            }

        }

    }

}
