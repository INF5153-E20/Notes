package inf5153.patterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wflag on 2020-07-13.
 */
public class Folder implements FileSystemElement {
    private final String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<FileSystemElement> getChildren() {
        return children;
    }

    public void addElement(FileSystemElement e) {
        children.add(e);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void delete() {
        System.out.println(String.format("%s was deleted!", name));
    }
}
