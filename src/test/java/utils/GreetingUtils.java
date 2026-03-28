package utils;

import java.time.LocalTime;

public class GreetingUtils {

    public static String getExpectedGreeting(String username) {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        String greeting;

        if (hour >= 7 && hour < 12) {
            greeting = "Good Morning";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good Afternoon";
        } else if (hour >= 18 && hour < 24) {
            greeting = "Good Evening";
        } else {
            greeting = "Time to sleep";
        }

        return greeting + " " + username;
    }
}