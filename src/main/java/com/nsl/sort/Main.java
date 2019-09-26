package com.nsl.sort;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Integer[] a = {1, 4, 8, 2, 7, 5, 3, 6, 0, 14, 11, 17, 13, 19, 15, 20};

        System.out.print("初始数组：  ");
        SortTemplate.show(a);
//        Integer[] a = {3, 4, 7, 2, 1, 0, 5, 8};
//        Selection.sort(a);
//        Insertion.sort(a);
//        Shell.sort(a);
//        Merge.bottomToTopSort(a);
        Merge.topToBottomSort(a);

        System.out.print("排序结果：  ");
        SortTemplate.show(a);
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("time elasped: " + stopwatch);
    }
}
