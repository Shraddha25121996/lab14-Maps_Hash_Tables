/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class UnsortedListMapDriver {
    public static void main(String[] args) {
        UnsortedListMap<String, Integer> map = new UnsortedListMap<>();
        
        System.out.println(map.put("A", 10)); // null
        System.out.println(map.put("B", 20)); // null
        System.out.println(map.put("A", 30)); // 10 (old value)
        System.out.println(map.get("A"));     // 30
        System.out.println(map.remove("B"));  // 20
        System.out.println(map.get("B"));     // null
        System.out.println("Map size: " + map.size()); // 1
    }
}