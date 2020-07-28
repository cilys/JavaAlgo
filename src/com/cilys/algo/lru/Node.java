package com.cilys.algo.lru;

/**
 * 定义基本的链表操作节点
 */
public class Node {
    /**
     * 键
     */
    Object key;
    /**
     * 值
     */
    Object value;
    /**
     * 上一个节点
     */
    Node pre;
    /**
     * 下一个节点
     */
    Node next;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
