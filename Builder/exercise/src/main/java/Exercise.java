import common.constant.ConsoleMessage;
import common.constant.NotificationDetails;
import common.constant.Wallet;
import common.tool.ConsoleIO;

import java.util.HashMap;
import java.util.Map;

public class Exercise {

    public static void main(String[] args) {

        Exercise exercise = new Exercise();
        ConsoleIO console = new ConsoleIO();
        Map<String, String> notificationData = new HashMap<>();

        System.out.println(ConsoleMessage.WELCOME.getMessage());

        exercise.inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.WALLET.getFieldName(), ConsoleMessage.INPUT_WALLET.getMessage());
        exercise.inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName(), ConsoleMessage.INPUT_CREATION_PATH.getMessage());
        exercise.followWalletPath(console, notificationData);

        System.out.println(notificationData);

    }

    private void followWalletPath(ConsoleIO console, Map<String, String> notificationData) {
        var walletFiledName = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        var fastCreationType = NotificationDetails.CREATION_TYPE.FAST.getCreationType();
        var customCreationType = NotificationDetails.CREATION_TYPE.CUSTOM.getCreationType();
        var creationTypeFieldName = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();

        if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                chooseCommonFields(console, notificationData);
                inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName(), ConsoleMessage.INPUT_DEVICE_TYPE.getMessage());
                inputFiledValue(console, notificationData, NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName(), ConsoleMessage.INPUT_DEVICE_VERSION.getMessage());
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {

            } else {

            }
        } else if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                chooseCommonFields(console, notificationData);
                inputFiledValue(console, notificationData, NotificationDetails.FIELD.APPLE.SECURITY.getFieldName(), ConsoleMessage.INPUT_SECURITY.getMessage());
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {

            } else {

            }
        } else if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                chooseCommonFields(console, notificationData);
                inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName(), ConsoleMessage.INPUT_DEVICE_TYPE.getMessage());
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {

            } else {

            }
        }
    }

    private void chooseCommonFields(ConsoleIO console, Map<String, String> notificationData) {
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName(), ConsoleMessage.INPUT_ISSUER_ID.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName(), ConsoleMessage.INPUT_CARD_NAME.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_NAME.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_NUMBER.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_SUM.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_DATE.getMessage());
    }

    private void inputFiledValue(ConsoleIO console, Map<String, String> notificationData, String fieldName, String message) {
        System.out.println(message);

        var creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }


}
