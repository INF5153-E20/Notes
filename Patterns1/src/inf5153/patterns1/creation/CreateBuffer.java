package inf5153.patterns1.creation;

import java.util.List;
import java.util.Vector;

public final class CreateBuffer {
    private CreateBuffer() { }

    public static List<String> create() {
        return new Vector<>();
    }
}
