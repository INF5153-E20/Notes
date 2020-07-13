package inf5153.patterns;

/**
 * Created by wflag on 2020-07-13.
 */
public interface Visitor {
    void visit(File file);
    void visit(Folder folder);
}
