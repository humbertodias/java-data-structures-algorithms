package dsa.list;


import java.util.NoSuchElementException;
 
/**
 * http://java2novice.com/data-structures-in-java/linked-list/doubly-linked-list/
 * @param <E> 
 */
public class DoublyLinkedList<E> implements LinkedList<E>{
 
    private Node head;
    private Node tail;
    private int size;
     
    public DoublyLinkedList() {
        size = 0;
    }
    /**
     * this class keeps track of each element information
     * @author java2novice
     *
     */
    private class Node {
        E element;
        Node next;
        Node prev;
 
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    /**
     * returns the size of the linked list
     * @return
     */
    @Override
    public int size() { return size; }
     
    /**
     * return whether the list is empty or not
     * @return
     */
    @Override
    public boolean isEmpty() { return size == 0; }
     
    /**
     * adds element at the starting of the linked list
     * @param element
     * @return 
     */
    public DoublyLinkedList<E> addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
        return this;
    }
    
    @Override
    public DoublyLinkedList<E> add(E element){
        return addFirst(element);
    }
     
    /**
     * adds element at the end of the linked list
     * @param element
     */
    public void addLast(E element) {
         
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
    }
     
    /**
     * this method walks forward through the linked list
     */
    public void iterateForward(){

        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }
     
    /**
     * this method walks backward through the linked list
     */
    public void iterateBackward(){

        Node tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }
    
    @Override
    public E remove(){
        return this.removeFirst();
    }
     
    /**
     * this method removes element from the start of the linked list
     * @return
     */
    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        return tmp.element;
    }
     
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tmp.element;
    }
     
}