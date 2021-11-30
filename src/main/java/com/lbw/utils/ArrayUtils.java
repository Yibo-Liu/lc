package com.lbw.utils;

import com.lbw.sorts.BowenSorts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author admin
 * @title
 * @description 封装一些常用的数组方法 包含对数器等
 * @updateTime 1/25/21 2:20 PM
 * @throws
 */
public class ArrayUtils {

    /**
     * @throws
     * @title
     * @description 拷贝两个数组
     * @author admin
     * @updateTime 1/25/21 2:20 PM
     */
    public static int[] copyArray(int[] arr) {

        int[] arr_res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr_res[i] = arr[i];
        }

        return arr_res;

    }

    /**
     * @throws
     * @title
     * @description 判断两个int类型的数组是否相等
     * @author admin
     * @updateTime 1/25/21 2:20 PM
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {

        if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
            return false;
        }

        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1 != null && arr2 != null) {
            if (arr1.length != arr2.length) {
                return false;
            } else {
                for (int i = 0; i < arr1.length; i++) {
                    if (arr1[i] != arr2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }

        return true;

    }


    /**
     * @throws
     * @title
     * @description 生成一个随机的数组
     * @author admin
     * @updateTime 1/25/21 2:29 PM
     * containSameNumber 数组中可以包含相同元素
     */
    public static int[] generateRandomArray(int maxSize, int maxValue, boolean containSameNumber) {

        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }

        if (containSameNumber) {
            return arr;
        } else {
            Set<Integer> intSet = new HashSet<Integer>();
            for (int i = 0; i < arr.length; i++) {
                intSet.add(arr[i]);
            }

            int[] resarr = new int[intSet.size()];
            int index = 0;
            for (Integer i : intSet) {
                resarr[index] = i.intValue();
                index++;
            }
            return resarr;

        }


    }

    /**
     * @throws
     * @title
     * @description 交换数组中两个位置的数字
     * @author admin
     * @updateTime 1/25/21 2:39 PM
     */
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static String comparator(int testTime, int maxSize, int maxValue, BowenSorts sortBean) {

        boolean succeed = false;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(maxSize, maxValue, true);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            sortBean.sort(arr1);
            Arrays.sort(arr2);

            succeed = ArrayUtils.isEqual(arr1, arr2);
            if (!succeed) {
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                return "found Error!!";
            }
        }

        return "run " + testTime + " times, all right!!";

    }

    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
