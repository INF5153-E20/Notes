package inf5153.patterns1.business;

import java.util.List;

public final class ReadData {
    private ReadData() { }

    public static void readInto(List<String> buffer) {
        buffer.add("LOTS");
        buffer.add("OF");
        buffer.add("DATA");
    }
}
