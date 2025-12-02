/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shraddhapatel
 */
public class SeparateChainingMapDriver {
    public static void main(String[] args) {
        SeparateChainingMap<String, Integer> map = new SeparateChainingMap<>();

        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        System.out.println("Value of A: " + map.get("A")); // 10
        System.out.println("Value of B: " + map.get("B")); // 20
        System.out.println("Remove B: " + map.remove("B")); // 20
        System.out.println("Value of B: " + map.get("B")); // null
        System.out.println("Map size: " + map.size()); // 2
    }
}