package com.nsl.search;

/**
 * 二分查找
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {


    private Key[] keys;
    private Value[] values;

    private int N;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }


    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = val;
            return;
        }

        for (int j = N; j > i ; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = val;
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];

        }
        N--;

    }


    private int rank(Key key) {

//        return rankByRecursion(key, 0, N - 1);
        return rankByIteration(key);

    }

    public int rankByRecursion(Key key, int lo, int hi) {

        if (lo > hi) {
            return lo;
        }

        int mid = (lo + hi) / 2;

        int cmp = keys[mid].compareTo(key);
        if (cmp < 0) {
            return rankByRecursion(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rankByRecursion(key, mid + 1, hi);
        } else {
            return mid;
        }

    }

    public int rankByIteration(Key key) {

        int lo = 0, hi = N - 1;

        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            int cmp = keys[mid].compareTo(key);
            if (cmp > 0) {
                hi = mid - 1;
            } else if (cmp < 0) {
                lo = mid + 1;
            } else {
                return mid;
            }


        }

        return lo;
    }


    public static void main(String[] args) {
        BinarySearchST<Integer, String> bst = new BinarySearchST<Integer, String>(20);

        bst.put(0, "A");
        bst.put(1, "B");
        bst.put(2, "C");
        bst.put(3, "D");
        bst.put(4, "E");
        bst.put(5, "F");

        System.out.println(bst.size());
        bst.delete(3);

        System.out.println(bst.get(4));
        System.out.println(bst.size());

    }

}
