package com.lbw.BS;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BSExists.java
 * @Description 使用二分法查找某一个数是否存在
 * @createTime 2021年01月25日 15:43:00
 */
public class BSExists {

    public static boolean BSExists(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;

        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return false;
    }

    public static boolean test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generateRandomArray(maxSize, maxValue,true);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != BSExists(arr, value)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(value);
                System.out.println("found Error!!");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
