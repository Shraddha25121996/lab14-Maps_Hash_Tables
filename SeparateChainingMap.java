/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
import java.util.ArrayList;
import java.util.LinkedList;

class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // Prime number for better distribution

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // --- 1. get(K key) ---
    public V get(K key) {
        int h = hash(key);                   // 1. Compute the hash index
        LinkedList<Entry<K, V>> bucket = table.get(h); // 2. Get the bucket

        for (Entry<K, V> entry : bucket) {  // 3. Linear search in bucket
            if (entry.getKey().equals(key)) {
                return entry.getValue();     // Found → return value
            }
        }
        return null;                         // Not found → return null
    }

    // --- 2. put(K key, V value) ---
    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {   // Update existing key
                return entry.setValue(value);
            }
        }

        bucket.add(new Entry<>(key, value)); // Add new entry
        size++;
        return null;
    }

    // --- 3. remove(K key) ---
    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }
        return null;
    }
}