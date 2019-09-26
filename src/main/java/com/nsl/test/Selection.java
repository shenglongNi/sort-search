package com.nsl.test;

import com.nsl.sort.SortTemplate;

import java.util.Arrays;

public class Selection {


    public static void sort(int[] a) {

        for (int i = 0; i < a.length -1; i++) {

            int min = i;

            for(int j = i + 1; j <=a.length - 1;j++) {

                if (a[j] < a[min]) {
                    min = j;
                }

            }

            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;

        }


    }


    public static void insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {

            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {

                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;


            }


        }



    }


    public static void shellSort(int[] a) {


        int N = a.length;
        int h = N / 3 + 1;

        while (h >= 1) {

            for (int i = h; i < a.length; i++) {

                for (int j = i; j >= h && a[j] < a[j-h] ; j-=h) {
                    int tmp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = tmp;
                }
                
            }
            h = h / 3;

        }

    }

    public static void merge(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, 0, a.length - 1, tmp);

    }

    public static void mergeSort(int[] a, int lo, int hi, int[] tmp) {


        if (lo >= hi) {
            return;
        }


        int mid = (hi + lo) / 2;

        mergeSort(a, lo, mid, tmp);
        mergeSort(a,mid + 1, hi, tmp);

        merge(a, lo, mid, hi, tmp);




    }

    private static void merge(int[] a, int lo , int mid , int hi, int[] tmp) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi ; k++) {
            tmp[k] = a[k];
        }

        for (int k = lo; k <= hi ; k++) {

            if (i > mid) {
                a[k] = tmp[j++];
            } else if (j > hi) {
                a[k] = tmp[i++];
            } else if (tmp[j] < tmp[i]) {
                a[k] = tmp[j++];
            } else {
                a[k] = tmp[i++];
            }


        }


    }

    public static void bottomToTopMergeSort(int[] a) {

        int N = a.length;

        int[] tmp = new int[a.length];

        for (int sz = 1; sz < N ; sz++) {

            for (int lo = 0; lo + sz < N; lo = lo + 2 * sz) {

                merge(a, lo, lo + sz -1, Math.min(lo + 2* sz -1, N -1), tmp);

            }

        }


    }


    public static void quickSort(int[] a) {
        innerQuickSort(a, 0, a.length -1);

    }

    private static void innerQuickSort(int[] a, int lo, int hi) {


        if (lo >= hi) {
            return;
        }

        int baseIndex = partition(a, lo, hi);
        innerQuickSort(a, lo, baseIndex);
        innerQuickSort(a, baseIndex + 1, hi);

    }

    private static int partition(int[] a, int lo, int hi) {


        int k = lo;
        int v = a[lo];

        while (lo < hi) {

            while (lo < hi && v <= a[hi]) {
                hi--;
            }

            int j = hi;
            while (lo < hi && v >= a[lo]) {
                lo++;
            }
            int i = lo;

            swap(a, i,j);

        }

        swap(a, k , lo);


        return lo;

    }

    private static void swap(int[] a, int i, int j) {

        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }



    public static void main(String[] args) {
        int[] a = {3, 4, 7, 2, 1, 0, 5, 3};
//        sort(a);
//        insertionSort(a);
//        shellSort(a);
//        merge(a);
//        bottomToTopMergeSort(a);
        quickSort(a);
        System.out.println( Arrays.toString(a));
    }


}
