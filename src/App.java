
import structures.trees.IntTree;
public class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
    }

    private static void runIntTree(){
        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(3);
        System.out.println("\nPre order ");
        tree.preOrder();
        System.out.println("\nPos order ");
        tree.posOrder();
        System.out.println("\nIn order ");
        tree.inOrder();
    
    }
}
