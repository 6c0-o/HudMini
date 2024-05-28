package fr.sixczero.hud.data;

import fr.sixczero.utils.format;
import net.minecraft.text.Text;

import java.time.LocalTime;

public class IrlInfo {
    public static Text get(){
        LocalTime timeIRL = LocalTime.now();
        String hIRL = format.Time(timeIRL.getHour());
        String mIRL = format.Time(timeIRL.getMinute());

        return format.StringToText("§eIrl:§f %s:%s", hIRL,mIRL);
    }
}
