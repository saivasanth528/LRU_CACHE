//package models;
//
//import Strategy.Eviction;
//import Strategy.EvictionFactory;
//import lombok.Getter;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//
//
//public class cache.Cache {
//    @Getter
//    private LinkedList<String> linkedList;
//    @Getter
//    HashMap<String, String> hm;
//    int maxSize;
//    public cache.Cache(int size) {
//        linkedList = new LinkedList<String>();
//        hm = new HashMap<>();
//        this.maxSize = size;
//    }
//
//    public void insert(String key, String value, String strategy) {
//        // size is full or not
//
//        if(this.maxSize == 0) {
//            EvictionFactory obj = new EvictionFactory();
//           Eviction evictionObject =  obj.getEvictionObject(strategy);
//           evictionObject.removeElement(this);
//           this.maxSize++;
//        }
//
//        hm.put(key, value);
//        linkedList.add(key);
//        this.maxSize--;
//    }
//
//    public String getValue(String key) {
//        if(hm.get(key) == null) {
//            return null;
//        } else {
//            return hm.get(key);
//        }
//    }
//
//    // remove operation in future
//
//}
