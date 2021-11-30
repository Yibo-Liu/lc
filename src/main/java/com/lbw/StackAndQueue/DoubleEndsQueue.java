package com.lbw.StackAndQueue;

import com.lbw.NodeList.DoubleNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DoubleEndsQueue.java
 * @Description 使用Doublenode封装一个双端队列 并提供基本的前后出入队方法
 * @createTime 2021年01月27日 11:25:00
 */
public class DoubleEndsQueue {

    private DoubleNode head;
    private DoubleNode tail;

    public void addFromHead(int value){
        DoubleNode node = new DoubleNode(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {

            node.setNext(head);
            head.setPre(node);
            head = node;

        }
    }

    public void addFromBottom(int value){

        DoubleNode node = new DoubleNode(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setPre(tail);
            tail.setNext(node);
            tail = node;
        }

    }

    public Integer popFromHead(){

        if (head == null){
            return null;
        }

        int result = head.getValue();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            DoubleNode headNext = head.getNext();
            head.setNext(null);
            headNext.setPre(null);
            head = headNext;
        }
        return result;

    }

    public Integer popFromBottom(){

        if (head == null){
            return null;
        }

        int result = tail.getValue();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            DoubleNode tailBefore = tail.getPre();
            tail.setPre(null);
            tailBefore.setNext(null);
            tail = tailBefore;
        }
        return result;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public static class MyStack {
        private DoubleEndsQueue queue;

        public MyStack() {
            queue = new DoubleEndsQueue();
        }

        public void push(int value) {
            queue.addFromHead(value);
        }

        public int pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static class MyQueue {
        private DoubleEndsQueue queue;

        public MyQueue() {
            queue = new DoubleEndsQueue();
        }

        public void push(int value) {
            queue.addFromHead(value);
        }

        public int poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack myStack = new MyStack();
            MyQueue myQueue = new MyQueue();
            Stack<Integer> stack = new Stack<Integer>();
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }



}
