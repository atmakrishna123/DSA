import java.util.*;
public class Dictionary {
    static void insert(Map<String,String> dict,String key,String value){
        if (dict.containsKey(key)){
            System.out.println("Key: "+key+" already exists.");
        }else{
            dict.put(key,value);
        }
    }
    static void delete(Map<String,String> dict,String key){
        if (dict.containsKey(key)){
            dict.remove(key);
        }else{
            System.out.println("Key: "+key+" not found in dictionary.");
        }
    }
    static boolean search(Map<String,String> dict,String key){
        if (dict.containsKey(key)){
            return(true);
        }
        return(false);
    }
    static void update(Map<String,String> dict,String key,String newValue){
        if (dict.containsKey(key)){
            dict.put(key,newValue);
        }else{
            System.out.println("Error: Key not found.");
        }
    }
    static void displayAll(Map<String,String> dict){
        for (Map.Entry<String,String> entry : dict.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
    public static void main(String[] args) {
        Map<String,String> dictionary = new HashMap<>();
        insert(dictionary, "Apple", "A Fruit");
        insert(dictionary, "Java", "A Language");
        insert(dictionary, "Clash of Clans", "A Game");
        System.out.println("Search 'java': " + search(dictionary, "java"));
        update(dictionary, "Java", "A Programming Language");
        System.out.println("\nAll entries:");
        displayAll(dictionary);
        delete(dictionary, "Apple");
        System.out.println("\nAfter deletion:");
        displayAll(dictionary);
    }
}
