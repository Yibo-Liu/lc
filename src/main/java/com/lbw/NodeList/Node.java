package com.lbw.NodeList;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Node.java
 * @Description 单向队列节点
 * @createTime 2021年01月26日 10:04:00
 */
public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
