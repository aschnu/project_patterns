package common.constant;

public enum CardName {

    VISA("Visa"),
    MASTERCARD("Master Card");

    String cardName;

    CardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

}
