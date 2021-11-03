import builder.concrete.AndroidNotificationBuilder;
import builder.concrete.AppleNotificationBuilder;
import builder.concrete.SamsungNotificationBuilder;
import builder.director.Director;
import common.constant.*;
import common.mapper.InputMapper;
import common.tool.ConsoleIO;
import notification.AbstractNotification;

import java.util.HashMap;
import java.util.Map;

public class Exercise {

    public static void main(String[] args) {

        Exercise exercise = new Exercise();
        ConsoleIO console = new ConsoleIO();
        Map<String, String> notificationData = new HashMap<>();
        AbstractNotification notification;

        System.out.println(ConsoleMessage.WELCOME.getMessage());

        exercise.inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.WALLET.getFieldName(), ConsoleMessage.INPUT_WALLET.getMessage());
        exercise.inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName(), ConsoleMessage.INPUT_CREATION_PATH.getMessage());
        exercise.inputRequiredFields(console, notificationData);

        System.out.println("Notification data: " + notificationData);

        notification = exercise.buildNotification(notificationData);

        System.out.println("Built notification: " + notification);

    }

    private AbstractNotification buildNotification(Map<String, String> notificationData) {
        if (notificationData.get(NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName())
                .equalsIgnoreCase(NotificationDetails.CREATION_TYPE.FAST.getCreationType())) {
            return buildFastNotificationFromInput(notificationData);
        } else {
            return buildCustomNotificationFromInput(notificationData);
        }
    }

    private AbstractNotification buildFastNotificationFromInput(Map<String, String> notificationData) {
        InputMapper inputMapper = new InputMapper();
        Director director = new Director();

        if (notificationData.get(NotificationDetails.FIELD.COMMON.WALLET.getFieldName()).equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            AndroidNotificationBuilder builder = new AndroidNotificationBuilder();

            director.constructDefaultNotification(builder,
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())),
                    inputMapper.mapToCardName(notificationData.get(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())));

            builder.setDeviceType(inputMapper.mapToDeviceType(notificationData.get(NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName())));
            builder.setDeviceVersion(notificationData.get(NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName()));

            return builder.generateNotification();

        } else if (notificationData.get(NotificationDetails.FIELD.COMMON.WALLET.getFieldName()).equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            AppleNotificationBuilder builder = new AppleNotificationBuilder();

            director.constructDefaultNotification(builder,
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())),
                    inputMapper.mapToCardName(notificationData.get(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())));

            builder.setSecurity(inputMapper.mapToSecurity(notificationData.get(NotificationDetails.FIELD.APPLE.SECURITY.getFieldName())));

            return builder.generateNotification();


        } else if (notificationData.get(NotificationDetails.FIELD.COMMON.WALLET.getFieldName()).equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            SamsungNotificationBuilder builder = new SamsungNotificationBuilder();

            director.constructDefaultNotification(builder,
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())),
                    inputMapper.mapToCardName(notificationData.get(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())));

            builder.setDeviceType(inputMapper.mapToDeviceType(notificationData.get(NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName())));

            return builder.generateNotification();

        }
        return null;
    }

    private AbstractNotification buildCustomNotificationFromInput(Map<String, String> notificationData) {
        InputMapper inputMapper = new InputMapper();

        if (notificationData.get(NotificationDetails.FIELD.COMMON.WALLET.getFieldName()).equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            AndroidNotificationBuilder builder = new AndroidNotificationBuilder();

            return builder.generateNotification(
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName())),
                    notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName()),
                    inputMapper.mapToIssuer(notificationData.get(NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName()),
                            notificationData.get(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())),
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())),
                    inputMapper.mapToTransactionDate(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName())),
                    inputMapper.mapToDeviceType(notificationData.get(NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName())),
                    notificationData.get(NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName())
            );
        } else if (notificationData.get(NotificationDetails.FIELD.COMMON.WALLET.getFieldName()).equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            AppleNotificationBuilder builder = new AppleNotificationBuilder();

            return builder.generateNotification(
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName())),
                    notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName()),
                    inputMapper.mapToIssuer(notificationData.get(NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName()),
                            notificationData.get(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())),
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())),
                    inputMapper.mapToTransactionDate(NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName()),
                    inputMapper.mapToSecurity(notificationData.get(NotificationDetails.FIELD.APPLE.SECURITY.getFieldName()))
            );
        } else if (notificationData.get(NotificationDetails.FIELD.COMMON.WALLET.getFieldName()).equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            SamsungNotificationBuilder builder = new SamsungNotificationBuilder();

            return builder.generateNotification(
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName())),
                    notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName()),
                    inputMapper.mapToIssuer(notificationData.get(NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName()),
                            notificationData.get(NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName())),
                    inputMapper.mapToTransactionSumOrNumber(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName())),
                    inputMapper.mapToTransactionDate(notificationData.get(NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName())),
                    inputMapper.mapToDeviceType(notificationData.get(NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName()))
            );
        }
        return null;
    }

    private void inputRequiredFields(ConsoleIO console, Map<String, String> notificationData) {
        var walletFiledName = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        var fastCreationType = NotificationDetails.CREATION_TYPE.FAST.getCreationType();
        var customCreationType = NotificationDetails.CREATION_TYPE.CUSTOM.getCreationType();
        var creationTypeFieldName = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();

        if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                inputCommonFields(console, notificationData);
                inputAndroidSpecificFields(console, notificationData);
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {
                inputMinimumFieldsForDirector(console, notificationData);
                inputAndroidSpecificFields(console, notificationData);
            }
        } else if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                inputCommonFields(console, notificationData);
                inputAppleSpecificFields(console, notificationData);
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {
                inputMinimumFieldsForDirector(console, notificationData);
                inputAppleSpecificFields(console, notificationData);
            }
        } else if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                inputCommonFields(console, notificationData);
                inputSamsungSpecificFields(console, notificationData);
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {
                inputMinimumFieldsForDirector(console, notificationData);
                inputSamsungSpecificFields(console, notificationData);
            }
        }
    }

    private void inputCommonFields(ConsoleIO console, Map<String, String> notificationData) {
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName(), ConsoleMessage.INPUT_ISSUER_ID.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName(), ConsoleMessage.INPUT_CARD_NAME.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_NAME.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_NUMBER.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_SUM.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_DATE.getMessage());
    }

    private void inputMinimumFieldsForDirector(ConsoleIO console, Map<String, String> notificationData) {
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName(), ConsoleMessage.INPUT_CARD_NAME.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName(), ConsoleMessage.INPUT_TRANSACTION_SUM.getMessage());
    }

    private void inputAndroidSpecificFields(ConsoleIO console, Map<String, String> notificationData) {
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName(), ConsoleMessage.INPUT_DEVICE_TYPE.getMessage());
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName(), ConsoleMessage.INPUT_DEVICE_VERSION.getMessage());
    }

    private void inputAppleSpecificFields(ConsoleIO console, Map<String, String> notificationData) {
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.APPLE.SECURITY.getFieldName(), ConsoleMessage.INPUT_SECURITY.getMessage());
    }

    private void inputSamsungSpecificFields(ConsoleIO console, Map<String, String> notificationData) {
        inputFiledValue(console, notificationData, NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName(), ConsoleMessage.INPUT_DEVICE_TYPE.getMessage());
    }

    private void inputFiledValue(ConsoleIO console, Map<String, String> notificationData, String fieldName, String message) {
        System.out.println(message);

        var creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

}
