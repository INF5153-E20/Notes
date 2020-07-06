package inf5153.patterns1.output;

import java.util.List;

public final class OutputData {
    private OutputData() { }

    public static void output(List<String> buffer) {
        for(String s : buffer)
            System.out.println(s);
    }
}
