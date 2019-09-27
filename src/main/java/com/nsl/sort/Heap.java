package com.nsl.sort;

import static com.nsl.sort.SortTemplate.*;

/**
 * 完全二叉树性质：对于任意节点，其位置为ｋ，则其左孩子节点位置为2k, 右孩子节点位置为2k+1（根节点位置标记为1）
 *
 * 有序堆(大顶堆)：任意节点大于或等于其左右孩子节点。 ==> 根节点最大
 *
 *
 */
public class Heap {


    public static void sort(Comparable[] a) {

        int N = a.length;
        /*=====构建有序堆===*/
        for(int k = N / 2 -1; k >=0; k--) {
            sink(a, k, N);
        }

        System.out.print("有序堆： ");
        show(a);

        /*====下沉排序===*/
        while (N > 1) {
            exch(a, 0, --N);
            sink(a, 0, N);
        }


    }


    /**
     *
     * @param a 待排数组
     * @param k 需要构建子堆的节点
     * @param N 数组长度
     */
    private static void sink(Comparable[] a, int k, int N) {

        while (k <= N /2 -1) {

            int j = 2*k + 1;  //左孩子节点，根节点起始位置标记为1。若为0， 则左孩子节点为2k+1

            //此时j指针指向k 的左孩子节点，若k的左孩子小于右孩子，则将j的指针 +1 移动到k的右孩子上
            if ((j < N -1) && less(a[j], a[j + 1])) { // j < N 说明有孩子节点 ,堆的根从1开始，数组下标从0开始

                j++;
            }

            //父节点大于孩子节点，则该子树满足顺序堆的有序性，退出，进行下一颗子树的判断
            if (greater(a[k], a[j])) {   //此时j的指针指向右孩子节点。
                break;
            }

            System.out.println(String.format("swap(%s, %s)",k, j));
            //父节点比孩子节点小， 则交换
            exch(a, k, j);
            k = j;
        }


    }

    public static void main(String[] args) {
//        Integer[] a = {1, 4, 8, 2, 7, 5, 3, 6,6, 0, 14, 11};
        Integer[] a = {3, 4, 7, 2, 1, 0, 5, 9};
        sort(a);
        show(a);
    }


}
