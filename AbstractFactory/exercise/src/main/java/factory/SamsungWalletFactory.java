package factory;

import operation.type.InitiateRepersonalization;
import operation.type.Renewal;
import operation.type.Repersonalization;
import operation.type.initiate.repersonalization.SamsungInitiateRepersonalization;
import operation.type.renewal.SamsungRenewal;
import operation.type.repersonalization.SamsungRepersonalization;

public class SamsungWalletFactory implements WalletFactory {

    @Override
    public InitiateRepersonalization createInitiateRepersonalization() {

        return new SamsungInitiateRepersonalization();

    }

    @Override
    public Repersonalization createRepersonalization() {

        return new SamsungRepersonalization();

    }

    @Override
    public Renewal createRenewal() {

        return new SamsungRenewal();

    }
}
