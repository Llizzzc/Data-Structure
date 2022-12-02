import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            long start = System.nanoTime();
            BSTSet<String> bst = new BSTSet<>();
            for (String word : words) {
                bst.add(word);
            }
            for (String word : words) {
                bst.contains(word);
            }
            long end = System.nanoTime();
            double time = (end - start) / 1.0e9;
            System.out.println("Total different words " + bst.getSize());
            System.out.println("BSTSet " + time + "s");

            start = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
            end = System.nanoTime();
            time = (end - start) / 1.0e9;
            System.out.println("Total different words " +  trie.getSize());
            System.out.println("Trie " + time + "s");
        }
    }
}