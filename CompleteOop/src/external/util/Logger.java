package external.util;

import java.time.LocalDateTime;

public class Logger {
    public static void logToConsole(CharSequence message) {
        LocalDateTime dt = LocalDateTime.now();
        System.out.printf("%1$tD %1$tT : %2$s%n", dt, message);

        if (message instanceof StringBuilder sb){
            sb.setLength(0);
        }
    }

    // Format specifier desc
    /*
        [%arg_index$][flags][width]conversion

        ex: "%1$tD %1$tT : %2$s %n".formatted(LocalDateTime.now(), message)

        %t - date time conversion
        %tT - time
        %tD - date
        %1$tD - date retrieved from 1st arg
        %1$tT = time retrieved from 2nd arg
     */
}
