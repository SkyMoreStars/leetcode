package me.zhyx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yx.zh
 * @date: 2020-08-30 13:53
 **/
public class EveryDay44 {

    public static void main(String[] args) {
        EveryDay44 cache = new EveryDay44( 3 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));     // 返回  1
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(3));       // 返回 -1 (未找到)
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        cache.put(5, 5);
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回 -1 (未找到)
        System.out.println(cache.get(4));       // 返回 -1 (未找到)
        System.out.println(cache.get(5));       // 返回 -1 (未找到)

//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));

    }
    /**
     * 运用你所掌握的数据结构，设计和实现一个 
     * LRU (最近最少使用) 缓存机制。
     * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) -
     * 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) -
     * 如果关键字已经存在，则变更其数据值；
     * 如果关键字不存在，则插入该组「关键字/值」。
     *
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    /**
     * 双向链表+HashMap
     */
    LinkedList head;
    LinkedList tail;
    Map<Integer, LinkedList> map;
    int size;

    public EveryDay44(int capacity) {
        this.size=capacity;
        this.head=new LinkedList(-1,-1);
        this.tail=new LinkedList(-1,-1);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>(capacity);
    }

    /**
     * get的时候，需要把key对应所在的元素，从指定位置放到tail位置。
     * @param key
     * @return
     */
    public int get(int key) {
        if(this.map.containsKey(key)){
            LinkedList linkedList = this.map.get(key);
            sortNode(linkedList);
            return linkedList.val;
        }else{
            return -1;
        }
    }

    private void sortNode(LinkedList linkedList) {
        /**
         * 将该元素放到tail位置
         */
        LinkedList prev = linkedList.prev;
        LinkedList next = linkedList.next;
        prev.next=next;
        next.prev=prev;
        addNode(linkedList);
    }

    /**
     * 在put的时候，先判断map中是否存在该元素
     * 如果未满容量，则直接加在最后一个。
     * 链表的头部表示最不经常用的元素，get到的数据必须放在尾部。
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        LinkedList linkedList = new LinkedList(key, value);
        if(map.containsKey(key)){
            updateData(linkedList);
        }else {
             this.map.put(key,linkedList);
             if (this.map.size()>size){
                 deleteOld();
             }
             addNode(linkedList);
        }
    }

    /**
     * 将新元素添加在尾部
     * @param linkedList
     */
    private void addNode(LinkedList linkedList) {
        /**
         * 需要添加在这个元素之后
         */
        LinkedList prev = this.tail.prev;
        prev.next=linkedList;
        linkedList.prev=prev;
        linkedList.next=this.tail;
        this.tail.prev=linkedList;

    }

    /**
     * 头部最不经常用的元素
     */
    private void deleteOld() {
        /**
         * 需要删除的节点
         */
        LinkedList delNode = this.head.next;
        this.head.next=delNode.next;
        delNode.next.prev=this.head;
        this.map.remove(delNode.key);
        delNode=null;
    }

    private void updateData(LinkedList itemNode) {
        LinkedList realLinkedNode = this.map.get(itemNode.key);
        realLinkedNode.val=itemNode.val;
        sortNode(realLinkedNode);
    }

    private static class LinkedList{
        LinkedList prev;
        LinkedList next;
        int key;
        int val;

        public LinkedList() {
        }

        public LinkedList(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}

