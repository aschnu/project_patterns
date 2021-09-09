package factory;

import operation.type.InitiateRepersonalization;
import operation.type.Renewal;
import operation.type.Repersonalization;
import operation.type.initiate.repersonalization.AppleInitiateRepersonalization;
import operation.type.renewal.AppleRenewal;
import operation.type.repersonalization.AppleRepersonalization;

public class AppleWalletFactory implements WalletFactory {

    @Override
    public InitiateRepersonalization createInitiateRepersonalization() {

        return new AppleInitiateRepersonalization();

    }

    @Override
    public Repersonalization createRepersonalization() {

        return new AppleRepersonalization();

    }

    @Override
    public Renewal createRenewal() {

        return new AppleRenewal();

    }
}
