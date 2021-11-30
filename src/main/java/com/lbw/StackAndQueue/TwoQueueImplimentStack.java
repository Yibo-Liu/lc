package com.lbw.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TwoQueueImplimentStack.java
 * @Description 使用两个队列实现栈结构
 * @createTime 2021年01月25日 22:48:00
 */
public class TwoQueueImplimentStack {

    public static class MyStack{

        private Queue<Integer> data;
        private Queue<Integer> help;

        public MyStack() {
            this.data = new LinkedList<Integer>();
            this.help = new LinkedList<Integer>();
        }

        public void push(int value){
            data.add(value);
        }

        public int pop(){
            int res = 0;
            if(data.isEmpty()){
                throw new RuntimeException("empty");
            } else if(data.size() == 1) {
                res = data.poll();
            } else {
                while (data.size() > 1){
                    help.add(data.poll());
                }
                res = data.poll();
                Queue<Integer> tmp = data;
                data = help;
                help = tmp;
            }

            return res;
        }

        public int peek(){
            int res = 0;
            if(data.isEmpty()){
                throw new RuntimeException("empty");
            } else if(data.size() == 1) {
                res = data.peek();
            } else {
                while (data.size() > 1){
                    help.add(data.poll());
                }
                res = data.peek();
                help.add(data.poll());
                Queue<Integer> tmp = data;
                data = help;
                help = tmp;
            }

            return res;
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        MyStack myStack = new MyStack();
        Stack<Integer> test = new Stack<Integer>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (myStack.peek()!=test.peek()) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (myStack.pop()!=test.pop()) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
            if (i==(testTime-1)){
                System.out.println(testTime);
            }
        }

        System.out.println("test finish!");

    }
}
