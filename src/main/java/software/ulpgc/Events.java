package software.ulpgc;

import java.util.StringJoiner;

public class Events {
    private final int year;
    private final String month;
    private final int participants;

    public Events(String year, String month, String participants) {
        this.year = Integer.parseInt(year);
        this.month = month;
        this.participants = Integer.parseInt(participants);
    }

    public int getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Events.class.getSimpleName() + "[", "]")
                .add("year=" + year)
                .add("month='" + month + "'")
                .add("passengers=" + participants)
                .toString();
    }
}
