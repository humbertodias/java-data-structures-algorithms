package dsa.list;

/**
 * http://java2novice.com/data-structures-in-java/linked-list/singly-linked-list/
 * @param <T> 
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int total = 0;
    public void add(T element) {

        Node<T> nd = new Node<>();
        nd.setValue(element);

        /**
         * check if the list is empty
         */
        if (head == null) {
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNextRef(nd);
            //set tail as newly created node
            tail = nd;
        }
        total++;
    }

    public void deleteFront() {

        if (head == null) {
            throw new RuntimeException("Underflow...");
        }
        Node<T> tmp = head;
        head = tmp.getNextRef();
        if (head == null) {
            tail = null;
        }
        
        total--;

    }

    
    public int size(){
        return total;
    }
    
    private class Node<T> implements Comparable<T> {

        private T value;
        private Node<T> nextRef;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextRef() {
            return nextRef;
        }

        public void setNextRef(Node<T> ref) {
            this.nextRef = ref;
        }

        @Override
        public int compareTo(T arg) {
            if (arg == this.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
