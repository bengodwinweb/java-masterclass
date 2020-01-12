package com.bengodwinweb;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args) {
        System.out.println(getDurationString(76, 20));
        System.out.println(getDurationString(23, 54));
        System.out.println(getDurationString(3660));
        System.out.println(getDurationString(-1));
    }

    public static String getDurationString(int mins, int secs) {
        if (mins < 0 || secs < 0 || secs > 59) {
            return INVALID_VALUE_MESSAGE;
        }

        int hours = (int) (mins / 60);
        int remainingMins = mins % 60;

        String hoursString = hours < 10 ? "0" + hours + "h " : hours + "h ";
        String minutesString = remainingMins < 10 ? "0" + remainingMins + "m " : remainingMins + "m ";
        String secondsString = secs < 10 ? "0" + secs + "s" : secs + "s";

        return hoursString + minutesString + secondsString;
    }

    public static String getDurationString(int secs) {
        if (secs < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        int mins = (int) (secs / 60);
        int remainingSecs = secs % 60;
        return getDurationString(mins, remainingSecs);
    }
}
