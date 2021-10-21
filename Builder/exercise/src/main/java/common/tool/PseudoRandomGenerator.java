package common.tool;

public class PseudoRandomGenerator {

    public static long generateRandomLong() {
        long min = 1L;
        long max = 1000L;
        return min + (long) (Math.random() * (max - min));
    }

    public static long generateRandomLong(long min, long max) {
        return min + (long) (Math.random() * (max - min));
    }

}
