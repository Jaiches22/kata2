package software.ulpgc;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TsvFileEventsLoader loader = new TsvFileEventsLoader(new File("events.txt"));
        List<Events> events = loader.load();
        Map<String, Integer> histogram = new HashMap<>();
        String[] ranges = {
                "0-500", "501-1000", "1001-1500", "1501-2000", "2001-2500", "2501-3000"
        };
        for (String range : ranges) {
            histogram.put(range, 0);
        }
        for (Events event : events) {
            int participants = event.getParticipants();
            String range = getRange(participants);
            if (range != null) {
                histogram.put(range, histogram.get(range) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static String getRange(int participants) {
        if (participants <= 500) return "0-500";
        if (participants <= 1000) return "501-1000";
        if (participants <= 1500) return "1001-1500";
        if (participants <= 2000) return "1501-2000";
        if (participants <= 2500) return "2001-2500";
        if (participants <= 3000) return "2501-3000";
        return null; // Fuera de los rangos definidos
    }
}
