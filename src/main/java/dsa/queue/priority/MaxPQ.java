package dsa.queue.priority;

import java.util.NoSuchElementException;

/**
 * Implements a <i>Priority Queue</i> ordered that iterates over the largest
 * key.
 *
 * <h5>Lecture: APIs and Elementary Implementations (Week 4)</h5>
 *
 * <p>
 * Keep the entries ordered in an resizing array.
 * </p>
 *
 * <p>
 * This colecttion uses <i>Binary heap</i> algorithm.</p>
 *
 * @see UnorderedMaxPQ.java
 * @param <Key> parameterized type for key.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MaxPQ() {
        this(1);
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        if (N == pq.length - 1) {
            resize(2 * pq.length);
        }

        pq[++N] = x;
        swim(N);
    }

    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Key max = pq[1];
        exch(1, N--);
        sink(1);

        pq[N + 1] = null;

        if ((N > 0) && (N == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }

        return max;
    }

    //node promoted to level of incompetence (Binary heap);
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    //better subordinate (child) promoted (Binary heap);
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        Key[] copy = (Key[]) new Comparable[capacity];

        for (int i = 1; i <= N; i++) {
            copy[i] = pq[i];
        }

        pq = copy;
    }
    
    public int size(){
        return this.N;
    }
    
}