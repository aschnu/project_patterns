package plant;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BushTest {

    private static Bush bush;
    private final int maxGramsPerPackage = bush.getGramPerPackage();

    @BeforeAll
    static void setUp() {
        bush = new Bush();
    }

    @Test
    void shouldHaveGramsPerPackageGreaterThanZero() {

        assertTrue(maxGramsPerPackage > 0);

    }

    @Test
    void shouldCountZeroPackages() {

        int grams = 0;
        int expectedPackagesCount = 0;

        int calculatedNumberOfPackages = bush.countNumberOfPackage(grams);

        assertEquals(expectedPackagesCount, calculatedNumberOfPackages);

    }

    @Test
    void shouldCountZeroPackagesWithGramsLessThanZero() {

        int grams = -maxGramsPerPackage;
        int expectedPackagesCount = 0;

        int calculatedNumberOfPackages = bush.countNumberOfPackage(grams);

        assertEquals(expectedPackagesCount, calculatedNumberOfPackages);

    }

    @Test
    void shouldCountZeroPackagesAfterExceedingIntRange() {

        int grams = 2147483647;
        int expectedPackagesCount = 0;

        int calculatedNumberOfPackages = bush.countNumberOfPackage(grams+1);

        assertEquals(expectedPackagesCount, calculatedNumberOfPackages);

    }

    @Test
    void shouldCountOneFullPackage() {

        int expectedPackagesCount = 1;

        int calculatedNumberOfPackages = bush.countNumberOfPackage(maxGramsPerPackage);

        assertEquals(expectedPackagesCount, calculatedNumberOfPackages);

    }

    @Test
    void shouldCountOneNotFullPackage() {

        int grams = maxGramsPerPackage - 1;
        int expectedPackagesCount = 1;

        int calculatedNumberOfPackages = bush.countNumberOfPackage(grams);

        assertEquals(expectedPackagesCount, calculatedNumberOfPackages);

    }

    @Test
    void shouldCountTwoPackages() {

        int grams = maxGramsPerPackage + 1;
        int expectedPackagesCount = 2;

        int calculatedNumberOfPackages = bush.countNumberOfPackage(grams);

        assertEquals(expectedPackagesCount, calculatedNumberOfPackages);

    }

}
