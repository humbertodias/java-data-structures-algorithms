package dsa.list;

/**
 *
 */
interface LinkedList<T> {
    LinkedList<T> add(T item);
    T remove();
    boolean isEmpty();
    int size();
}
