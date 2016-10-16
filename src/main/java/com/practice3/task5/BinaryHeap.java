package com.practice3.task5;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryHeap {
    private ArrayList<Integer> items;

    public BinaryHeap(int size) {
        items = new ArrayList<>(size);
    }

    public void insert(int val) {
        items.add(val);
        siftUp();
    }

    public int poll() {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        int hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        siftDown();

        return hold;
    }

    // to insert
    private void siftUp() {
        int k = items.size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            int item = items.get(k);
            int parent = items.get(p);
            if (item > parent) {
                // swap
                items.set(k, parent);
                items.set(p, item);
                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }

    // to delete
    private void siftDown() {
        int k = 0;
        int left = 2 * k + 1;
        while (left < items.size()) {
            int max = left;
            int right = left + 1;
            if (right < items.size()) {
                if (items.get(right) > items.get(left)) {
                    max++; // max := right, because right node > left node
                }
            }
            if (items.get(k) < items.get(max)) {
                // switch
                int temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                left = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int i = 1 & 2;
        System.out.println(i);

        BinaryHeap binaryHeap = new BinaryHeap(2);
        binaryHeap.insert(0);
        binaryHeap.insert(1);

        System.out.println("after insert");
        binaryHeap.items.forEach(System.out::println);

        binaryHeap.poll();
        binaryHeap.poll();

        System.out.println("after poll");
        binaryHeap.items.forEach(System.out::println);
    }
}

