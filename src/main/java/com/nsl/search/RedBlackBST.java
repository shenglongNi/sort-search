package com.nsl.search;

/**
 *
 * @param <Key>
 * @param <Value>
 *
 *     左黑右红 : 左旋
 *     左红左子红： 右旋
 *     左红右红： 变色，并上传
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    ", color=" + color +
                    '}';
        }
    }


    public void put(Key key, Value value) {

        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {

        if (h == null) {

            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        }else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }


        return h;


    }


    private boolean isRed(Node x) {

        return x != null && x.color;
    }

    /**
     *
     * 左旋
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;


        return x;
    }


    /**
     * 右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {

        Node x = h.left;

        x.right = h;
        h.left = x.right;
        x.color = h.color;
        h.color = RED;
        return x;

    }


    /**
     * 变色,并将红色连接在树中向上传递
     * 将该节点变红(红连接向上传递)， 并将该节点的两个红色子节点变黑
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;

    }


    private void print() {

        print(root);
    }

    private void print(Node h) {

        if (h == null) {
            return;
        }

        print(h.left);
        System.out.println(h);
        print(h.right);
    }


    public static void main(String[] args) {
        RedBlackBST rbt = new RedBlackBST();
        rbt.put(5, "tt");
        rbt.put(2, "tt");
        rbt.put(8, "tt");
        rbt.put(4, "tt");
//        rbt.put(9, "tt");
//        rbt.put(7, "tt");
//        rbt.put(1, "tt");
        System.out.println("root: " + rbt.root);
        rbt.print();
    }



}
