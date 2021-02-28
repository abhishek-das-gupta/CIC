package com.cic.heaps.implementation.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Heap is Empty!");
        }
        return heap[0];
    }

    public int remove(){
        if(isEmpty()){
            throw new NoSuchElementException("Heap is Empty");
        }

        int minItem = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown();
        return minItem;
    }

    private void heapifyDown(){
        int index = 0;

        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(heap[index] < smallerChildIndex){
                break;
            }else{
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }

    }

    public void add(int item){
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = size-1;

        while(hasParent(index)){
            int parent = getParentIndex(index);
            if(heap[parent] > heap[index]){
                swap(parent, index);
            }
            else{
                break;
            }
            index = getParentIndex(index);
        }

    }


    private void ensureCapacity(){
        if(size == capacity){
            heap = Arrays.copyOf(heap,capacity*2);
            capacity *=2;
        }
    }

    private void swap(int dex1, int dex2){
        swap(heap[dex1],heap[dex2]);
    }


    private boolean hasParent(int childIndex){
        return getParentIndex(childIndex) >=0 && getParentIndex(childIndex) < size;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private int getParent(int childIndex){
        return heap[childIndex-1]/2;
    }

    private boolean hasLeftChild(int parentIndex){
        return getLeftChild(parentIndex) >=0 &&getLeftChild(parentIndex) < size;
    }

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }
    private int getLeftChild(int parentIndex){
        return heap[2*parentIndex+1];
    }

    private boolean hasRightChild(int parentIndex){
        return getRightChildIndex(parentIndex) >=0 && getRightChildIndex(parentIndex) < size;
    }
    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }
    private int getRightChild(int parentIndex){
        return heap[2*parentIndex+2];
    }



}
