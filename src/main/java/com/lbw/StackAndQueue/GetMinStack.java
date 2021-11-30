package com.lbw.StackAndQueue;

import java.util.Stack;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName GetMinStack.java
 * @Description 实现返回栈中最小元素的功能
 * @createTime 2021年01月25日 22:01:00
 */
public class GetMinStack {

    public static class MyStack{

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack(){
            dataStack = new Stack<Integer>();
            minStack  = new Stack<Integer>();
        }

        public void push(int value){
            if (dataStack.empty()){
                minStack.push(value);
            } else if(value <= minStack.peek()) {
                minStack.push(value);
            } else {
                minStack.push(minStack.peek());
            }
            dataStack.push(value);
        }

        public int pop(){
            if (dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }

            int value = dataStack.pop();
            minStack.pop();
            return value;
        }

        public int getMin(){
            if (dataStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return minStack.peek();
        }


    }

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
    }

}
