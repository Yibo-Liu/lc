package com.lbw.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Heap02.java
 * @Description
 *
 * 自己定义堆结构，实现泛型类型的堆排序。
 * 如果单纯完成上面的需求，那只要实现自定义比较器就行。
 * 但现在要做的更多，比如一个对象，已经放在了最大堆中特定的位置，对象里面的某个属性值变了
 * 如果使用系统自带的堆，不会进行排序或排序复杂度高
 * 这就要自己实现一个堆，完成上述需求
 * @createTime 2021年12月01日 16:16:00
 */
public class Heap02 {

    //堆
    public static class MyHeap<T> {

        private ArrayList<T> heap;
        private HashMap<T,Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com) {
            heap = new ArrayList<T>();
            indexMap = new HashMap<T, Integer>();
            heapSize = 0;
            comparator = com;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T key) {
            return indexMap.containsKey(key);
        }

        public void push(T value) {
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize++);
        }

        private void heapInsert(int index) {
            while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                swap(index,(index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(i, o2);
            heap.set(j, o1);
            indexMap.put(o1, j);
            indexMap.put(o2, i);
        }

        public void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && (comparator.compare(heap.get(left + 1), heap.get(left)) < 0)
                        ? left + 1
                        : left;

                largest = (comparator.compare(heap.get(largest), heap.get(index)) < 0)
                        ? largest
                        : index;

                if (largest == index) {
                    break;
                }

                swap(largest, index);
                index = largest;
                left = index * 2 + 1;

            }
        }

        //resign方法 解决的就是已入堆的对象值被修改
        public void resign(T value) {
            int valueIndex = indexMap.get(value);
            heapInsert(valueIndex);
            heapify(valueIndex,heapSize);
            //两个逻辑都放上，但代码执行的时候，只会走某一个逻辑，要么向上要么向下

        }

    }

}
