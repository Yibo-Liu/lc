package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 选择排序的实现：
 *  两层for循环，第一层是挨个指向所有元素。第二层是看当前以及后面元素的最小值，放在第一层的位置。
 *  里层就是不断地求后面数组的最小值，放在外层的位置上。
 *  时间复杂度O(n^2) 空间复杂的O(1) 没有稳定性
 */
public class SelectionSort implements BowenSorts {


    public static void main(String[] args) {

        BowenSorts sorts = new SelectionSort();

        System.out.println(ArrayUtils.comparator(500000,100,Integer.MAX_VALUE,sorts));

    }

    public void sort(int[] arr) {

        for (int i = 0; i <= arr.length - 1; i++) {

            int minindex = i;
            for (int j = i; j <= arr.length - 1; j++) {

                if (arr[minindex] > arr[j]) {
                    minindex = j;
                }
            }
            ArrayUtils.swap(arr, i, minindex);
        }

    }
}
