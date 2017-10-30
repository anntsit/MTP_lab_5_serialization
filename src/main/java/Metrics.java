public class Metrics {
    private static long startTime;
    private static long stopTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void stop() {
        stopTime = System.currentTimeMillis();
    }

    public static void getExecutionTime() {
        long estimatedTime = stopTime - startTime;
        System.out.println("Execution time: " + estimatedTime);
    }

    public static void getUsedMemory() {
        long usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println("Used memory: " + convertToMegabytes(usedBytes));
    }

    private static long convertToMegabytes(long bytes) {
        return bytes / 1048576;
    }
}
