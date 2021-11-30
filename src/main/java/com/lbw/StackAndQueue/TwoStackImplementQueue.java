package com.lbw.StackAndQueue;

import java.util.Stack;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TwoStackImplementQueue.java
 * @Description 使用两个栈结构实现队列的功能
 * @createTime 2021年01月25日 22:31:00
 */
public class TwoStackImplementQueue {

    public static class MyQueue {
        private Stack<Integer> firstStack;
        private Stack<Integer> lastStack;

        public MyQueue() {
            firstStack = new Stack<Integer>();
            lastStack = new Stack<Integer>();
        }

        public void push(int value) {
            firstStack.push(value);
        }

        public int pop() {
            if (lastStack.empty()) {
                if (firstStack.empty()) {
                    throw new RuntimeException("empty");
                } else {
                    do {
                        lastStack.push(firstStack.pop());
                    } while (!firstStack.empty());
                }
            }

            return lastStack.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        test.push(1);
        test.push(2);
        test.push(3);
//        System.out.println(test.peek());
        System.out.println(test.pop());
        test.push(4);
        test.push(5);
        test.push(6);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());

    }

}
