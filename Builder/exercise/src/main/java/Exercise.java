import builder.concrete.AbstractNotificationBuilder;
import builder.concrete.AndroidNotificationBuilder;
import builder.concrete.AppleNotificationBuilder;
import builder.concrete.SamsungNotificationBuilder;
import builder.director.Director;
import common.enums.CardName;
import common.enums.DeviceType;
import common.enums.NotificationCreationType;
import common.enums.Wallet;
import common.exceptions.IncorrectNotificationCreationPath;
import common.exceptions.IncorrectWalletException;
import common.validator.PatternValidator;
import notification.AndroidNotification;
import notification.AppleNotification;
import notification.SamsungNotification;

import java.util.HashMap;
import java.util.Map;

public class Exercise {

    public static final String WALLET = "Wallet";
    public static final String CARD_NAME = "Card name";
    public static final String TRANSACTION_SUM = "Transaction sum";
    public static final String TRANSACTION_NUMBER = "Transaction number";
    public static final String TRANSACTION_NAME = "Transaction name";
    public static final String ISSUER_ID = "Issuer id";
    public static final String TRANSACTION_DATE = "Transaction date";
    public static final String DEVICE_TYPE = "Device type";
    public static final String DEVICE_VERSION = "Device version";
    public static final String SECURITY = "Security";
    public static final String NOTIFICATION_CREATION_TYPE = "Notification creation type";

    public static void main(String[] args) {

        Exercise exercise = new Exercise();
        Map<String, String> params = exercise.extractDataByWalletName(args);

        exercise.createNotification(params);

    }

    private void createNotification(Map<String, String> params) {

        Director director;
        AbstractNotificationBuilder builder = null;
        PatternValidator validator = new PatternValidator();

        if (params.get(WALLET).equals(Wallet.ANDROID.getWalletName())) {
            builder = new AndroidNotificationBuilder();
        } else if (params.get(WALLET).equals(Wallet.APPLE.getWalletName())) {
            builder = new AppleNotificationBuilder();
        } else if (params.get(WALLET).equals(Wallet.SAMSUNG.getWalletName())) {
            builder = new SamsungNotificationBuilder();
        }

        if (params.get(NOTIFICATION_CREATION_TYPE).equals(NotificationCreationType.FAST.getCreationType())) {

            director = new Director();

            if (null != builder && params.get(CARD_NAME).equals(CardName.VISA.getCardName())) {
                director.constructDefaultVisaNotification(builder, validator.validateTransactionSum(params.get(TRANSACTION_SUM)));
            } else if (null != builder && params.get(CARD_NAME).equals(CardName.MASTERCARD.getCardName())) {
                director.constructDefaultMasterCardNotification(builder, validator.validateTransactionSum(params.get(TRANSACTION_SUM)));
            }

        } else if (params.get(NOTIFICATION_CREATION_TYPE).equals(NotificationCreationType.CUSTOM.getCreationType())) {
            if (builder instanceof AndroidNotificationBuilder) {
                AndroidNotification notification = constructAndroidNotification((AndroidNotificationBuilder) builder, params);
                System.out.println(notification.toString());
            } else if (builder instanceof AppleNotificationBuilder) {
                AppleNotification notification = constructAppleNotification((AppleNotificationBuilder) builder, params);
                System.out.println(notification.toString());
            } else if (builder instanceof SamsungNotificationBuilder) {
                SamsungNotification notification = constructSamsungNotification((SamsungNotificationBuilder) builder, params);
                System.out.println(notification.toString());
            }
        }

    }

    private AndroidNotification constructAndroidNotification(AndroidNotificationBuilder builder, Map<String, String> params) {

        PatternValidator validator = new PatternValidator();

        return builder.generateNotification(
                validator.validateTransactionNumber(params.get(TRANSACTION_NUMBER)),
                validator.validateTransactionName(params.get(TRANSACTION_NAME)),
                validator.validateIssuer(params.get(ISSUER_ID), params.get(CARD_NAME)),
                validator.validateTransactionSum(params.get(TRANSACTION_SUM)),
                validator.validateTransactionDate(params.get(TRANSACTION_DATE)),
                validator.validateDeviceType(params.get(DEVICE_TYPE)),
                validator.validateDeviceVersion(params.get(DEVICE_VERSION)));

    }

    private AppleNotification constructAppleNotification(AppleNotificationBuilder builder, Map<String, String> params) {

        PatternValidator validator = new PatternValidator();

        return builder.generateNotification(
                validator.validateTransactionNumber(params.get(TRANSACTION_NUMBER)),
                validator.validateTransactionName(params.get(TRANSACTION_NAME)),
                validator.validateIssuer(params.get(ISSUER_ID), params.get(CARD_NAME)),
                validator.validateTransactionSum(params.get(TRANSACTION_SUM)),
                validator.validateTransactionDate(params.get(TRANSACTION_DATE)),
                validator.validateSecurity(params.get(SECURITY)));

    }

    private SamsungNotification constructSamsungNotification(SamsungNotificationBuilder builder, Map<String, String> params) {

        PatternValidator validator = new PatternValidator();

        return builder.generateNotification(
                validator.validateTransactionNumber(params.get(TRANSACTION_NUMBER)),
                validator.validateTransactionName(params.get(TRANSACTION_NAME)),
                validator.validateIssuer(params.get(ISSUER_ID), params.get(CARD_NAME)),
                validator.validateTransactionSum(params.get(TRANSACTION_SUM)),
                validator.validateTransactionDate(params.get(TRANSACTION_DATE)),
                validator.validateDeviceType(params.get(DEVICE_TYPE)));

    }

    private Map<String, String> extractDataByWalletName(String[] args) {

        Map<String, String> result = new HashMap<>();

        result.put(NOTIFICATION_CREATION_TYPE, args[0]);
        result.put(WALLET, args[1]);

        if (args[0].equalsIgnoreCase(NotificationCreationType.FAST.getCreationType())) {
            result.put(CARD_NAME, args[2]);
            result.put(TRANSACTION_SUM, args[3]);
            insertWalletSpecificFieldsForFastPath(result, args);
        } else if (args[0].equalsIgnoreCase(NotificationCreationType.CUSTOM.getCreationType())) {
            result.put(TRANSACTION_NUMBER, args[2]);
            result.put(TRANSACTION_NAME, args[3]);
            result.put(ISSUER_ID, args[4]);
            result.put(CARD_NAME, args[5]);
            result.put(TRANSACTION_SUM, args[6]);
            result.put(TRANSACTION_DATE, args[7]);
            insertWalletSpecificFieldsForCustomPath(result, args);
        } else {
            throw new IncorrectNotificationCreationPath(args[0]);
        }

        return result;
    }

    private void insertWalletSpecificFieldsForFastPath(Map<String, String> result, String[] args) {

        if (args[1].equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            result.put(DEVICE_TYPE, DeviceType.ANDROID.getDeviceType());
            result.put(DEVICE_VERSION, args[4]);
        } else if (args[1].equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            result.put(SECURITY, "True");
        } else if (args[1].equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            result.put(DEVICE_TYPE, DeviceType.SAMSUNG.getDeviceType());
        } else {
            throw new IncorrectWalletException(args[1]);
        }

    }

    private void insertWalletSpecificFieldsForCustomPath(Map<String, String> result, String[] args) {

        if (args[1].equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            result.put(DEVICE_TYPE, args[8]);
            result.put(DEVICE_VERSION, args[9]);
        } else if (args[1].equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            result.put(SECURITY, args[8]);
        } else if (args[1].equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            result.put(DEVICE_TYPE, args[8]);
        } else {
            throw new IncorrectWalletException(args[1]);
        }

    }

}
