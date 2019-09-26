package com.nsl.sort;

import static com.nsl.sort.SortTemplate.exch;
import static com.nsl.sort.SortTemplate.less;
import static com.nsl.sort.SortTemplate.show;

/**
 * 最简单的排序方式
 */
public class Selection {


    public static void sort(Comparable[] a) {

        int N = a.length;
        for (int i = 0; i < a.length; i++) {
            int min = i;

            for(int j = i + 1; j < N; j++){

                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            System.out.print(i + "<==>" + min + "  ");
            show(a);
            exch(a, i, min);
        }

    }


}
