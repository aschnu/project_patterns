package common.model;

import common.enums.CardName;

public class Issuer {

    private int id;
    private CardName name;

    public Issuer(int id, CardName name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public CardName getName() {
        return name;
    }
}
