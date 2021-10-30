import builder.concrete.AbstractNotificationBuilder;
import builder.concrete.AndroidNotificationBuilder;
import builder.concrete.AppleNotificationBuilder;
import builder.concrete.SamsungNotificationBuilder;
import builder.director.Director;
import common.constant.ConsoleMessage;
import common.constant.NotificationDetails;
import common.constant.Wallet;
import common.tool.ConsoleIO;
import common.validator.PatternValidator;

import java.util.HashMap;
import java.util.Map;

public class Exercise {

    public static void main(String[] args) {

        Exercise exercise = new Exercise();
        ConsoleIO console = new ConsoleIO();
        PatternValidator patternValidator = new PatternValidator();

        Map<String, String> notificationData = new HashMap<>();

        System.out.println(ConsoleMessage.WELCOME.getMessage());

        exercise.chooseWallet(console, notificationData);
        exercise.chooseCreationPath(console, notificationData);
        exercise.followWalletPath(console, notificationData);

        System.out.println(notificationData.toString());

    }

    private void followWalletPath(ConsoleIO console, Map<String, String> notificationData) {
        var walletFiledName = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        var fastCreationType = NotificationDetails.CREATION_TYPE.FAST.getCreationType();
        var customCreationType = NotificationDetails.CREATION_TYPE.CUSTOM.getCreationType();
        var creationTypeFieldName = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();

        if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                chooseCommonFields(console, notificationData);
                chooseDeviceType(console, notificationData);
                chooseDeviceVersion(console, notificationData);
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {

            } else {

            }
        } else if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                chooseCommonFields(console, notificationData);
                chooseSecurity(console, notificationData);
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {

            } else {

            }
        } else if (notificationData.get(walletFiledName).equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(customCreationType)) {
                chooseCommonFields(console, notificationData);
                chooseDeviceType(console, notificationData);
            } else if (notificationData.get(creationTypeFieldName).equalsIgnoreCase(fastCreationType)) {

            } else {

            }
        }
    }

    private void chooseWallet(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.WALLET.getFieldName();
        System.out.println(ConsoleMessage.INPUT_WALLET.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);

    }

    private void chooseCreationPath(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.NOTIFICATION_CREATION_TYPE.getFieldName();
        System.out.println(ConsoleMessage.INPUT_CREATION_PATH.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);

    }

    private void chooseTransactionNumber(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_NUMBER.getFieldName();
        System.out.println(ConsoleMessage.INPUT_TRANSACTION_NUMBER.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseTransactionName(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_NAME.getFieldName();
        System.out.println(ConsoleMessage.INPUT_TRANSACTION_NAME.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseTransactionSum(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_SUM.getFieldName();
        System.out.println(ConsoleMessage.INPUT_TRANSACTION_SUM.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseTransactionDate(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.TRANSACTION_DATE.getFieldName();
        System.out.println(ConsoleMessage.INPUT_TRANSACTION_DATE.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseIssuerId(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.ISSUER_ID.getFieldName();
        System.out.println(ConsoleMessage.INPUT_ISSUER_ID.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseCardName(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.CARD_NAME.getFieldName();
        System.out.println(ConsoleMessage.INPUT_CARD_NAME.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseDeviceType(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.COMMON.DEVICE_TYPE.getFieldName();
        System.out.println(ConsoleMessage.INPUT_DEVICE_TYPE.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseDeviceVersion(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.ANDROID.DEVICE_VERSION.getFieldName();
        System.out.println(ConsoleMessage.INPUT_DEVICE_VERSION.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseSecurity(ConsoleIO console, Map<String, String> notificationData) {
        var fieldName = NotificationDetails.FIELD.APPLE.SECURITY.getFieldName();
        System.out.println(ConsoleMessage.INPUT_SECURITY.getMessage());

        String creationType = console.scanUntilValid(fieldName);
        notificationData.put(fieldName, creationType);
    }

    private void chooseCommonFields(ConsoleIO console, Map<String, String> notificationData) {
        chooseIssuerId(console, notificationData);
        chooseCardName(console, notificationData);
        chooseTransactionName(console, notificationData);
        chooseTransactionNumber(console, notificationData);
        chooseTransactionSum(console, notificationData);
        chooseTransactionDate(console, notificationData);
    }

    private void chooseFieldsForAndroidWallet(ConsoleIO console, Map<String, String> notificationData) {

    }

//    private void createNotification(Map<String, String> params) {
//
//        Director director;
//        AbstractNotificationBuilder builder = null;
//        PatternValidator validator = new PatternValidator();
//
//        if (params.get(WALLET).equals(Wallet.ANDROID.getWalletName())) {
//            builder = new AndroidNotificationBuilder();
//        } else if (params.get(WALLET).equals(Wallet.APPLE.getWalletName())) {
//            builder = new AppleNotificationBuilder();
//        } else if (params.get(WALLET).equals(Wallet.SAMSUNG.getWalletName())) {
//            builder = new SamsungNotificationBuilder();
//        }
//
//        if (params.get(NOTIFICATION_CREATION_TYPE).equals(NotificationCreationType.FAST.getCreationType())) {
//
//            director = new Director();
//
//            if (null != builder && params.get(CARD_NAME).equals(CardName.VISA.getCardName())) {
//                director.constructDefaultVisaNotification(builder, validator.validateTransactionSum(params.get(TRANSACTION_SUM)));
//            } else if (null != builder && params.get(CARD_NAME).equals(CardName.MASTERCARD.getCardName())) {
//                director.constructDefaultMasterCardNotification(builder, validator.validateTransactionSum(params.get(TRANSACTION_SUM)));
//            }
//
//        } else if (params.get(NOTIFICATION_CREATION_TYPE).equals(NotificationCreationType.CUSTOM.getCreationType())) {
//            if (builder instanceof AndroidNotificationBuilder) {
//                AndroidNotification notification = constructAndroidNotification((AndroidNotificationBuilder) builder, params);
//                System.out.println(notification.toString());
//            } else if (builder instanceof AppleNotificationBuilder) {
//                AppleNotification notification = constructAppleNotification((AppleNotificationBuilder) builder, params);
//                System.out.println(notification.toString());
//            } else if (builder instanceof SamsungNotificationBuilder) {
//                SamsungNotification notification = constructSamsungNotification((SamsungNotificationBuilder) builder, params);
//                System.out.println(notification.toString());
//            }
//        }
//
//    }
//
//    private AndroidNotification constructAndroidNotification(AndroidNotificationBuilder builder, Map<String, String> params) {
//
//        PatternValidator validator = new PatternValidator();
//
//        return builder.generateNotification(
//                validator.validateTransactionNumber(params.get(TRANSACTION_NUMBER)),
//                validator.validateTransactionName(params.get(TRANSACTION_NAME)),
//                validator.validateIssuer(params.get(ISSUER_ID), params.get(CARD_NAME)),
//                validator.validateTransactionSum(params.get(TRANSACTION_SUM)),
//                validator.validateTransactionDate(params.get(TRANSACTION_DATE)),
//                validator.validateDeviceType(params.get(DEVICE_TYPE)),
//                validator.validateDeviceVersion(params.get(DEVICE_VERSION)));
//
//    }
//
//    private AppleNotification constructAppleNotification(AppleNotificationBuilder builder, Map<String, String> params) {
//
//        PatternValidator validator = new PatternValidator();
//
//        return builder.generateNotification(
//                validator.validateTransactionNumber(params.get(TRANSACTION_NUMBER)),
//                validator.validateTransactionName(params.get(TRANSACTION_NAME)),
//                validator.validateIssuer(params.get(ISSUER_ID), params.get(CARD_NAME)),
//                validator.validateTransactionSum(params.get(TRANSACTION_SUM)),
//                validator.validateTransactionDate(params.get(TRANSACTION_DATE)),
//                validator.validateSecurity(params.get(SECURITY)));
//
//    }
//
//    private SamsungNotification constructSamsungNotification(SamsungNotificationBuilder builder, Map<String, String> params) {
//
//        PatternValidator validator = new PatternValidator();
//
//        return builder.generateNotification(
//                validator.validateTransactionNumber(params.get(TRANSACTION_NUMBER)),
//                validator.validateTransactionName(params.get(TRANSACTION_NAME)),
//                validator.validateIssuer(params.get(ISSUER_ID), params.get(CARD_NAME)),
//                validator.validateTransactionSum(params.get(TRANSACTION_SUM)),
//                validator.validateTransactionDate(params.get(TRANSACTION_DATE)),
//                validator.validateDeviceType(params.get(DEVICE_TYPE)));
//
//    }
//
//    private Map<String, String> extractDataByWalletName(String[] args) {
//
//        Map<String, String> result = new HashMap<>();
//
//        result.put(NOTIFICATION_CREATION_TYPE, args[0]);
//        result.put(WALLET, args[1]);
//
//        if (args[0].equalsIgnoreCase(NotificationCreationType.FAST.getCreationType())) {
//            result.put(CARD_NAME, args[2]);
//            result.put(TRANSACTION_SUM, args[3]);
//            insertWalletSpecificFieldsForFastPath(result, args);
//        } else if (args[0].equalsIgnoreCase(NotificationCreationType.CUSTOM.getCreationType())) {
//            result.put(TRANSACTION_NUMBER, args[2]);
//            result.put(TRANSACTION_NAME, args[3]);
//            result.put(ISSUER_ID, args[4]);
//            result.put(CARD_NAME, args[5]);
//            result.put(TRANSACTION_SUM, args[6]);
//            result.put(TRANSACTION_DATE, args[7]);
//            insertWalletSpecificFieldsForCustomPath(result, args);
//        } else {
//            throw new IncorrectNotificationCreationPath(args[0]);
//        }
//
//        return result;
//    }
//
//    private void insertWalletSpecificFieldsForFastPath(Map<String, String> result, String[] args) {
//
//        if (args[1].equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
//            result.put(DEVICE_TYPE, DeviceType.ANDROID.getDeviceType());
//            result.put(DEVICE_VERSION, args[4]);
//        } else if (args[1].equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
//            result.put(SECURITY, "True");
//        } else if (args[1].equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
//            result.put(DEVICE_TYPE, DeviceType.SAMSUNG.getDeviceType());
//        } else {
//            throw new IncorrectWalletException(args[1]);
//        }
//
//    }
//
//    private void insertWalletSpecificFieldsForCustomPath(Map<String, String> result, String[] args) {
//
//        if (args[1].equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
//            result.put(DEVICE_TYPE, args[8]);
//            result.put(DEVICE_VERSION, args[9]);
//        } else if (args[1].equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
//            result.put(SECURITY, args[8]);
//        } else if (args[1].equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
//            result.put(DEVICE_TYPE, args[8]);
//        } else {
//            throw new IncorrectWalletException(args[1]);
//        }
//
//    }

}
