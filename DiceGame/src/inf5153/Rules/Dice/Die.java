package inf5153.Rules.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wflag on 2020-06-08.
 */
public class Die {
    private Random rand = new Random();
    private List<DieFace> faces;

    public Die(Stream<DieFace> faces) {
        this.faces = faces.collect(Collectors.toList());
    }

    public Die(int size) {
        faces = new ArrayList<>();
        for(int i = 0; i < size; i++)
            faces.add(new PowerFace(1));
    }

    public int getPower() {
        return faces.stream().map(DieFace::getPower).reduce(Integer::sum).get();
    }

    public List<DieFace> getFaces() {
        return faces;
    }

    public int size() {
        return faces.size();
    }

    public DieFace roll() {
        return faces.get(rand.nextInt(faces.size()));
    }

    public void replaceFace(DieFace faceToReplace, DieFace newFace) {
        faces.remove(faceToReplace);
        faces.add(newFace);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("[");

        faces.forEach(f -> buffer.append(f.toString()));

        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("]");

        return buffer.toString();
    }
}
