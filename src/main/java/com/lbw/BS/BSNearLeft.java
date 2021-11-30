package com.lbw.BS;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BSNearLeft.java
 * @Description 找到满足>=value的最左位置
 * @createTime 2021年01月25日 16:15:00
 *
 * 自己没做出来，需要重写！！
 */
public class BSNearLeft {


    public static int bsNearLeft(int[] arr, int value){

        int L = 0;
        int R = arr.length - 1;
        int index = -1;//记录最左侧的对号
        int mid = 0;

        while(L<=R){
            mid = L + ((R-L)>>1);

            if(arr[mid]>=value){
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return index;

    }

    // for test
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
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
            if (test(arr, value) != bsNearLeft(arr, value)) {
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
