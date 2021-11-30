package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SmallSum.java
 * @Description 小和问题 求数组的小和
 * 数组小和就是，某个数，左边所有比他小的，累加起来作为这个数的小和。
 * 然后把所有数的小和都累加，就是数组的小和。
 * @createTime 2021年11月19日 10:01:00
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return process(arr,left,mid)
                + process(arr,mid+1,right)
                +merge(arr,left,mid,right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        int res = 0;

        while (p1 <= mid && p2 <= right) {
            res += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    //对数器
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }

        return res;

    }


    public static void main(String[] args) {
        System.out.println("Small Sum");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 10000;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(maxSize, maxValue, false);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                ArrayUtils.printArray(arr1);
                ArrayUtils.printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Oops!");


    }
}
