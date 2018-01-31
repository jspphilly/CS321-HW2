
import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PhillyFam
 */
public class MaxHeap {
    
    Process[] heap;
    int size;

    public MaxHeap(Process[] heap, int size) {
        this.heap = heap;
        this.size = size;
    }
    
    /**
     * Makes the array {@param a} satisfy the max heap property starting from
     * {@param index} till the end of array.
     * <p/>
     * See {@link me.ramswaroop.arrays.sorting.HeapSort#maxHeapify} for a modified
     * version of maxHeapify.
     * <p/>
     * Time complexity: O(log n).
     *
     * @param index
     */
    public void maxHeapify(int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && heap[index].compareTo(heap[leftIndex]) == -1 ){
            largest = leftIndex;
        }
        if (rightIndex < size && heap[index].compareTo(heap[rightIndex]) == -1) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Converts array {@param a} in to a max heap.
     * <p/>
     * Time complexity: O(n) and is not O(n log n).
     */
    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * Insert a new element into the heap satisfying
     * the heap property.
     * 
     * Time complexity: O(log n) where 'n' is total no. of 
     * elements in heap or O(h) where 'h' is the height of
     * heap.
     * 
     * @param elem
     */
    public void insert(int elem) {
        // increase heap size
        heap = Arrays.copyOf(heap, size + 1);
        int i = size;
        int parentIndex = (int) Math.floor((i - 1) / 2);
        // move up through the heap till you find the right position
        while (i > 0 && elem > heap[parentIndex]) {
            heap[i] = heap[parentIndex];
            i = parentIndex;
            parentIndex = (int) Math.floor((i - 1) / 2);
        }
        heap[i] = elem;
        size++;
    }

    public Process findMax() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return heap[0];
        }
    }

    public Process extractMax() {
        if (size == 0){
            throw new NoSuchElementException();
        }

        Process min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return min;
    }

    public int getSize() {
        return size;
    }

    public Process[] getHeap() {
        return heap;
    }

    public void printHeap() {
        if (heap == null)
            System.out.print("null");
        int iMax = size - 1, i;
        if (iMax == -1)
            System.out.print("[]");

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (i = 0; i < iMax; i++) {
            b.append(heap[i]);
            b.append(", ");
        }
        System.out.println(b.append(heap[i]).append(']').toString());
    }

    private void swap(int firstIndex, int secondIndex) {
        Process temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }


}
