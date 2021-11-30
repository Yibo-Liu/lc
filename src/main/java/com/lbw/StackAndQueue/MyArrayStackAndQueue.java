package com.lbw.StackAndQueue;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyArrayStackAndQueue.java
 * @Description 使用数组完成栈的功能
 * @createTime 2021年01月25日 20:42:00
 */
public class MyArrayStackAndQueue {

    public static class MyStack{
        private int[] arr;
        private int index;
        private int limit;

        public MyStack(int limit){
            arr = new int[limit];
            index = 0;
            this.limit = limit;
        }

        public void push(int value) {

            if (index == limit) {
                throw new RuntimeException("full");
            }


            arr[index] = value;
            index++;
        }

        public int pull() {
            if (index == 0) {
                throw new RuntimeException("empty");
            }

//            System.out.println("pull " + index);
            int res = arr[--index];

            return res;
        }
    }

    public static class MyQueue {
        private int[] arr;
        private int pushIndex;
        private int pullIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushIndex = 0;
            pullIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {

            if (size == limit) {
                throw new RuntimeException("full");
            }

            size++;
            arr[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }

        public int pull() {
            if (size == 0) {
                throw new RuntimeException("empty");
            }

            size--;
            int res = arr[pullIndex];
            pullIndex = nextIndex(pullIndex);
            return res;
        }

        private int nextIndex(int pushIndex) {
            return pushIndex < limit - 1 ? pushIndex + 1 : 0;
        }

    }

    public static void main(String[] args) {

//        MyArrayStack stack = new MyArrayStack();
//        MyQueue queue = new MyQueue(7);
//
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        System.out.println(queue.pull());
//        queue.push(5);
//        queue.push(6);
//        queue.push(7);
//        queue.push(8);
//        System.out.println(queue.pull());


        MyStack queue = new MyStack(7);
//
        queue.pull();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pull());
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(8);
        System.out.println(queue.pull());
        queue.push(8);
        queue.push(8);

    }


}
