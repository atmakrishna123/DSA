import java.util.*;
public class Hashing {
    private final int DEFAULT_CAPACITY=16;
    private Node[] buckets;
    private int size;
    private static class Node{
        Node next;
        String key;
        Integer value;
        Node(String key,Integer value){
            this.key=key;
            this.value=value;
        }
    }
    public Hashing(){
        buckets=new Node[DEFAULT_CAPACITY];
        size=0;
    }
    private int Hash(String key){
        return Math.abs(key.hashCode())%buckets.length;
    }
    public void put(String key,Integer value){
        int index=Hash(key);
        Node head=buckets[index];
        Node curr=head;
        while (curr!=null){
            while (curr.key.equals(key)){
                curr.value=value;
            }
            curr=curr.next;
        }
        Node newNode = new Node(key,value);
        newNode.next=head;
        buckets[index]=newNode;
        size++;
    }
    public Integer get(String key){
        int index=Hash(key);
        Node curr=buckets[index];
        while (curr!=null){
            if (curr.key.equals(key)){
                return(curr.value);
            }
            curr=curr.next;
        }
        return null;
    }
    public Integer remove(String key){
        int index=Hash(key);
        Node curr=buckets[index];
        Node prev=null;
        while (curr!=null){
            if (curr.key.equals(key)){
                if (prev==null){
                    buckets[index]=curr.next;
                }else{
                    prev.next=curr.next;
                }
                size--;
                return curr.value;

            }
            prev=curr;
            curr=curr.next;
        }
        return null;
    }
    public boolean getKey(String key){
        return(get(key)!=null);
    }
    public boolean containsValue(Integer value) {
        for (Node head:buckets) {
            Node curr=head;
            while (curr!=null) {
                if (Objects.equals(curr.value,value)){
                    return(true);
                } 
                curr=curr.next;
            }
        }
        return(false);
    }

    public int size(){
        return(size);
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public static void main(String[] args) {
        Hashing hashTable = new Hashing();
        System.out.println("=== Hashing Test ===");
        hashTable.put("apple", 10);
        hashTable.put("banana", 20);
        hashTable.put("orange", 30);
        System.out.println("Value of 'apple': " + hashTable.get("apple"));
        System.out.println("Value of 'banana': " + hashTable.get("banana"));
        System.out.println("Value of 'grape': " + hashTable.get("grape")); 
        System.out.println("Contains key 'orange'? " + hashTable.getKey("orange"));
        System.out.println("Contains key 'mango'? " + hashTable.getKey("mango"));
        System.out.println("Contains value 20? " + hashTable.containsValue(20));
        System.out.println("Contains value 100? " + hashTable.containsValue(100));
        System.out.println("Size: " + hashTable.size());
        System.out.println("Is empty? " + hashTable.isEmpty());
        System.out.println("Removing 'banana': " + hashTable.remove("banana"));
        System.out.println("Value of 'banana' after removal: " + hashTable.get("banana"));
        System.out.println("Final size: " + hashTable.size());
    }
}
