package com.lbw.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SortArrayDistanceLessK.java
 * @Description
 * 算法题：
 * 已知一个几乎有序的数组，几乎有序是指：如果把数组排好顺序的话，每个元素移动举例一定不超过K
 * 并且K相对于数组长度来说是比较小的
 *
 * 请选择一个合适的排序策略，对这个数组进行排序
 *
 * 思路：
 *  将前K+1个数，放在一个小跟堆里面。然后弹出小跟堆第一个数，则这个数就可以放在最前面。
 *  再放入后面一个数，弹出最小数，放在最前。以此类推。
 *  小根堆使用java自带的结构
 * @createTime 2021年11月30日 15:35:00
 */
public class SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr,int k){

        if (k == 0) {
            return;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int index = 0;

        for (; index <= Math.min(arr.length - 1, k - 1); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    // for test
    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int K) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        // 先排个序
        Arrays.sort(arr);
        // 然后开始随意交换，但是保证每个数距离不超过K
        // swap[i] == true, 表示i位置已经参与过交换
        // swap[i] == false, 表示i位置没有参与过交换
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (K + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }


}
