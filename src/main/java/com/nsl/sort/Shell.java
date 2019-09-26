package com.nsl.sort;

import static com.nsl.sort.SortTemplate.exch;
import static com.nsl.sort.SortTemplate.less;
import static com.nsl.sort.SortTemplate.show;

/***
 * Shell 排序是基于插入排序的一种排序算法
 * 思想，中间任意间隔为h的数组都是有序的
 */
public class Shell {

    public static void sort(Comparable[] a) {

        int h = 1;

        int N = a.length;

        while (h < N / 3) {
            h = h * 3 + 1;
        }

        System.out.println("current h:" + h);

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {

                for (int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    System.out.print(j + "<====>" + (j - h) + "  h=" + h + " :");
                    show(a);
                    exch(a, j, j-h);
                }

            }
            h = h / 3;
        }

    }
}
