package com.lbw.Heap;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HeapSort.java
 * @Description
 * 堆排序的实现
 * 思路分成两步：
 * 1、把数组想象成是一个数字一个数字来的，这样构建一个大根堆
 * 2、构建完大根堆以后，把第一个数字放在最后，那第一个数字就固定位置了，剩下的再调整为大根堆
 *  重复2动作即可。
 * @createTime 2021年11月30日 13:58:00
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }

        //这三行代码是优化上面代码的，复杂度O(N)
        //这个就是，把给定的数组，想象成已经是一个堆了，然后从最底下开始往上调整成大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }


        int heapSize = arr.length;
        ArrayUtils.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            ArrayUtils.swap(arr, 0, --heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {

        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            ArrayUtils.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    //arr[index]是刚来，调整成大根堆
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtils.swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
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
            heapSort(arr1);
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
}
