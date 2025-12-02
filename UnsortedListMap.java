/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
import java.util.ArrayList;

interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();

    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) return i;
        }
        return -1;
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }

    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }

    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i); 
            return oldValue;
        }
        return null;
    }

    public V put(K key, V value) {
        int i = findEntryIndex(key);
        if (i != -1) {
            return list.get(i).setValue(value);  // Update old value
        } else {
            list.add(new Entry<>(key, value));    // Add new entry
            return null;
        }
    }
}