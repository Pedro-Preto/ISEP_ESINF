/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Priority_queue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author antoniosilva
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /**
     * primary collection of priority queue entries
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the priority queue
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Creates a priority queue initialized with the respective
     * key-value pairs.  The two arrays given will be paired
     * element-by-element. They are presumed to have the same
     * length. (If not, entries will be created only up to the length of
     * the shorter of the arrays)
     *
     * @param keys   an array of the initial keys for the priority queue
     * @param values an array of the initial values for the priority queue
     */
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++)
            heap.add(new PQEntry<>(keys[j], values[j]));
        buildHeap();
    }

    // protected utilities
    protected int parent(int j) {
        return (j - 1) / 2;
    }     // truncating division

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);

    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     */
    //O(logn)
    protected void percolateUp(int j) {
        int ind = (j - 1) / 2;
        //compara j com o seu ascendente
        while (ind >= 0 && compare(heap.get(j), heap.get(ind)) == -1) {
            //se j < que o ascendente, então há uma troca
            swap(j, ind);
            //j = ind, pois os elementos foram trocados de sítio
            j = ind;
            ind = (j - 1) / 2;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     */
    //O(logn)
    protected void percolateDown(int j) {
        int indLeft = 2 * j + 1;
        int indRight = 2 * j + 2;
        boolean swaps = true;
        while (indLeft < heap.size() && swaps) {
            int smallindex = indLeft;
            if (indRight < heap.size()) {
                if (compare(heap.get(indRight), heap.get(indLeft)) == -1) {
                    smallindex = indRight;
                }
            }
            if (compare(heap.get(j), heap.get(smallindex)) == 1) {
                swap(j, smallindex);       //change the elem by the
                j = smallindex;               //child with the highest
                indLeft = 2 * j + 1;           //priority
                indRight = 2 * j + 2;
            } else {
                swaps = false;
            }
        }
    }

    /**
     * Performs a batch bottom-up construction of the heap in O(n) time.
     */
    protected void buildHeap() {
        for (int j = heap.size() - 1; j >= 0; j--) {
            int parent = parent(j);
            percolateDown(parent);
        }
    }

    // public methods

    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     *
     * @return entry having a minimal key (or null if empty)
     */
    //O(1)
    @Override
    public Entry<K, V> min() {
        return heap.get(0);
    }

    /**
     * Inserts a key-value pair and return the entry created.
     *
     * @param key   the key of the new entry
     * @param value the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this queue
     */
    //O(logn)
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        Entry<K, V> entry = new PQEntry<>(key, value);
        heap.add(entry);
        percolateUp(heap.size() - 1);
        return entry;
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry (or null if empty)
     */
    //O(logn)
    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, V> min = min();
        int j = 0;
        while (hasRight(j)) {
            j = right(j);
        }
        swap(0, j);
        heap.remove(heap.get(j));
        percolateDown(0);
        return min;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < heap.size(); i++) {
            str += heap.get(i).getKey().toString() + heap.get(i).getValue().toString();
            str += "\n";
        }
        return str;
    }

    @Override
    public HeapPriorityQueue<K, V> clone() {
        K[] keyList = (K[]) new Object[heap.size()];
        V[] valueList = (V[]) new Object[heap.size()];
        for (int i = 0; i < heap.size(); i++) {
            keyList[i] = heap.get(i).getKey();
            valueList[i] = heap.get(i).getValue();
        }
        HeapPriorityQueue<K, V> cloned = new HeapPriorityQueue<>(keyList, valueList);
        return cloned;
    }
}

