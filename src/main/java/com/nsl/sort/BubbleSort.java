package com.nsl.sort;

import static com.nsl.sort.SortTemplate.*;

public class BubbleSort {


    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length - 1  ; i++) {
            for (int j = 0; j < a.length -1 -i ; j++) {
                if (less(a[j+1], a[j])) {
                    exch(a, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {3, 4, 7, 2, 1, 0, 5, 9};
        sort(a);
        show(a);
    }
}
