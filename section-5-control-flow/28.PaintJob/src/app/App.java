package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2)); // -1
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2)); // 3
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1)); // 3
        System.out.println("*****************");
        System.out.println(getBucketCount(-3.4, 2.1, 1.5)); // -1
        System.out.println(getBucketCount(3.4, 2.1, 1.5)); // 5
        System.out.println(getBucketCount(7.25, 4.3, 2.35)); // 14
        System.out.println("*****************");
        System.out.println(getBucketCount(3.4, 1.5)); // 3
        System.out.println(getBucketCount(6.26, 2.2)); // 3
        System.out.println(getBucketCount(3.26, 0.75)); // 5
    }

    public static int getBucketCount(double w, double h, double areaPerBucket, int extraBuckets) {
        return (w <= 0 || h <= 0 || areaPerBucket <= 0 || extraBuckets < 0) ? -1 : (int) Math.ceil((w * h) / areaPerBucket) - extraBuckets;
    }

    public static int getBucketCount(double w, double h, double areaPerBucket) {
        return (w <= 0 || h <= 0 || areaPerBucket <= 0) ? -1 : (int) Math.ceil((w * h) / areaPerBucket);
    }

    public static int getBucketCount(double a, double areaPerBucket) {
        return (a <= 0 || areaPerBucket <= 0) ? -1 : (int) Math.ceil(a / areaPerBucket);
    }
}