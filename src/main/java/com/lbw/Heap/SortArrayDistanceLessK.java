package com.lbw.Heap;

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
}
