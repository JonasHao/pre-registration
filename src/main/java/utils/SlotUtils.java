package utils;

import java.util.Calendar;

/**
 * Created by Koche on 2016/5/10.
 */
public class SlotUtils {
    public static final int SLOT_DURATION = 30;

    public static void slotting(Calendar calendar) {
        int m = calendar.get(Calendar.MINUTE);
        int new_m = (m / SLOT_DURATION) * SLOT_DURATION;
        System.out.printf("slotting: %d->%d", m, new_m);
        calendar.set(Calendar.MINUTE, m / SLOT_DURATION);
    }
}
