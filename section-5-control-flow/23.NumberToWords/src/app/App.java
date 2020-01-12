package app;

public class App {
    public static void main(String[] args) throws Exception {
        numberToWords(0);;
    }

    public static void numberToWords(int n) {
        if (n < 0) {
            System.out.println("Invalid Value");
        }

        int reversed = reverse(n);
        int addZeroes = getDigitCount(n) - getDigitCount(reversed);
        
        String resultString = "";
        if (reversed == 0) {
            resultString += "Zero";
        }
        while(reversed > 0) {
            int digit = reversed % 10;
            switch(digit) {
                case 0:
                    resultString += "Zero ";
                    break;
                case 1:
                    resultString += "One ";
                    break;  
                case 2:
                    resultString += "Two ";
                    break;
                case 3:
                    resultString += "Three ";
                    break;  
                case 4:
                    resultString += "Four ";
                    break;  
                case 5:
                    resultString += "Five ";
                    break;  
                case 6:
                    resultString += "Six ";
                    break;  
                case 7:
                    resultString += "Seven ";
                    break;  
                case 8:
                    resultString += "Eight ";
                    break;  
                case 9:
                    resultString += "Nine ";
                    break;
            }
            reversed /= 10;
        }
        while(addZeroes > 0) {
            resultString += "Zero ";
            addZeroes--;
        }

        System.out.println(resultString);
    }

    public static int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 1;
        }

        int digits = 0;
        while (n > 0) {
            digits++;
            n /= 10;
        }
        return digits;
    }
}