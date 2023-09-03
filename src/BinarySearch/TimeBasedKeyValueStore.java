package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//981. Time Based Key-Value Store
/*
Design a time-based key-value data structure that can store multiple values for the same key at different
time stamps and retrieve the key's value at a certain timestamp.
Implement the TimeMap class:
TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
public class TimeBasedKeyValueStore {
    static class Pair{
        String value;
        int timestamp;
        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> valueMap;
    public TimeBasedKeyValueStore() {
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> dataList = valueMap.getOrDefault(key,new ArrayList<>());
        Pair newData =  new Pair(value, timestamp);
        dataList.add(newData);
        valueMap.put(key, dataList);
    }

    public String get(String key, int timestamp) {
        List<Pair> dataList = valueMap.getOrDefault(key,new ArrayList<>());
        if(dataList == null) return "";

        int start = 0, end = dataList.size()-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            Pair data = dataList.get(mid);
            if(data.timestamp == timestamp) return data.value;
            else if(data.timestamp < timestamp) start = mid+1;
            else end = mid-1;
        }
        return start>0?dataList.get(start-1).value:"";
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore game = new TimeBasedKeyValueStore();
        game.set("Player1","Level1",25);
        game.set("Player1","Level1",30);
        game.set("Player1","Level2",86);
        System.out.println(game.get("Player1",90));
        game.set("Player1","Level3",96);
        System.out.println(game.get("Player1",98));
    }
}
