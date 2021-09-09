import factory.AppleWalletFactory;
import factory.GoogleWalletFactory;
import factory.SamsungWalletFactory;
import factory.WalletFactory;
import operation.type.InitiateRepersonalization;
import operation.type.Renewal;
import operation.type.Repersonalization;
import operation.type.initiate.repersonalization.AppleInitiateRepersonalization;
import operation.type.initiate.repersonalization.GoogleInitiateRepersonalization;
import operation.type.initiate.repersonalization.SamsungInitiateRepersonalization;
import operation.type.renewal.AppleRenewal;
import operation.type.renewal.GoogleRenewal;
import operation.type.renewal.SamsungRenewal;
import operation.type.repersonalization.AppleRepersonalization;
import operation.type.repersonalization.GoogleRepersonalization;
import operation.type.repersonalization.SamsungRepersonalization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    private WalletFactory factory;
    private InitiateRepersonalization initiateRepersonalization;
    private Renewal renewal;
    private Repersonalization repersonalization;

    @Test
    void shouldCreateInstanceOfAppleInitiateRepersonalization() {
        factory = new AppleWalletFactory();
        initiateRepersonalization = factory.createInitiateRepersonalization();
        assertEquals(initiateRepersonalization.getClass(), AppleInitiateRepersonalization.class);
    }

    @Test
    void shouldCreateInstanceOfAppleRenewal() {
        factory = new AppleWalletFactory();
        renewal = factory.createRenewal();
        assertEquals(renewal.getClass(), AppleRenewal.class);
    }

    @Test
    void shouldCreateInstanceOfAppleRepersonalization() {
        factory = new AppleWalletFactory();
        repersonalization = factory.createRepersonalization();
        assertEquals(repersonalization.getClass(), AppleRepersonalization.class);
    }

    @Test
    void shouldCreateInstanceOfGoogleInitiateRepersonalization() {
        factory = new GoogleWalletFactory();
        initiateRepersonalization = factory.createInitiateRepersonalization();
        assertEquals(initiateRepersonalization.getClass(), GoogleInitiateRepersonalization.class);
    }

    @Test
    void shouldCreateInstanceOfGoogleRenewal() {
        factory = new GoogleWalletFactory();
        renewal = factory.createRenewal();
        assertEquals(renewal.getClass(), GoogleRenewal.class);
    }

    @Test
    void shouldCreateInstanceOfGoogleRepersonalization() {
        factory = new GoogleWalletFactory();
        repersonalization = factory.createRepersonalization();
        assertEquals(repersonalization.getClass(), GoogleRepersonalization.class);
    }

    @Test
    void shouldCreateInstanceOfSamsungInitiateRepersonalization() {
        factory = new SamsungWalletFactory();
        initiateRepersonalization = factory.createInitiateRepersonalization();
        assertEquals(initiateRepersonalization.getClass(), SamsungInitiateRepersonalization.class);
    }

    @Test
    void shouldCreateInstanceOfSamsungRenewal() {
        factory = new SamsungWalletFactory();
        renewal = factory.createRenewal();
        assertEquals(renewal.getClass(), SamsungRenewal.class);
    }

    @Test
    void shouldCreateInstanceOfSamsungRepersonalization() {
        factory = new SamsungWalletFactory();
        repersonalization = factory.createRepersonalization();
        assertEquals(repersonalization.getClass(), SamsungRepersonalization.class);
    }

}
