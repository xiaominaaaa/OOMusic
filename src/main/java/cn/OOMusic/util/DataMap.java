package cn.OOMusic.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DataMap {
    private HashMap hashMap;

    @Override
    public String toString() {
        return "DataMap{" +
                "hashMap=" + hashMap +
                '}';
    }

    public HashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public DataMap() {
        this.hashMap = new HashMap();
    }
}
