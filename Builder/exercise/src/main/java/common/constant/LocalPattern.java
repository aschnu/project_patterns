package common.constant;

public enum LocalPattern {

    TRANSACTION_NUMBER("^[0-9]{0,10}$"),
    TRANSACTION_NAME("^([A-Za-z0-9\\s]){0,35}$"),
    ISSUER_ID("^[0-9]{0,1}"),
    TRANSACTION_SUM("[0-9]{0,10}"),
    TRANSACTION_DATETIME("^(((\\d\\d)(([02468][048])|([13579][26]))-02-29)|(((\\d\\d)(\\d\\d)))-((((0\\d)|(1[0-2]))-((0\\d)|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))\\s(([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d))$"),
    DEVICE_VERSION("^[A-Za-z0-9]{0,5}.{1}[0-9]{0,4}$"),
    SECURITY("(?i)(?<= |^)true|false(?= |$)");

    String pattern;

    LocalPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

}
