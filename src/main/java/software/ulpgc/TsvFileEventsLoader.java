package software.ulpgc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvFileEventsLoader implements EventsLoader {
    private final File file;

    public TsvFileEventsLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Events> load() {
        try {
            return load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Events> load(FileReader reader) throws IOException {
        return load(new BufferedReader(reader));
    }

    private List<Events> load(BufferedReader reader) throws IOException {
        reader.readLine();
        List<Events> events = new ArrayList<Events>();
        while (true){
            String line = reader.readLine();
            if (line == null) return events;
            events.add(toEvent(line));
        }
    }

    private Events toEvent(String line) {
        return toEvent(line.split("\t"));

    }

    private Events toEvent(String[] split) {
        return new Events(
                split[0],
                split[1],
                split[2]
        );
    }
}

