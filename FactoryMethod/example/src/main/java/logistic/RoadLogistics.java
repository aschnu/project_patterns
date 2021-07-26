package logistic;

import transport.Transport;
import transport.Truck;

public class RoadLogistics extends Logistics{
    @Override
    Transport createTransport() {
        return new Truck();
    }
}
