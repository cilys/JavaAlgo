package com.cilys.algo.lru;

import java.util.HashMap;

/**
 * LRU算法实现
 * 链表基本定义
 * 定义一个Lru类，然后定义它的大小、容量、头节点、尾节点等部分，然后一个基本的构造方法
 */
public class Lru<K, V> {
    /**
     * 当前大小
     */
    private int currentSize;
    /**
     * 总容量
     */
    private int capcity;
    /**
     * 所有的node节点
     */
    private HashMap<K, Node> caches;
    /**
     * 头节点
     */
    private Node first;
    /**
     * 尾节点
     */
    private Node last;

    public Lru(int size) {
        this.currentSize = 0;
        this.capcity = size;
        caches = new HashMap<K, Node>(size);
    }

    /**
     * 添加元素
     * 1、判断元素是否是新的元素
     * 2、如果是新元素，判断当前的大小是不是大于总容量，防止超过链表总长度
     * 3、如果大于总容量，直接抛弃最后一个节点，再传入key、value，创建新的节点
     * 4、对于已经存在的元素，直接覆盖，再将该元素移动到头部，然后保存在map
     */
    public void put(K key, V value) {
        Node node = caches.get(key);
        if (node == null){
            //新元素
            if (caches.size() >= capcity) {
                //超过链表总容量
                caches.remove(last.key);

                removeLast();
            }
            node = new Node(key, value);
        }

        //已经存在的元素，覆盖旧值
        node.value = value;
        //节点移动到首部
        moveToHead(node);
        caches.put(key, node);
    }

    /**
     * 取元素
     * @param key
     * @return
     */
    public Object get(K key) {
        Node node = caches.get(key);
        if (node == null) {
            return null;
        }
        //访问过后的节点，移动到首部
        moveToHead(node);
        return node.value;
    }

    /**
     * 删除节点
     * 根据key删除节点的操作中，把节点的前一个节点的指针指向下一个位置，再把当前节点的下一个节点的上一个指向当前节点的前一个
     * @param key
     * @return
     */
    public Object remove(K key){
        Node node = caches.get(key);
        if (node != null) {
            //节点存在

            if (node.pre != null){
                //前一个节点也存在

                //前一个节点的下一个节点，指向当前节点的下一个节点（原本前一个节点的下一个节点，指向当前节点）
                node.pre.next = node.next;
            }

            if (node.next != null){
                //下一个节点存在

                //下一个节点的前一个节点，指向当前节点的上一个节点（原本下一个节点的前一个节点，指向当前节点）
                node.next.pre = node.pre;
            }

            if (node == first){
                //当前节点是首节点

                //当前节点的下一节点改为首节点
                first = node.next;
            }

            if (node == last) {
                //当前节点是尾节点

                //当前节点的上一节点改为尾节点
                last = node.pre;
            }
        }
        return caches.remove(key);
    }

    /**
     * 移动元素到首节点
     *
     */
    private void moveToHead(Node node) {
        if (first == node) {
            //当前节点是头节点
            return;
        }

        if (node.next != null){
            //有下一个节点

            //下一个节点的上一个节点，指向当前当前节点的上一个节点
            node.next.pre = node.pre;
        }

        if (node.pre != null) {
            //有上一个节点

            //上一个节点的下一个节点，指向当前节点的下一个节点
            node.pre.next = node.next;
        }

        if (node == last) {
            //当前节点是尾节点

            //上一个节点改为尾节点
            last = last.pre;
        }

        if (first == null || last == null) {
            //头节点或尾节点不存在

            first = last = node;
        }

        //当前节点的下一个节点，指向头节点
        node.next = first;

        //头节点的上一节点，指向当前节点
        first.pre = node;

        first = node;

        //头节点没有上一个节点
        first.pre = null;
    }

    /**
     * 清楚所有节点
     */
    public void clear(){
        first = null;
        last = null;
        caches.clear();
    }

    /**
     * 移除最后一个节点
     */
    private void removeLast(){
        if (last != null) {
            //尾节点存在

            //尾节点的上一节点，改为尾节点
            last = last.pre;

            if (last == null) {
                 first = null;
            } else {
                first.next = null;
            }
        }
    }
}