package inf5153.patterns;

/**
 * Created by wflag on 2020-07-13.
 */
public class ListVisitor implements Visitor {
    @Override
    public void visit(File file) {
        System.out.println(String.format("%s : %s", "File", file.getName()));
    }

    @Override
    public void visit(Folder folder) {
        System.out.println(String.format("%s : %s", "Folder", folder.getName()));
        for(FileSystemElement e : folder.getChildren())
            e.accept(this);
    }
}
