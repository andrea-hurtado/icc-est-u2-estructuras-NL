
import structures.trees.IntTree;
import models.Person;
import structures.trees.Tree;
public class App {
    public static void main(String[] args) throws Exception {
        //runIntTree();
        runTree();
    }

    private static void runTree(){
        Tree<Person> tree = new Tree<Person>();
        System.out.println("In Order");
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Pedro", 23));
        tree.insert(new Person("Luis", 19));
        tree.inOrder();
        tree.searchByAge(23);
        

        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println(findPerson);
        } else{
            System.out.println("No se encontró");
        }
        
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
        System.out.println("\nSize ");
        System.out.println(tree.size());
    
    }
}
