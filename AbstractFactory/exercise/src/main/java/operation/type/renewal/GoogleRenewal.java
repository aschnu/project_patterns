package operation.type.renewal;

import common.OperationType;
import common.Wallet;
import operation.type.Renewal;

public class GoogleRenewal implements Renewal {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.GOOGLE.getWalletName() + " " + OperationType.RENEWAL.getOperationTypeName());

    }

}
