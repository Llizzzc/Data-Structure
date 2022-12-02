import java.util.TreeMap;
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node() {
            this.isWord = false;
            this.next = new TreeMap<>();
        }
    }
    private Node root;
    private int size;
    public Trie() {
        root = new Node();
        size = 0;
    }

    // 获得存储的单词数量
    public int getSize() {
        return size;
    }

    // 添加单词
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }

    // 添加单词，递归
    public void addR(String word) {
        addR(root, 0, word);
    }
    private void addR(Node node, int index, String word) {
        if (index == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size ++;
            }
            return;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        addR(node.next.get(c), index + 1, word);
    }

    // 查询单词
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询单词，递归
    public boolean containsR(String word) {
        return containsR(root, 0, word);
    }
    private boolean containsR(Node node, int index, String word) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        }
        return containsR(node.next.get(c), index + 1, word);
    }

    // 查询str是否为前缀
    public boolean isPrefix(String str) {
        Node cur = root;
        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    // 删除单词
    public void remove(String word) {
        root = remove(root, word, 0);
    }
    private Node remove(Node node, String word, int index) {
        if (index == word.length()) {
            if (node.isWord) {
                size--;
                node.isWord = false;
                return node.next.size() == 0? null: node;
            }
            return node;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return node;
        }
        if (remove(node.next.get(c), word, index + 1) == null) {
            node.next.remove(c);
            if (node.next.size() == 0 && !node.isWord) {
                return null;
            }
        }
        return node;
    }
}
