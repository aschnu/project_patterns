package operation.type.repersonalization;

import common.OperationType;
import common.Wallet;
import operation.type.Repersonalization;

public class SamsungRepersonalization implements Repersonalization {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.SAMSUNG.getWalletName() + " " + OperationType.REPERSONALIZATION.getOperationTypeName());

    }

}
