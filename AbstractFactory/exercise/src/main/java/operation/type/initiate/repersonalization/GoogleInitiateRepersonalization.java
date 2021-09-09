package operation.type.initiate.repersonalization;

import common.OperationType;
import common.Wallet;
import operation.type.InitiateRepersonalization;

public class GoogleInitiateRepersonalization implements InitiateRepersonalization {

    @Override
    public void runFlow() {

        System.out.println("Running flow for " + Wallet.GOOGLE.getWalletName() + " " + OperationType.INITIATE_REPERSONALIZATION.getOperationTypeName());

    }

}
