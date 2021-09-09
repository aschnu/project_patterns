package factory;

import operation.type.InitiateRepersonalization;
import operation.type.Renewal;
import operation.type.Repersonalization;
import operation.type.initiate.repersonalization.GoogleInitiateRepersonalization;
import operation.type.renewal.GoogleRenewal;
import operation.type.repersonalization.GoogleRepersonalization;

public class GoogleWalletFactory implements WalletFactory {

    @Override
    public InitiateRepersonalization createInitiateRepersonalization() {

        return new GoogleInitiateRepersonalization();

    }

    @Override
    public Repersonalization createRepersonalization() {

        return new GoogleRepersonalization();

    }

    @Override
    public Renewal createRenewal() {

        return new GoogleRenewal();

    }
}
