package inf5153.patterns;

public class Main {

    public static void main(String[] args) {
	    Folder topFolder = new Folder("top");
        File file1 = new File("file1");
        Folder folder1 = new Folder("folder1");
        File file2 = new File("file2");

        topFolder.addElement(file1);
        topFolder.addElement(folder1);
        folder1.addElement(file2);

        Visitor v = new DeleteVisitor();
        topFolder.accept(v);
    }
}
