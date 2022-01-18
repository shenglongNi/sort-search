package com.nsl.sort;

import static com.nsl.sort.SortTemplate.*;
import static com.nsl.sort.SortTemplate.less;

/**
 * 插入排序
 */
public class Insertion {

    public static void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {

            for (int j = i; j > 0 && less(a[j], a[j-1]) ; j--) {
//                show(a);
                exch(a, j, j-1);
            }
        }
        show(a);
    }
}
