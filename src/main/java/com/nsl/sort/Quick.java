package com.nsl.sort;

import java.util.Arrays;
import java.util.Collections;

import static com.nsl.sort.SortTemplate.*;

public class Quick {


    public static void sort(Comparable[] a) {
//        Collections.shuffle(Arrays.asList(a));
        show(a);
        innerSort(a, 0, a.length - 1);

    }

    private static void innerSort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        //通过基准点索引，对数组递归分割
        int index = partition2(a, lo, hi);

        System.out.print(String.format("{%s, %s, %s}   ", lo, index, hi));
        show(a);

        innerSort(a, lo, index -1);
        innerSort(a, index + 1, hi);


    }


    /**
     * 二分
     *
     */
    private static int partition(Comparable[] a, int lo , int hi) {


        int k = lo;
        Comparable v = a[lo]; // 选择左指针首元素为基准元素


        while (lo < hi) {

            // 右指针向左迭代， 寻找比基准点小的元素
            while (lo < hi && greater(a[hi--], v)) {

            }

            //记录右指针找到的元素的索引
            int j = hi;

            //右指针找到比基准点大的元素后， 左指针开始向右迭代，寻找比基准元素大的元素
            while (lo < hi && less(a[++lo], v)) {

            }


            // 记录左指针找到的元素索引
            int i = lo;



            // 交换元素位置，并开始下一轮迭代，直到 lo >= hi
            exch(a, i, j);

//            SortTemplate.show(a);


        }


        //当lo >= hi 后，将基准点插入到hi位置，此时一趟排序完成
        exch(a, k, hi);

        return lo;
    }

    private static int partition2(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {

            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }

        exch(a, lo, j);


        return j;
    }



    /**
     * 三向切分快速排序
     * 旨在 有大量重复元素的情况下，使得重复的基准元素不在递归子序列中，提高排序效率
     */
    public static class Quick3way{


        public static void sort(Comparable[] a) {

            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (lo >= hi) {
                return;
            }
            int lt = lo, gt = hi, i = lo + 1;

            Comparable v = a[lo];

            while (i <= gt) {

                int cmp = a[i].compareTo(v);
                if (cmp < 0) {
                    exch(a, i++, lt++);
                } else if (cmp > 0) {
                    exch(a, i, gt--);
                } else {
                    i++;
                }

            }

            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);

        }

    }


    public static void main(String[] args) {
        Comparable[] a = {6, 4, 8, 2, 7,7, 5, 3, 9, 0, 14, 8,11, 1, 6};
        Comparable[] b = {6, 4, 8, 2, 7,7, 5, 3, 9, 0, 14, 8,11, 1,6};
        sort(a);
        show(a);

        System.out.println("============");
        Quick.Quick3way.sort(b);
        show(b);
    }
}
