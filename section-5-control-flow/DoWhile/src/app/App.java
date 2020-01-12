package app;

public class App {
    public static void main(String[] args) throws Exception {
        
        int n = 4;
        int end = 20;
        int count = 0;

        while (n <= end) {
            if (isEvenNumber(n)) {
                System.out.println("Even number " + n);
                count++;
                if (count == 5) {
                    System.out.println("Limit reached");
                    break;
                }
            }
            n++;
        }
    }

    public static boolean isEvenNumber(int n) {
        return n % 2 == 0 ? true : false;
    }
}