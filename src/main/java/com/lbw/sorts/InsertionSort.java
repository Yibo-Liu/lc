package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName InsertionSort.java
 * @Description 插入排序
 * @createTime 2021年01月25日 15:12:00
 */
public class InsertionSort implements BowenSorts {

    public static void main(String[] args) {

        BowenSorts sorts = new InsertionSort();
        System.out.println(ArrayUtils.comparator(500000, 100, Integer.MAX_VALUE, sorts));
    }


    public void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
//            for (int j = i-1; j >= 0; j--) {
//                if (arr[j] > arr[j+1]){
//                    ArrayUtils.swap(arr,j,j+1);
//                }
//            }
            //以上这么写功能能实现，但是没有及时停，及如果判断出前面的数已经比后面的小了，就不用再往前看了。因为之前的已经有序了

            for (int j = i - 1; j >= 0 && (arr[j] > arr[j + 1]); j--) {

                ArrayUtils.swap(arr, j, j + 1);

            }

        }

    }
}
