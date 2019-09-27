package com.nsl.sort;

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
        int index = partition(a, lo, hi);

        System.out.print(String.format("{%s, %s, %s}   ", lo, index, hi));
        show(a);

        //注意：此处的 hi = index -1, 因为index 为基准点位置， 一趟排序完成后，
        // 基准点已经排定， 再次递归时，只需要排定基准点两边的子数组即可
        innerSort(a, lo, index - 1);

        //此处的 lo = index + 2 ,理由同上
        innerSort(a, index + 1, hi);


    }


    /**
     * 二分
     */
    private static int partition(Comparable[] a, int lo, int hi) {


        int k = lo;
        Comparable v = a[lo]; // 选择左指针首元素为基准元素


        while (lo < hi) {

            // 右指针向左迭代， 寻找比基准点小的元素
            while (lo < hi && greater(a[hi], v)) {
                hi--;

            }

            //右指针找到比基准点大的元素后， 左指针开始向右迭代，寻找比基准元素大的元素
            while (lo < hi && lessEq(a[lo], v)) {
                lo++;
            }


            if (lo < hi && less(a[hi], a[lo])) {
                // 交换元素位置，并开始下一轮迭代，直到 lo >= hi
                exch(a, lo, hi);
            }


//            SortTemplate.show(a);


        }


        //当lo >= hi 后，将基准点插入到hi位置，此时一趟排序完成
        exch(a, k, hi);

        return lo;
    }

    /**
     * 第二种分区方法
     */
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
     * 从左边遍历数组，维护一个指针lt, 使得a[lo..lt-1] 中的元素都小于基准元素v，
     * 指针gt，使得a[gt+1..hi]中的元素都大于v
     * 一趟遍历完成，此时数组中的a[lo..lt-1] < v , a[lt..gt] = v, a[gt+1..hi] >v
     */
    public static class Quick3way {


        public static void sort(Comparable[] a) {

            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            //递归退出条件
            if (lo >= hi) {
                return;
            }

            //初始化指针，关键： i = lo +1,  a[lt..i-1] =v, 当i = gt时， 说明遍历完成
            //此时a[lo, lt -1] < v, a[lt..gt] = v, a[gt+1..hi] > v
            int lt = lo, gt = hi, i = lo + 1;


            //选基准元素
            Comparable v = a[lo];

            //从左向右单向遍历,直到 i > gt
            while (i <= gt) {

                int cmp = a[i].compareTo(v);

                //3向切分的主要逻辑：
                /*
                    a[i] < v, 交换a[i], a[lt] , i++, lt++
                    a[i] > v, 交换a[i], a[gt], gt--.
                    a[i] = v , i++

                 */
                if (cmp < 0) {
                    exch(a, i++, lt++);
                } else if (cmp > 0) {
                    exch(a, i, gt--);
                } else {
                    i++;
                }

            }

            System.out.print(String.format("{lt=%s, gt=%s}   ", lt, gt));
            show(a);

            //递归
            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);

        }

    }


    public static void main(String[] args) {
        Comparable[] a = {6, 4, 8, 2, 7, 7, 5, 3, 9, 0, 14, 8, 11, 1, 6};
        Comparable[] b = {6, 4, 6, 8, 6, 11, 2, 7, 6, 7, 5, 3, 9, 0, 14, 8, 11, 1, 6};
        Comparable[] c = {3, 4, 7, 2, 1, 0, 5, 3};
//        sort(b);
        Quick3way.sort(b);
        show(b);

    }
}
