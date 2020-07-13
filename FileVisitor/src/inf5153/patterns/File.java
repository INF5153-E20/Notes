package inf5153.patterns;

/**
 * Created by wflag on 2020-07-13.
 */
public class File implements FileSystemElement {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void delete() {
        System.out.println(String.format("%s was deleted!", name));
    }
}
