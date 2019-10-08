package com.nsl.search;

public class BST<Key extends Comparable<Key>, Value>  {


    private Node root;


    private class Node {

        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;

        private Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }


    public Value get(Key key) {

        return get(root, key);

    }

    public void put(Key key, Value value) {


        root = put(root, key, value);

    }

    public int size() {
        return size(root);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }

        return min(x.left);

    }

    public Key max() {

        return max(root).key;
    }

    public Node max(Node x) {

        if (x.right == null) {
            return x;
        }
        return max(x.right);

    }

    public Key select(int k) {

        return select(root, k);
    }

    private Key select(Node x, int k) {

        if (x == null) {
            return null;
        }

        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);

        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x.key;
        }

    }


    public int rank(Key key) {
        return rank(root, key);
    }

    public int rank(Node x, Key key) {

        if (x == null) {
            return 0;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return rank(x.right, key) + size(x.left) + 1;
        } else {
            return size(x.left);
        }
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node x) {

        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);

        x.N = size(x.left) + size(x.right) + 1;

        return x;

    }

    public void delete(Key key) {

        delete(root, key);
    }

    public Node delete(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return x.left = delete(x.left, key);
        } else if (cmp > 0) {
            return x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }

            if (x.right == null) {

                return x.left;
            }

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }

    private int size(Node x) {

        if (x == null) {
            return 0;
        }
        return x.N;
    }



    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);

        }

        int cmp = x.key.compareTo(key);

        if (cmp > 0) {
            x.left = put(x.left, key, value);
        } else if (cmp < 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }


        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    private Value get(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }

    }

    public void print() {
        print(root);
    }

    /**
     * 顺序输出二叉树
     * @param x 节点
     */
    public void print(Node x) {
        if (x == null) {
            return;
        }

        print(x.left);
        System.out.println(x.key);
        print(x.right);

    }


    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();

        bst.put(5, "root");
        bst.put(3, "3333");
        bst.put(4, "4444");
        bst.put(2, "2222");
        bst.put(6, "6666");
        bst.put(9, "9999");
        bst.put(7, "777");

        System.out.println(bst.size());
        System.out.println(bst.get(6));
        System.out.println(bst.min());
        System.out.println(bst.max());
        System.out.println(bst.size(bst.root.right));
        System.out.println(bst.select(0));
        System.out.println(bst.select(3));

        System.out.println("=================");
        System.out.println(bst.rank(0));
        System.out.println(bst.rank(2));
        System.out.println(bst.rank(9));
        System.out.println(bst.rank(5));

        System.out.println("===========");
        bst.delete(3);
        System.out.println(bst.size());


        System.out.println(bst.get(3));
        System.out.println(bst.select(3));

        System.out.println("=================");
        bst.print();


    }

}
