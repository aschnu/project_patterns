package operation.type.renewal;

import common.OperationType;
import common.Wallet;
import operation.type.Renewal;

public class AppleRenewal implements Renewal {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.APPLE.getWalletName() + " " + OperationType.RENEWAL.getOperationTypeName());

    }

}
