package com.zxh.leetcode.exercise;

import java.util.HashMap;

/**
 * @Author: ningque
 * @Date: 2020/9/5
 * @Version 1.0
 */

public class Trie {

    /**
     * 字典树
     * https://blog.csdn.net/qq_40910541/article/details/88884843?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param
     *
     */
    private class Node {
        public HashMap<Character , Node> childs;      //子结点
        public boolean isLeaf;     //当前结点是否是完整字符串（是否是叶结点）

        public Node () {
            this.isLeaf = false;
            this.childs = new HashMap<>();
        }

    }

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word);
    }

    public void insert(Node root, String word){
        if(word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        Node cur = root;
        for(int i=0; i<chars.length; i++){
            if(!cur.childs.containsKey(chars[i])){
                cur.childs.put(chars[i], new Node());
            }
            cur = cur.childs.get(chars[i]);
        }
        if(!cur.isLeaf){
            cur.isLeaf = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word);
    }

    public boolean search(Node root, String word){
        if(word == null || word.length() == 0){
            return false;
        }
        char[] chars = word.toCharArray();
        Node cur = root;
        for(int i=0; i<chars.length; i++){
            if(!cur.childs.containsKey(chars[i])){
                return false;
            }
            cur = cur.childs.get(chars[i]);
        }
        if(!cur.isLeaf)
            return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }

    public boolean startsWith(Node root, String prefix){
        if(prefix == null || prefix.length() == 0){
            return false;
        }
        char[] chars = prefix.toCharArray();
        Node cur = root;
        for(int i=0; i<chars.length; i++){
            if(!cur.childs.containsKey(chars[i])){
                return false;
            }
            cur = cur.childs.get(chars[i]);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
