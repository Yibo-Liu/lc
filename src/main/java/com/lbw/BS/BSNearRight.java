package com.lbw.BS;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BSNearRight.java
 * @Description 找到 <= value 的最右侧位置
 * @createTime 2021年01月25日 16:35:00
 */
public class BSNearRight {

    public static int bsNearRight(int[] arr, int value){

        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int index = -1;

        while(L<=R){
            mid = L + ((R-L)>>1);

            if(arr[mid] <= value){
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return index;

    }

    // for test
    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
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
            if (test(arr, value) != bsNearRight(arr, value)) {
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
