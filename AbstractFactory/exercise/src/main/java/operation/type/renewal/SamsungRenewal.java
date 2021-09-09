package operation.type.renewal;

import common.OperationType;
import common.Wallet;
import operation.type.Renewal;

public class SamsungRenewal implements Renewal {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.SAMSUNG.getWalletName() + " " + OperationType.RENEWAL.getOperationTypeName());

    }
}
