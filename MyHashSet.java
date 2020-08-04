import java.util.*;

public class MyHashSet {
    boolean[] arr;
    /** Initialize your data structure here. */
    LinkedList<Integer>[] hashSet;
    int setSize;
    int numElements = 0;
    double loadFactor;

    public MyHashSet() {
        setSize = 16;
        loadFactor = 0.75;
        hashSet = new LinkedList[setSize];
    }

    public void add(int key) {
        int hash = hashCode(key);
        if(hashSet[hash] == null) {
            LinkedList <Integer> list = new LinkedList();
            list.add(key);
            hashSet[hash] = list;
            numElements++;
        }
        else {
            for(int item: hashSet[hash]) {
                if (item == key) {
                    return;
                }
            }
            hashSet[hash].add(key);
            numElements++;
            if(isOverLoaded()) {
                reHash();
            }
        }
    }

    public void remove(int key) {
        int hash = hashCode(key);
        if(hashSet[hash] != null) {
            for(int item: hashSet[hash]) {
                if(item == key) {
                    hashSet[hash].remove(new Integer(key));
                    numElements--;
                    return;
                }
            }
        }
    }

    public boolean contains(int key) {
        int hash = hashCode(key);
        if(hashSet[hash] == null) {
            return false;
        }
        for(int item: hashSet[hash]) {
            if(item == key) {
                return true;
            }
        }
        return false;
    }

    private int hashCode(int key) {
        return key % setSize;
    }

    private boolean isOverLoaded() {
        return (loadFactor < (numElements / setSize));
    }

    private void reHash() {
        setSize *= 2;
        LinkedList<Integer>[] tempHashSet = hashSet;
        hashSet = new LinkedList[setSize];
        for(LinkedList<Integer> list: tempHashSet) {
            if(list == null) {
                continue;
            }
            for(int item: list) {
                add(item);
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */