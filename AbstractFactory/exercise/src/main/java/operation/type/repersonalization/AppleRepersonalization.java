package operation.type.repersonalization;

import common.OperationType;
import common.Wallet;
import operation.type.Repersonalization;

public class AppleRepersonalization implements Repersonalization {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.APPLE.getWalletName() + " " + OperationType.REPERSONALIZATION.getOperationTypeName());

    }

}
