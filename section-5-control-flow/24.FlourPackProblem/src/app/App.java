package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(canPack(1, 0, 4)); // false
        System.out.println(canPack(1, 0, 5)); // true
        System.out.println(canPack(0, 5, 4)); // true
        System.out.println(canPack(2, 2, 11)); // true
        System.out.println(canPack(-3, 2, 11)); // false
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;
        bigCount = bigCount > goal / 5 ? goal / 5 : bigCount;
        return bigCount * 5 + smallCount >= goal ? true : false;
    }
}