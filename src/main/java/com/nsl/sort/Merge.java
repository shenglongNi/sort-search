package com.nsl.sort;

import static com.nsl.sort.SortTemplate.less;

public class Merge {

    private static Comparable[] temp;


    public static void topToBottomSort(Comparable[] a) {


        temp = new Comparable[a.length];
        topToBottomInnerSort(a, 0, a.length - 1);

    }

    public static void bottomToTopSort(Comparable[] a) {
        bottomToTopInnerSort(a);
    }


    /**
     * @param a     排序数组
     * @param left  左指针
     * @param right 右指针
     *              <p>
     *              此方法为自顶向下的递归方法， 递归的结束条件：当left >= right 是， 说明已经递归到两个相邻的元素，此时退出递归
     */
    private static void topToBottomInnerSort(Comparable[] a, int left, int right) {

        //当left = right 时，说明数组已经被切分为最小的单个元素了，退出递归。
        if (left >= right) {
            return;
        }

        System.out.println(String.format("sort(%s, %s)", left, right));

        int mid = (right + left) / 2;  //采用中分切割数组
        topToBottomInnerSort(a, left, mid);   // 递归切分左边数组
        topToBottomInnerSort(a, mid + 1, right);  //递归切割右边数组

        merge(a, left, mid, right); //切割完毕， 开始归并
    }


    /**
     * @param a 待排序数组
     *          自底向上的归并排序
     */
    private static void bottomToTopInnerSort(Comparable[] a) {

        int N = a.length;
        temp = new Comparable[a.length];
        for (int sz = 1; sz < N; sz = 2 * sz) { //外循环控制需要归并的两个子数组元素个数， 1, 2, 4, 8 ...

            for (int lo = 0; lo + sz < N; lo = lo + 2 * sz) { //内循环根据sz来两两归并子数组， lo 子数组索引
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }


    }


    /**
     * 此处采用原地归并，只需要一个复制数组， 不需每次生成新的数组来保存归并的结果。
     */
    private static void merge(Comparable[] a, int left, int mid, int right) {

        System.out.println(String.format("merge(%s, %s, %s)", left, mid, right));
        int i = left, j = mid + 1;

        //将涉及归并的元素a[left...right]复制到辅助数组中
        for (int k = left; k <= right; k++) {
            temp[k] = a[k];
        }

        //将辅助数组中的元素归并到原数组的a[left..right]的位置
        //这里是通过指针将a[left..right] 分割成a[left..mid], a[mid+1..right]两个数组
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = temp[j++]; //归并右边数组剩余的元素
            } else if (j > right) {
                a[k] = temp[i++];  //归并左边数组剩余的元素
            } else if (less(temp[j], temp[i])) {
                a[k] = temp[j++];   //比较归并
            } else {
                a[k] = temp[i++];  //比较归并, 这里为什么a[i] = a[j]时 ， 取temp[i] 并指针i++, 为什么不需要j++?
                //这里用到了一个定义： 归并排序的两个子数组必须是有序数组。
            }

        }


    }


}
