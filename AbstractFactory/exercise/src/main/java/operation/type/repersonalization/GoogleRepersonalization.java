package operation.type.repersonalization;

import common.OperationType;
import common.Wallet;
import operation.type.Repersonalization;

public class GoogleRepersonalization implements Repersonalization {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.GOOGLE.getWalletName() + " " + OperationType.REPERSONALIZATION.getOperationTypeName());

    }

}
