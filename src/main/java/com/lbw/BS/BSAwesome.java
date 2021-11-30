package com.lbw.BS;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BSAwesome.java
 * @Description 找到一个局部最小值
 * @createTime 2021年01月25日 16:53:00
 */
public class BSAwesome {


    public static int bsAwesome(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int L = 1;
        int R = arr.length - 2;
        int mid = 0;

        while (L < R){

            mid = L + ((R - L) >> 1);
            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                return mid;
            } else if (arr[mid] < arr[mid-1]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }

        }
        return L;
    }

    public static int test(int[] arr, int index) {

        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        if(arr[index] < arr[index-1] && arr[index] < arr[index+1]){
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = ArrayUtils.generateRandomArray(maxSize, maxValue,false);
            Arrays.sort(arr);
            int res = bsAwesome(arr);
            int res2 = test(arr,res);
            if (res != res2) {
                System.out.println(Arrays.toString(arr));
                System.out.println("found Error!!");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
