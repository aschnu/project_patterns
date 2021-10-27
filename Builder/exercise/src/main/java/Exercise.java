import common.constant.ConsoleMessage;
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


    }

    private void chooseCreationPath(ConsoleIO console) {
        String creationType;

        System.out.println(ConsoleMessage.INPUT_PATH.getMessage());

        creationType = console.scanUntilValid("Security");

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
