package com.zxh.nowCoder.jianzhi_offer;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/23
 *
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * *解题思路：
 * *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 * *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 * *3、拆分链表，将链表拆分为原链表和复制后的链表
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        RandomListNode currentNode = pHead;
        //复制每个节点，复制节点A到节点A1，将节点A1放到A后面
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode  = pHead;
        //重新遍历节点，复制随机节点
        while(currentNode != null){
            // 注意理解下面这句话，即将当前复制节点的random节点置为当前节点random节点的下一个，因为上一步做了复制
            currentNode.next.random = currentNode.random == null ? null :currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //拆分链表
        currentNode = pHead;
        RandomListNode pcloneNode = pHead.next;
        while(currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pcloneNode;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}