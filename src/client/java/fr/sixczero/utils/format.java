package fr.sixczero.utils;


import net.minecraft.text.Text;

public class format {
    public static Text StringToText(String base, Object... args){
        return Text.of(String.format(base, args));
    }

    public static  String Time(int number){
        String fNumber;
        if (number < 10) fNumber = "0" + number;
        else fNumber = "" + number;
        return fNumber;
    }
}
