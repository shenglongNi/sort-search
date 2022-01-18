package com.nsl.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<Key extends Comparable<Key>, Value extends Comparable> {


    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        //子节点数量
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private Node root;


    public int size(Node node) {
        return node == null ? 0 : node.N;
    }

    public void put(Key key, Value value) {
        this.root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {

        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = value.compareTo(node.value);

        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;

        }

        node.N = size(node.left) +size(node.right) + 1;

        return node;

    }


    private List<Node> list = new ArrayList<Node>();
    private List<Node> list2 = new ArrayList<Node>();
    private List<Node> list3 = new ArrayList<Node>();
    private List<Node> list4 = new ArrayList<Node>();

    public void frontSearch(Node x) {

        if (x == null) {
            return;
        }

        list.add(x);
        frontSearch(x.left);
//        System.out.println(x.value);
        frontSearch(x.right);
    }

    public void middleSearch(Node x) {

        if (x == null) {
            return;
        }

        middleSearch(x.left);
        list2.add(x);
        middleSearch(x.right);
    }


    public void behindSearch(Node x) {
        if (x == null) {
            return;
        }

        behindSearch(x.left);
        behindSearch(x.right);
        list3.add(x);
    }


    public void cenciSearch() {

        if (root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<Node>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            Node x = queue.poll();

            list4.add(x);

            if (x.left != null) {
                queue.offer(x.left);
            }
            if (x.right != null) {
                queue.offer(x.right);
            }

        }

    }


    public static void main(String[] args) {
        BinaryTree<String, Integer> tree = new BinaryTree<String, Integer>();

        tree.put("A", 5);
        tree.put("B",3);
        tree.put("C", 2);
        tree.put("D", 4);
        tree.put("E", 7);
        tree.put("F", 6);
        tree.put("G", 9);
        System.out.println(tree.root.N);
        tree.frontSearch(tree.root);
        tree.middleSearch(tree.root);
        tree.behindSearch(tree.root);
        tree.cenciSearch();

        System.out.println(tree.list);
        System.out.println(tree.list2);
        System.out.println(tree.list3);
        System.out.println(tree.list4);

    }

}
