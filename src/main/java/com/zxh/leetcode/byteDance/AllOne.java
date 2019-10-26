package com.zxh.leetcode.byteDance;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目描述：
 *  实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 *
 *
 */
public class AllOne {
    private Node head;
    private Node tail;
    private HashMap<String, Node> key2Node = new HashMap<String, Node>();
    private HashMap<Integer, Node> count2Node = new HashMap<Integer, Node>();


    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        changeCount(key, true);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!key2Node.containsKey(key)){
            return;
        }
        changeCount(key, false);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    public void changeCount(String key, boolean add){
        int curCount = 0;
        Node node = null;
        boolean removeNode = false;
        if(key2Node.containsKey(key)){
            node = key2Node.get(key);
            curCount = node.count;
            node.keys.remove(key);
            key2Node.remove(key);

            if(node.keys.size() == 0){
                removeNode = true;
                Node next = node.next;
                Node pre = node.pre;
                next.pre = pre;
                pre.next = next;

                count2Node.remove(curCount);
            }
        }

        int newCount = curCount + (add ? 1 : -1);
        if(newCount <= 0){
            return;
        }

        Node newNode = null;
        if(null == node){
            newNode = count2Node.get(1);
            if(null != newNode){
                newNode.keys.add(key);
            }else{
                newNode = new Node(1, key);
                Node next = head.next;
                head.next = newNode;
                newNode.pre = head;
                newNode.next = next;
                next.pre= newNode;
            }
        }else{
            if(add){
                if(node.next.count != newCount){
                    Node next = node.next;
                    Node pre = removeNode ? node.pre : node;
                    newNode = new Node(newCount, key);

                    pre.next = newNode;
                    newNode.pre = pre;
                    newNode.next = next;
                    next.pre = newNode;
                }else{
                    newNode = node.next;
                    node.next.keys.add(key);
                }
            }else{
                if(node.pre.count != newCount){
                    Node pre = node.pre;
                    Node next = removeNode ? node.next : node;
                    newNode = new Node(newCount, key);

                    next.pre = newNode;
                    newNode.next = next;
                    pre.next = newNode;
                    newNode.pre= pre;
                }else{
                    newNode = node.pre;
                    node.pre.keys.add(key);
                }
            }
        }

        count2Node.put(newCount, newNode);
        key2Node.put(key, newNode);
    }

    public static class Node{
        public Node(){
            keys = new HashSet<String>();
        }

        public Node(Integer count){
            this.count = count;
            keys = new HashSet<String>();
        }

        public Node(Integer count, String key){
            this.count = count;
            keys = new HashSet<String>();
            keys.add(key);
        }

        private Node next;
        private Node pre;
        private HashSet<String> keys;
        private int count;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */


