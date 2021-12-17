package com.lbw.sorts;

import com.lbw.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BubbleSort.java
 * @Description 冒泡排序
 * 实现：
 *  相邻的挨个比较，大的放后面，小的放前面。这样一轮下来，最大的就在最后面了。
 *  接下来再做同样的循环，但是经过第一轮，已经找到了最大的，所以就不用判断最后一个位置了。这个在外层循环里面就可以控制。
 *  复杂度O(N^2) 空间O(1) 有稳定性
 *  稳定性就是看处理相同值时候的态度。冒泡排序，如果值相同，不会动。那就是保持了稳定性。
 *
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
