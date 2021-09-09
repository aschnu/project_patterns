package operation.type.initiate.repersonalization;

import common.OperationType;
import common.Wallet;
import operation.type.InitiateRepersonalization;

public class SamsungInitiateRepersonalization implements InitiateRepersonalization {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.SAMSUNG.getWalletName() + " " + OperationType.INITIATE_REPERSONALIZATION.getOperationTypeName());

    }

}
