package com.lbw.Heap;

import com.lbw.utils.ArrayUtils;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Heap01.java
 * @Description
 * 堆的实现；大根堆
 * @createTime 2021年11月24日 16:16:00
 */
public class Heap01 {
    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSise;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSise = 0;
        }

        public boolean isEmpty() {
            return heapSise == 0;
        }

        public boolean isFull() {
            return heapSise == limit;
        }

        public void push(int value) {
            if (heapSise == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSise] = value;
            heapInsert(heap, heapSise++);
        }

        private void heapInsert(int[] heap, int index) {
            //heap[index]就是新进来的数
            while (heap[index] > heap[(index - 1) / 2]) {
                ArrayUtils.swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public int pop() {
            int ans = heap[0];
            //用最后一个数，顶到最前面。并把heapSize减1.这样相当于最后一个数失效了
            ArrayUtils.swap(heap, 0, --heapSise);
            heapify(heap, 0, heapSise);//从0位置开始，heapify
            return ans;
        }

        // 从index位置，往下看，不断的下沉，
        // 停：我的孩子都不再比我大；已经没孩子了
        private void heapify(int[] heap, int index, int heapSise) {
            int left = index * 2 + 1;
            while (left < heapSise) {//代表我有孩子，不越界
                // 左右两个孩子中，谁大，谁把自己的下标给largest
                // 右孩子较大的成立条件 ：  1) 有右孩子   && 2）右孩子的值比左孩子大才行
                // 否则，左
                int largest = left + 1 < heapSise && heap[left + 1] > heap[left] ? left + 1 : left;
                //经过上面代码后，largest变成了两个孩子中较大孩子的下标
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                ArrayUtils.swap(heap, index, largest);
                index = largest;
                left = index * 2 + 1;
            }
        }

        public static class RightMaxHeap{//一定对的堆

            private int[] arr;
            private final int limit;
            private int size;

            public RightMaxHeap(int limit) {
                arr = new int[limit];
                this.limit = limit;
                size = 0;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull() {
                return size == limit;
            }

            public void push(int value) {
                if (size == limit) {
                    throw new RuntimeException("heap is full");
                }
                arr[size++] = value;
            }

            public int pop() {
                int maxIndex = 0;
                for (int i = 1; i < size; i++) {
                    if (arr[i] > arr[maxIndex]) {
                        maxIndex = i;
                    }
                }
                int ans = arr[maxIndex];
                arr[maxIndex] = arr[--size];
                return ans;
            }
        }

        public static void main(String[] args) {
            int value = 1000;
            int limit = 100;
            int testTimes = 1000000;
            for (int i = 0; i < testTimes; i++) {
                int curLimit = (int) (Math.random() * limit) + 1;
                MyMaxHeap my = new MyMaxHeap(curLimit);
                RightMaxHeap test = new RightMaxHeap(curLimit);
                int curOpTimes = (int) (Math.random() * limit);
                for (int j = 0; j < curOpTimes; j++) {
                    if (my.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops!");
                    }
                    if (my.isFull() != test.isFull()) {
                        System.out.println("Oops!");
                    }
                    if (my.isEmpty()) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else if (my.isFull()) {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    } else {
                        if (Math.random() < 0.5) {
                            int curValue = (int) (Math.random() * value);
                            my.push(curValue);
                            test.push(curValue);
                        } else {
                            if (my.pop() != test.pop()) {
                                System.out.println("Oops!");
                            }
                        }
                    }
                }
            }
            System.out.println("finish!");

        }

    }
}
