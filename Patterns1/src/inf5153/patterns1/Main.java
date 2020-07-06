package inf5153.patterns1;

import inf5153.patterns1.business.ListObserver;
import inf5153.patterns1.business.NotifyList;
import inf5153.patterns1.creation.CreateBuffer;
import inf5153.patterns1.business.ReadData;
import inf5153.patterns1.output.OutputData;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = CreateBuffer.create();

        NotifyList<String> notifyBuffer = new NotifyList<>(buffer);
        notifyBuffer.attach(e -> System.out.println(String.format("Observateur : Élément %s ajouté à la liste!", e)));
        notifyBuffer.attach(e -> System.out.println(String.format("Observateur 2 : Élément %s ajouté à la liste!", e))
        );

        buffer = notifyBuffer;

        ReadData.readInto(buffer);

        OutputData.output(buffer);
    }
}