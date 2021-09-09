package common;

public enum Wallet {

    APPLE("Apple"),
    GOOGLE("Google"),
    SAMSUNG("Samsung");

    private final String WALLET_NAME;

    Wallet(String walletName) {

        this.WALLET_NAME = walletName;

    }

    public String getWalletName() {
        return WALLET_NAME;
    }
}
