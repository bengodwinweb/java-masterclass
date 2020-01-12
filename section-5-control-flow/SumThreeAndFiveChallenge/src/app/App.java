package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i);
                count++;
                sum += i;
                if (count == 5) {
                    System.out.println(sum);
                    break;
                }
            }
        }
    }

}