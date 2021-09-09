package factory;

import operation.type.InitiateRepersonalization;
import operation.type.Renewal;
import operation.type.Repersonalization;

public interface WalletFactory {

    InitiateRepersonalization createInitiateRepersonalization();
    Repersonalization createRepersonalization();
    Renewal createRenewal();

}
