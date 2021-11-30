package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

import static com.lbw.utils.ArrayUtils.swap;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PartitionAndQuickSort.java
 * @Description 快排
 * 把数组中的数，小于某个值的放左边，大于某个值的放在右边
 * @createTime 2021年11月19日 14:56:00
 *
 * 分成三种实现：
 * 快排1.0版本：
 *  以某个数i做为比较对象，把小于等于的放在左边，大于的放在右边，最后一步再把这个数字归位。
 *  归位后，i的位置就固定了，也就是此时i的位置和排完序后i的位置相同。
 *  以此类推，把数组中每个数都作为i，进行此过程。
 *  O(n2)
 *
 * 快排2.0版本：
 *  借助荷兰国旗问题，一次性搞定i以及等于i的数。也就是等于i的数不用遍历了。
 *  O(n2)
 *
 * 快排3.0版本：
 *  i的选取为随机选，这样可以做到复杂度为O(nlogn)
 */
public class PartitionAndQuickSort {

    private static int partition(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }

        if (left == right) {
            return left;
        }

        int lessEqual = left-1;//小于等于区边界

        int index = left;//起始位置

        while (index < right) {
            if (arr[index] <= arr[right]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }

        swap(arr,right,++lessEqual);
        return lessEqual;
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr,0,arr.length-1);
    }

    private static void process1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int M = partition(arr, left, right);
        process1(arr, left, M - 1);
        process1(arr, M + 1, right);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, left, right);
        process2(arr, left, equalArea[0] - 1);
        process2(arr,equalArea[1]+1,right);
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        ArrayUtils.swap(arr,left+(int)(Math.random()*(right-left+1)),right);
        int[] equalArea = netherlandsFlag(arr, left, right);
        process3(arr, left, equalArea[0] - 1);
        process3(arr,equalArea[1]+1,right);

    }


    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    //  <arr[R]  ==arr[R]  > arr[R]
    // 返回等于区域左边界与右边界
    public static int[] netherlandsFlag(int[] arr, int left, int right) {

        if (left > right) {
            return new int[]{-1, -1};
        }

        if (left == right) {
            return new int[]{left, right};
        }

        int less = left - 1;
        int more = right;
        int index = left;

        while (index < more) {
            if (arr[index] == arr[right]) {
                index++;
            } else if (arr[index] < arr[right]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr,index,--more);
            }
        }

        swap(arr,more,right);
        return new int[]{less + 1, more};


    }

    public static void main(String[] args) {
        System.out.println("Partition And QuickSort");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 10000;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(maxSize, maxValue, false);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            quickSort3(arr1);
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
