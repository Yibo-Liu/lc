package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BubbleSort.java
 * @Description 冒泡排序
 * @createTime 2021年01月25日 14:41:00
 */
public class BubbleSort implements BowenSorts {


    public static void main(String[] args) {

        BowenSorts sorts = new BubbleSort();

        System.out.println(ArrayUtils.comparator(500000,100,Integer.MAX_VALUE,sorts));
    }



    public void sort(int[] arr) {
        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }

            }

        }

    }
}
