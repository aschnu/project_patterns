import common.Wallet;
import factory.AppleWalletFactory;
import factory.GoogleWalletFactory;
import factory.SamsungWalletFactory;
import factory.WalletFactory;
import operation.type.InitiateRepersonalization;
import operation.type.Renewal;
import operation.type.Repersonalization;

public class Application {

    private WalletFactory factory;
    private InitiateRepersonalization initiateRepersonalization;
    private Renewal renewal;
    private Repersonalization repersonalization;

    public static void main (String[] args) {

        Application application = new Application();
        application.factory = application.createWalletFactory(args[0]);
        application.prepareOperationType();
        application.runAllOperationTypesFlows();

    }

    private void prepareOperationType() {

        this.initiateRepersonalization = factory.createInitiateRepersonalization();
        this.repersonalization = factory.createRepersonalization();
        this.renewal = factory.createRenewal();

    }

    private void runAllOperationTypesFlows() {

        initiateRepersonalization.runFlow();
        repersonalization.runFlow();
        renewal.runFlow();

    }

    private WalletFactory createWalletFactory(String wallet) {

        WalletFactory factory;

        if (wallet.equals(Wallet.APPLE.getWalletName())) {
            factory = new AppleWalletFactory();
        } else if (wallet.equals(Wallet.GOOGLE.getWalletName())) {
            factory = new GoogleWalletFactory();
        } else if (wallet.equals(Wallet.SAMSUNG.getWalletName())) {
            factory = new SamsungWalletFactory();
        } else {
            throw new IllegalStateException("Unexpected value: " + wallet);
        }

        return factory;

    }

}
