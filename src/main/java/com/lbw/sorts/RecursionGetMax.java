package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RecursionGetMax.java
 * @Description 使用递归找到数组最大值
 * @createTime 2021年01月27日 14:17:00
 */
public class RecursionGetMax {

    public static int recursionGetMax(int[] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = recursionGetMax(arr, left, mid);
        int rightMax = recursionGetMax(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);

    }

    public static void main(String[] args) {

        int[] arr = ArrayUtils.generateRandomArray(10, 100, true);
        int myMax = recursionGetMax(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        int rightMax = arr[arr.length - 1];
        if (rightMax != myMax) {
            System.out.println(Arrays.toString(arr));
            System.out.println("Wrong");
        }

        System.out.println("finish");

    }

}
