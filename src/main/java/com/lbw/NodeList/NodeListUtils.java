package com.lbw.NodeList;

import java.util.ArrayList;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName NodeListUtils.java
 * @Description 封装常用的单向队列、双向队列方法
 * @createTime 2021年01月26日 10:12:00
 */
public class NodeListUtils {

    /**
     * 功能描述:
     *
     * @param head 头结点指针
     * @return: com.lbw.NodeList.Node 返回新链表的头结点
     * @Author: liubowen
     * @Date: 1/26/21 11:52 AM
     */
    public static Node reverseList(Node head) {

        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;

    }

    /**
     * 功能描述:使用ArrayList将传进来的array调转,作为检测方法
     *
     * @param head
     * @return: com.lbw.NodeList.Node
     * @Author: liubowen
     * @Date: 1/26/21 2:22 PM
     */
    public static Node testReverseList(Node head) {
        if (head == null) {
            return null;
        }

        ArrayList<Node> list = new ArrayList<Node>();
        while (head != null) {
            list.add(head);
            head = head.getNext();
        }
        list.get(0).setNext(null);
        int listSize = list.size();
        for (int i = 1; i < listSize; i++) {
            list.get(i).setNext(list.get(i - 1));
        }
        return list.get(listSize - 1);
    }

    /**
     * 功能描述:双向链表翻转
     *
     * @param head 链表头
     * @return: com.lbw.NodeList.DoubleNode
     * @Author: liubowen
     * @Date: 1/26/21 2:28 PM
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {

        if (head == null) {
            return null;
        }

        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            head.setPre(next);
            pre = head;
            head = next;
        }

        return pre;

    }

    /**
     * 功能描述: 检测reverseDoubleList方法
     *
     * @param head 双链表头结点
     * @return: com.lbw.NodeList.DoubleNode
     * @Author: liubowen
     * @Date: 1/26/21 2:59 PM
     */
    public static DoubleNode testReverseDoubleList(DoubleNode head) {

        if (head == null) {
            return null;
        }

        ArrayList<DoubleNode> list = new ArrayList<DoubleNode>();
        while (head != null) {
            list.add(head);
            head = head.getNext();
        }
        list.get(0).setNext(null);
//        list.get(0).setPre(list.get(1));
//        int listSize = list.size();
//        for (int i = 1; i < listSize; i++) {
//            list.get(i).setNext(list.get(i-1));
//            list.get(i).setPre(list.get(i+1));
//        }
//       上面这种写法有误 会数组越界
        int listSize = list.size();
        DoubleNode pre = list.get(0);
        for (int i = 1; i < listSize; i++) {
            DoubleNode cur = list.get(i);
            cur.setPre(null);
            cur.setNext(pre);
            pre.setPre(cur);
            pre = cur;

        }
        return list.get(listSize - 1);
    }

    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.setNext(cur);
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.setNext(cur);
            cur.setPre(pre);
            pre = cur;
            size--;
        }
        return head;
    }

    // 要求无环，有环别用这个函数
    public static boolean checkLinkedListEqual(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.getValue() != head2.getValue()) {
                return false;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return head1 == null && head2 == null;
    }

    // 要求无环，有环别用这个函数
    public static boolean checkDoubleListEqual(DoubleNode head1, DoubleNode head2) {
        boolean null1 = head1 == null;
        boolean null2 = head2 == null;

        if (null1 && null2) {
            return true;
        }

        if (null1 ^ null2) {
            return false;
        }

        if (head1.getPre() != null || head2.getPre() != null) {
            return false;
        }

        DoubleNode end1 = null;
        DoubleNode end2 = null;
        while (head1 != null && head2 != null) {
            if (head1.getValue() != head2.getValue()) {
                return false;
            }
            end1 = head1;
            end2 = head2;
            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        if (head1 != null || head2 != null) {
            return false;
        }

        while (end1 != null && end2 != null) {
            if (end1.getValue() != end2.getValue()) {
                return false;
            }
            end1 = end1.getPre();
            end2 = end2.getPre();
        }
        return end1 == null && end2 == null;
    }


}
