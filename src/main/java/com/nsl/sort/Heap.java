package com.nsl.sort;

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
        for(int k = a.length / 2; k >=1; k--) {
            sink(a, k, N);
        }


        while (N > 1) {
            SortTemplate.exch(a, 0, --N);
            sink(a, 1, N);
        }


    }


    private static void sink(Comparable[] a, int k, int N) {

        while (2*k <= N) {

            int j = 2*k;  //左孩子节点，根节点起始位置标记为1。若为0， 则左孩子节点为2k+1

            //此时j指针指向k 的左孩子节点，若k的左孩子小于右孩子，则将j的指针 +1 移动到k的右孩子上
            if (j < N && SortTemplate.less(a[j - 1], a[j])) { // j < N 说明有孩子节点 ,堆的根从1开始，数组下标从0开始

                j++;
            }

            //父节点大于孩子节点，则该子树满足顺序堆的有序性，退出，进行下一颗子树的判断
            if (SortTemplate.greater(a[k - 1], a[j - 1])) {   //此时j的指针指向右孩子节点。
                break;
            }

            //父节点比孩子节点小， 则交换
            SortTemplate.exch(a, k -1, j -1);
            k = j;
        }


    }

    public static void main(String[] args) {
        Integer[] a = {1, 4, 8, 2, 7, 5, 3, 6,6, 0, 14, 11};
        sort(a);
        SortTemplate.show(a);
    }


}
