package com.zxh.leetcode.byteDance;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 */
public class LRUCache {
    LinkedHashMap<Integer,Integer> linkedHashMap = null;
    int length ;

    public LRUCache(int capacity){
        linkedHashMap = new LinkedHashMap<>(capacity);
        length = capacity;
    }

    public int get(int key){
        if(linkedHashMap.containsKey(key)){
            int value = linkedHashMap.get(key);
            linkedHashMap.remove(key, value);
            linkedHashMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value){
        if(linkedHashMap.containsKey(key)){
            linkedHashMap.remove(key);
        }else if(linkedHashMap.size() == length){
            /**
             * 注意entrySet和keySet的区别；
             * 前者一次遍历就会将key和vale同时取出放入entry，
             * 后者需要两次操作，一次取key，一次取value；
             */
            //Iterator iterator = linkedHashMap.keySet().iterator();
            Iterator iterator = linkedHashMap.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        linkedHashMap.put(key, value);
    }
}
