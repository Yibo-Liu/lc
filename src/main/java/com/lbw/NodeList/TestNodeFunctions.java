package com.lbw.NodeList;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestNodeFunctions.java
 * @Description 测试本package下面方法功能
 * @createTime 2021年01月26日 10:54:00
 */
public class TestNodeFunctions {

    public static void main(String[] args) {

        int len = 50;
        int value = 100;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            Node node1 = NodeListUtils.generateRandomLinkedList(len, value);
            Node reverse1 = NodeListUtils.reverseList(node1);
            Node back1 = NodeListUtils.testReverseList(reverse1);
            if (!NodeListUtils.checkLinkedListEqual(node1, back1)) {
                System.out.println("oops!");
                break;
            }

            DoubleNode node2 = NodeListUtils.generateRandomDoubleList(len, value);
            DoubleNode reverse2 = NodeListUtils.reverseDoubleList(node2);
            DoubleNode back2 = NodeListUtils.testReverseDoubleList(reverse2);
            if (!NodeListUtils.checkDoubleListEqual(node2, back2)) {
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("finish!");


    }


}
