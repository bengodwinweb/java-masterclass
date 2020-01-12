package com.bengodwinweb;

public class Main {

    public static void main(String[] args) {
	    char switchValue = 'A';

	    switch(switchValue) {
            case 'A': case 'B': case 'C': case 'D': case 'E': case 'F':
                System.out.println("Found");
                break;

            default:
                System.out.println("not found");
                break;
        }
    }

}
