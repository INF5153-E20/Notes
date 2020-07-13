package inf5153.patterns;

/**
 * Created by wflag on 2020-07-13.
 */
public class DeleteVisitor implements Visitor {
    @Override
    public void visit(File file) {
        file.delete();
    }

    @Override
    public void visit(Folder folder) {
        for(FileSystemElement e : folder.getChildren())
            e.accept(this);

        folder.delete();
    }
}
