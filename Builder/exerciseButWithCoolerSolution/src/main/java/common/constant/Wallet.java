package common.constant;

public enum Wallet {

    APPLE("Apple"),
    ANDROID("Android"),
    SAMSUNG("Samsung");

    String walletName;

    Wallet(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletName() {
        return walletName;
    }

}
