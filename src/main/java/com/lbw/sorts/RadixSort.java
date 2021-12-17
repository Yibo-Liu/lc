package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RadixSort.java
 * @Description
 *  基数排序实现
 * @createTime 2021年12月15日 15:35:00
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }



    //返回一个int正数数组的最大长度
    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }

        return res;

    }

    //代表在数组L到R上进行基数排序 在L到R上最大值的位数是maxbits
    private static void radixSort(int[] arr, int L, int R, int maxbits) {
        final int radix = 10;
        int i = 0, j = 0;

        //辅助空间
        int[] help = new int[R - L + 1];

        for (int d = 1; d <= maxbits; d++) {//有多少位就要进出几次

            //默认是10个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是1的数字有多少个
            // count[2] 当前位(d位)是(2)的数字有多少个
            // count[i] 当前位(d位)是i的数字有多少个
            int[] count = new int[radix];

            for (i = L; i <= R; i++) {
                //从左到右，找到特定的第d位，根据d位的值进桶，也就是把count的值加1（注意：count数组里面不是存原始的数，而是存某位的个数）
                j = getDigit(arr[i], d);
                count[j]++;
            }

            //此时count初始化完毕，然后把count进行一次升级，升级成累加的。
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个

            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            //然后初始化help数组。使用count升级版+help就可以完成入队出队动作。注意要从后往前遍历数组
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            //再把help复制会arr
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }

        }

    }

    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        System.out.println("RadixSort");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 10000;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(maxSize, maxValue, false);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            radixSort(arr1);
            Arrays.sort(arr2);
            if (!ArrayUtils.isEqual(arr1,arr2)) {
                succeed = false;
                ArrayUtils.printArray(arr1);
                ArrayUtils.printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Oops!");
    }

}
