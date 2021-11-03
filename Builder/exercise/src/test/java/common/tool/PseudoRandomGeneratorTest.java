package common.tool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PseudoRandomGeneratorTest {

    @Test
    void shouldGenerateRandomLongInRangeBetween1And1000AsLong() {

        for (int i = 0; i < 10000; i++) {

            var result = PseudoRandomGenerator.generateRandomLong();

            assertFalse(result < 1);
            assertFalse(result > 1000);

        }

    }

}