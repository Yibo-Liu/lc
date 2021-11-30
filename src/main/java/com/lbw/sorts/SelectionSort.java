package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

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
