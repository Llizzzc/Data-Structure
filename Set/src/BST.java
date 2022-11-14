import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    Node root;
    int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树添加元素, 递归写法
    public void addR(E e) {
        root = addR(root, e);
    }
    private Node addR(Node node, E e) {

        if (node == null) {
            size ++;
            node = new Node(e);
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addR(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addR(node.right, e);
        }
        return node;
    }

    // 添加元素非递归写法
    public void add(E e) {
        if (root == null) {
            size ++;
            root = new Node(e);
            return;
        }
        Node pre = root;
        while (pre != null) {
            if (e.compareTo(pre.e) < 0) {
                if (pre.left == null) {
                    pre.left = new Node(e);
                    size ++;
                    return;
                }
                pre = pre.left;
            } else if (e.compareTo(pre.e) > 0) {
                if (pre.right == null) {
                    pre.right = new Node(e);
                    size ++;
                    return;
                }
                pre = pre.right;
            } else {
                return;
            }
        }
    }

    // 查看是否包含元素e, 递归写法
    public boolean containsR(E e) {
        return containsR(root, e);
    }
    private boolean containsR(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return containsR(node.left, e);
        } else {
            return containsR(node.right, e);
        }
    }

    // 查看非递归写法
    public boolean contains(E e) {
        if (root == null) {
            return false;
        }
        Node cur = root;
        while (cur != null) {
            if (e.compareTo(cur.e) == 0) {
                return true;
            } else if (e.compareTo(cur.e) < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    // 前序遍历, 递归写法
    public void preOrderR() {
        preOrderR(root);
    }
    private void preOrderR(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrderR(node.left);
        preOrderR(node.right);
    }

    // 前序遍历非递归写法
    public void preOrder() {
        Deque<Node> st = new LinkedList<>();
        st.addLast(root);

        while (!st.isEmpty()) {
            Node cur = st.removeLast();
            System.out.println(cur.e);
            if (cur.right != null) {
                st.addLast(cur.right);
            }
            if (cur.left != null) {
                st.addLast(cur.left);
            }
        }
    }

    // 中序遍历, 递归写法
    public void inOrderR() {
        inOrderR(root);
    }
    private void inOrderR(Node node) {
        if (node == null) {
            return;
        }
        inOrderR(node.left);
        System.out.println(node.e);
        inOrderR(node.right);
    }

    // 中序遍历，非递归
    public void inOrder() {
        Deque<Node> st = new LinkedList<>();
        Node leftNode = root;
        st.addLast(leftNode);
        // 往左走，将经过的根节点依次入栈
        while (!st.isEmpty()) {
            while (leftNode.left != null) {
                st.addLast(leftNode.left);
                leftNode = leftNode.left;
            }
            // 栈顶出栈
            Node cur = st.removeLast();
            System.out.println(cur.e);
            // 如果当前节点有右孩子，入栈
            if (cur.right != null) {
                st.addLast(cur.right);
                Node rLeftNode = cur.right;
                // 从右孩子向左走，将经过的根节点依次入栈
                while (rLeftNode.left != null) {
                    st.addLast(rLeftNode.left);
                    rLeftNode = rLeftNode.left;
                }
            }
        }
    }

    // 后序遍历, 递归写法
    public void postOrderR() {
        postOrderR(root);
    }
    private void postOrderR(Node node) {
        if (node == null) {
            return;
        }
        postOrderR(node.left);
        postOrderR(node.right);
        System.out.println(node.e);
    }

    // 后序遍历，非递归
    public void postOrder() {
        Deque<Node> st = new LinkedList<>();
        Node leftNode = root;
        Node flat = null;   // 标记最近出栈的节点
        // 从根节点开始，往左走依次入栈
        st.addLast(leftNode);
        while (!st.isEmpty()) {
            while (leftNode.left != null) {
                st.addLast(leftNode.left);
                leftNode = leftNode.left;
            }
            // 获取栈顶元素
            Node cur = st.getLast();
            // 右孩子非空且右孩子没有入栈过
            if (cur.right != null && cur.right != flat) {
                st.addLast(cur.right);
                // 从右孩子开始，向左走，依入栈
                Node rLeftNode = cur.right;
                while (rLeftNode.left != null) {
                    st.addLast(rLeftNode.left);
                    rLeftNode = rLeftNode.left;
                }
            } else { // 无右孩子则出栈当前节点，并标记
                Node p = st.removeLast();
                flat = p;
                System.out.println(p.e);
            }
        }
    }

    // 层次遍历
    public void levelOrder() {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    // 查找最小值, 递归写法
    public E minimumR() {
        if (size == 0) {
            throw new RuntimeException("FindMin failed. Empty tree now.");
        }
        return minimumR(root).e;
    }
    private Node minimumR(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimumR(node.left);
    }

    // 查找最小值，非递归写法
    public E minimum() {
        if (size == 0) {
            throw new RuntimeException("FindMin failed. Empty tree now.");
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }

    // 查找最大值, 递归写法
    public E maximumR() {
        if (size == 0) {
            throw new RuntimeException("FindMax failed. Empty tree now.");
        }
        return maximumR(root).e;
    }
    private Node maximumR(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximumR(node.right);
    }

    // 查找最大值，非递归写法
    public E maximum() {
        if (size == 0) {
            throw new RuntimeException("FindMax failed. Empty tree now.");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    // 删除最小值结点, 递归写法
    public E removeMinR() {
        E ret = minimumR();
        root = removeMinR(root);
        return ret;
    }
    private Node removeMinR(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMinR(node.left);
        return node;
    }

    // 删除最小值结点，非递归写法
    public E removeMin() {
        E ret = minimumR();
        if (root.left == null) {
            root = root.right;
            size --;
            return ret;
        }
        Node pre = root;
        Node cur = root.left;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;
        cur.right = null;
        size --;
        return ret;
    }

    // 删除最大值结点, 递归写法
    public E removeMaxR() {
        E ret = maximumR();
        root = removeMaxR(root);
        return ret;
    }
    private Node removeMaxR(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMaxR(node.right);
        return node;
    }

    // 删除最大值结点，非递归写法
    public E removeMax() {
        E ret = maximumR();
        if (root.right == null) {
            root = root.left;
            size --;
            return ret;
        }
        Node pre = root;
        Node cur = root.right;
        while (cur.right != null) {
            pre = cur;
            cur = cur.right;
        }
        pre.right = cur.left;
        cur.left = null;
        size --;
        return ret;
    }

    // 删除任意元素
    public void remove(E e) {
        if (size == 0) {
            throw new RuntimeException("remove failed. Empty tree now.");
        }
        root = remove(root, e);
    }
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 找到比待删除节点大的最小节点，用这个节点顶替待删除节点
            Node successor = minimumR(node.right);
            successor.right = removeMinR(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    // 获取指定元素的前驱节点值，递归
    public E floor(E e) {
        if (size == 0) {
            throw new RuntimeException("Floor failed. Empty tree now.");
        }
        // 若e比树中最小元素还小，则不存在前驱节点
        if (e.compareTo(minimumR()) < 0) {
            return null;
        }
        return floor(root, e).e;
    }
    private Node floor(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            return floor(node.left, e);
        }
        if (e.compareTo(node.e) == 0) {
            return node;
        }
        // e > node.e 时，node可能为前驱节点，还需向右找是否存在比node更大的前驱
        Node temp = floor(node.right, e);
        if (temp != null) {
            return temp;
        }
        return node;
    }

    // 获取指定元素的后继节点值，递归
    public E ceil(E e) {
        if (size == 0) {
            throw new RuntimeException("Ceil failed. Empty tree now.");
        }
        // 若e比树中最小元素还小，则不存在前驱节点
        if (e.compareTo(maximumR()) > 0) {
            return null;
        }
        return ceil(root, e).e;
    }
    private Node ceil(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) > 0) {
            return ceil(node.right, e);
        }
        if (e.compareTo(node.e) == 0) {
            return node;
        }
        // e < node.e 时，node可能为后继节点，还需向右找是否存在比node更大的后继
        Node temp = ceil(node.left, e);
        if (temp != null) {
            return temp;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.addR(num);
        }
        System.out.println(bst.floor(1));
        System.out.println(bst.ceil(1));
    }
}