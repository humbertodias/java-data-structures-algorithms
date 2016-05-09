package dsa.stack;

/**
 * http://eddmann.com/posts/implementing-a-stack-in-java-using-arrays-and-linked-lists/
 * @param <T> 
 */
interface Stack<T> {
    Stack<T> push(T ele);
    T pop();
    int size();
}
