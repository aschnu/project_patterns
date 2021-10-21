import builder.Builder;
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
import common.model.Issuer;
import common.validator.PatternValidator;
import notification.AbstractNotification;
import notification.AndroidNotification;

import java.util.HashMap;
import java.util.Map;

public class Exercise {

    public static void main(String[] args) {

        Exercise exercise = new Exercise();
        Map<String, String> params = exercise.extractDataByWalletName(args);

        exercise.createNotification(params);

    }

    private void createNotification(Map<String, String> params) {

        Director director;
        AbstractNotificationBuilder builder = null;
        PatternValidator validator = new PatternValidator();

        if (params.get("Wallet").equals(Wallet.ANDROID.getWalletName())) {
            builder = new AndroidNotificationBuilder();
        } else if (params.get("Wallet").equals(Wallet.APPLE.getWalletName())) {
            builder = new AppleNotificationBuilder();
        } else if (params.get("Wallet").equals(Wallet.SAMSUNG.getWalletName())) {
            builder = new SamsungNotificationBuilder();
        }

        if (params.get("Notification creation type").equals(NotificationCreationType.FAST.getCreationType())) {

            director = new Director();

            if (null != builder && params.get("Card name").equals(CardName.VISA.getCardName())) {
                director.constructDefaultVisaNotification(builder, validator.validateTransactionSum(params.get("Transaction sum")));
            } else if (null != builder && params.get("Card name").equals(CardName.MASTERCARD.getCardName())) {
                director.constructDefaultMasterCardNotification(builder, validator.validateTransactionSum(params.get("Transaction sum")));
            }

        } else if (params.get("Notification creation type").equals(NotificationCreationType.CUSTOM.getCreationType())) {

        }

    }

    private AndroidNotification constructAndroidNotification(Builder builder, Map<String, String> params) {
//TODO: add builder, wallet specific fields & validate them
        AndroidNotification notification = null;

        

        return notification;

    }

    private Map<String, String> extractDataByWalletName(String[] args) {

        PatternValidator validator = new PatternValidator();
        Map<String, String> result = new HashMap<String, String>();

        result.put("Notification creation type", args[0]);
        result.put("Wallet", args[1]);

        if (args[0].equalsIgnoreCase(NotificationCreationType.FAST.getCreationType())) {
            result.put("Card name", args[2]);
            result.put("Transaction sum", args[3]);
            insertWalletSpecificFieldsForFastPath(result, args);
        } else if (args[0].equalsIgnoreCase(NotificationCreationType.CUSTOM.getCreationType())) {
            result.put("Transaction number", args[2]);
            result.put("Transaction name", args[3]);
            result.put("Issuer id", args[4]);
            result.put("Card name", args[5]);
            result.put("Transaction sum", args[6]);
            result.put("Transaction date", args[7]);
            insertWalletSpecificFieldsForCustomPath(result, args);
        } else {
            throw new IncorrectNotificationCreationPath(args[0]);
        }

        return result;
    }

    private void insertWalletSpecificFieldsForFastPath(Map<String, String> result, String[] args) {

        PatternValidator validator = new PatternValidator();

        if (args[1].equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            result.put("Device type", DeviceType.ANDROID.getDeviceType());
            result.put("Device version", args[4]);
        } else if (args[1].equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            result.put("Security", "True");
        } else if (args[1].equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            result.put("Device type", DeviceType.SAMSUNG.getDeviceType());
        } else {
            throw new IncorrectWalletException(args[1]);
        }

    }

    private void insertWalletSpecificFieldsForCustomPath(Map<String, String> result, String[] args) {

        PatternValidator validator = new PatternValidator();

        if (args[1].equalsIgnoreCase(Wallet.ANDROID.getWalletName())) {
            result.put("Device type", args[8]);
            result.put("Device version", args[9]);
        } else if (args[1].equalsIgnoreCase(Wallet.APPLE.getWalletName())) {
            result.put("Security", args[8]);
        } else if (args[1].equalsIgnoreCase(Wallet.SAMSUNG.getWalletName())) {
            result.put("Device type", args[8]);
        } else {
            throw new IncorrectWalletException(args[1]);
        }

    }

}
