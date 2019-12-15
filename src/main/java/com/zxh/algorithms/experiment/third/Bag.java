package com.zxh.algorithms.experiment.third;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/15
 */
import java.util.Iterator;
public class Bag<Item> implements Iterable<Item>
{
    private Node first;
    private class Node
    {
        Item item;
        Node next;
    }
    public void add(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    public Iterator<Item> iterator()
    { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        { return current != null; }
        public void remove() { }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}




