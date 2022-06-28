package task6;

import task6.hashmap.SimpleHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationMain {
    public static Map<Integer, List<Integer>> maxFrequency(List<Integer> list){ //O(n)
        if(list.size() == 0){
            return null;
        }

        Map<Integer, List<Integer>> map = new HashMap<>(); //O(1)

        for(int i=0; i<list.size(); i++){ //O(n)
            int key = list.get(i);
            List<Integer> indexes;
            if(!map.containsKey(key)){
                indexes = new ArrayList<>();
            }
            else {
                indexes = map.get(key);
            }
            indexes.add(i);//O(1)
            map.put(key, indexes);
        }

        int maxSize = -1;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){ //O(n)
            if(entry.getValue().size() > maxSize){
                maxSize = entry.getValue().size();
            }
        }

        Map.Entry<Integer, List<Integer>> maxKeyEntry = null;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){ //O(n)
            if(maxKeyEntry == null || (entry.getValue().size() == maxSize &&
                    entry.getKey() > maxKeyEntry.getKey())){
                maxKeyEntry = entry;
            }
        }

        return Map.of(maxKeyEntry.getKey(), maxKeyEntry.getValue());
    }

    public static Map<Integer, List<Integer>> maxFrequency2(List<Integer> list){ //O(n)
        if(list.size() == 0){
            return null;
        }

        SimpleHashMap<Integer, List<Integer>> map = new SimpleHashMap<>(list.size());

        for(int i=0; i<list.size(); i++){
            int key = list.get(i);
            List<Integer> indexes;
            if(!map.containsKey(key)){
                indexes = new ArrayList<>();
            }
            else {
                indexes = map.get(key);
            }
            indexes.add(i);
            map.put(key, indexes);
        }

        int maxSize = -1;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() > maxSize){
                maxSize = entry.getValue().size();
            }
        }

        Map.Entry<Integer, List<Integer>> maxKeyEntry = null;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){ //O(n)
            if(maxKeyEntry == null || (entry.getValue().size() == maxSize &&
                    entry.getKey() > maxKeyEntry.getKey())){
                maxKeyEntry = entry;
            }
        }

        return Map.of(maxKeyEntry.getKey(), maxKeyEntry.getValue());
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 2, 2, 2, 3, 3, 5, 5, 3);
        System.out.println("Java HashMap: " + maxFrequency(list));
        System.out.print("\n");
        System.out.println("My SimpleHashMap: " + maxFrequency2(list));

    }
}
