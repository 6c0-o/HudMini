package fr.sixczero.utils;


import net.minecraft.text.Text;

public class format {
    public static Text StringToText(String base, Object... args){
        return Text.of(String.format(base, args));
    }

    public static String formatTime(int number) {
        return formatNumber(number);
    }

    public static String formatTime(long number) {
        return formatNumber(number);
    }

    private static String formatNumber(long number) {
        String fNumber;
        if (number < 10) fNumber = "0" + number;
        else fNumber = "" + number;
        return fNumber;
    }
}