package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    printMegaBytesAndKiloBytes(2500);
	    printMegaBytesAndKiloBytes(-1024);
	    printMegaBytesAndKiloBytes(5000);
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaBytes = (int) Math.floor(kiloBytes / 1024);
            int remainderKiloBytes = (int) (kiloBytes % 1024);
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainderKiloBytes + " KB");
        }
    }
}
