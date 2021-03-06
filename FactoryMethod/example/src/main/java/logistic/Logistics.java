package logistic;

import transport.Transport;

public abstract class Logistics {

    abstract Transport createTransport();

    public void planDelivery(){
        Transport transport = createTransport();
        transport.deliver();
    };
}
