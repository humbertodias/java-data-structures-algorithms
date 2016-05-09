package dsa.queue;

/**
 * http://eddmann.com/posts/implementing-a-queue-in-java-using-arrays-and-linked-lists/
 * @param <T> 
 */
interface Queue<T> {
    Queue<T> enqueue(T ele);
    T dequeue();
    int size();
}