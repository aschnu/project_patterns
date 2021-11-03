package common.model;

import common.constant.CardName;

public class Issuer {

    private int id;
    private CardName name;

    public Issuer(int id, CardName name) {
        this.id = id;
        this.name = name;
    }

    public static Issuer generateIssuerFromCardName(CardName card) {
        return switch (card) {
            case VISA -> new Issuer(1, CardName.VISA);
            case MASTERCARD -> new Issuer(2, CardName.MASTERCARD);
        };
    }

    public int getId() {
        return id;
    }

    public CardName getName() {
        return name;
    }
}
