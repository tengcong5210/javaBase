package com.java.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashmapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("123", "zhangsan");
        String str = map.get("123");
        System.out.println("str=" + str);

        HashSet<String> set = null;
        
        Collections.synchronizedMap(new HashMap<String, String>());
    }
    
    
   

}
