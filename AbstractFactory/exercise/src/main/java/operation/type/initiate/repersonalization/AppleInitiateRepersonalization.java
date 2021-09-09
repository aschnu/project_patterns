package operation.type.initiate.repersonalization;

import common.OperationType;
import common.Wallet;
import operation.type.InitiateRepersonalization;

public class AppleInitiateRepersonalization implements InitiateRepersonalization {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.APPLE.getWalletName() + " " + OperationType.INITIATE_REPERSONALIZATION.getOperationTypeName());

    }

}
