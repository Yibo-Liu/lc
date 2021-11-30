package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MergeSort.java
 * @Description TODO
 * @createTime 2021年11月15日 16:43:00
 * <p>
 * 归并排序 整体思路：
 * 1、左边有序
 * 2、右边有序
 * 3、merge
 * <p>
 * 可以使用递归来实现
 */
public class MergeSort {

    //递归实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);


    }

    private static void process(int[] arr, int start, int end) {
        if (start == end) return;// base case 也就是到了最小规模就可以停了

        int mid = start + ((end - start) >> 1);
        process(arr, start, mid);
        process(arr, mid + 1, end);
        merge(arr, start, mid, end);

    }

    private static void merge(int[] arr, int start, int mid, int end) {

        int[] help = new int[end - start + 1];
        int i = 0;
        int p1 = start;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= end) { //p1 p2 都不越界
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];//谁小拷贝谁
        }

        //要么p1越界 要么p2越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= end) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }

    }

    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 10000;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(maxSize, maxValue, false);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            mergeSort2(arr1);
            Arrays.sort(arr2);
            if (!ArrayUtils.isEqual(arr1, arr2)) {
                succeed = false;
                ArrayUtils.printArray(arr1);
                ArrayUtils.printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Oops!");

    }

    //非递归实现
    public static void mergeSort2(int[] arr) {
        //设置一个窗口，初始值是2，一个循环把窗口内的数排好序 然后再把窗口大小*2 直到窗口大小大于数组长度
        if (arr == null || arr.length < 2) {
            return;
        }

        int mergeSize = 1;
        int N = arr.length;

        while (mergeSize < N) {
            int left = 0;

            while (left < N) {
                int mid = left + mergeSize - 1;
                if (mid >= N) {//左组都凑不齐了，break掉
                    break;
                }
                int right = Math.min(mid + mergeSize, N - 1);
                merge(arr, left, mid, right);
                left = right + 1;
            }

            if (mergeSize > N/2) break;


            mergeSize <<= 1;
        }


    }
}
