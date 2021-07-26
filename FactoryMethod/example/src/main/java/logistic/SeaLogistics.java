package logistic;

import transport.Ship;
import transport.Transport;

public class SeaLogistics extends Logistics{
    @Override
    Transport createTransport() {
        return new Ship();
    }
}
