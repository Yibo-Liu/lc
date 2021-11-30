package com.lbw.NodeList;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DoubleNode.java
 * @Description 双向队列节点
 * @createTime 2021年01月26日 10:06:00
 */
public class DoubleNode {
    private int value;
    private DoubleNode pre;
    private DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
