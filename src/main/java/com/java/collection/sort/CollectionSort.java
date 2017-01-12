package com.java.collection.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * 集合排序
 * 
 * @author tengcongcong
 */
public class CollectionSort {
    @Test
    public void testListSort() throws Exception {
        User user3 = new User("王五", "0");
        User user1 = new User("张三", "20");
        User user2 = new User("李四", "60");
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        String str = JSON.toJSONString(userList);
        System.out.println("排序前：" + str);
        Collections.sort(userList, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {

                if (new BigDecimal(o1.getMoney()).compareTo(new BigDecimal(o2.getMoney())) < 0) {
                    return 0;
                } else {
                    return 1;
                }
            }

        });

        String str2 = JSON.toJSONString(userList);
        System.out.println("排序后：" + str2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testListMap() throws Exception {
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张三");
        map.put("money", "20");

        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "李四");
        map2.put("money", "30");

        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("name", "王五");
        map3.put("money", "150");
        listMap.add(map3);
        listMap.add(map);
        listMap.add(map2);

        String str = JSON.toJSONString(listMap);
        System.out.println("排序前：" + str);

        ComparatorHashMap comparator = new ComparatorHashMap();
        Collections.sort(listMap, comparator);
        String str2 = JSON.toJSONString(listMap);
        System.out.println("排序后：" + str2);

    }

    private class ComparatorHashMap implements Comparator {

        public int compare(Object arg0, Object arg1) {

            Map<String, String> map = (Map<String, String>) arg0;
            Map<String, String> map2 = (Map<String, String>) arg1;

            //首先比较出现次数，如果相同，则比较名字  
            BigDecimal num = new BigDecimal(map.get("money"));
            BigDecimal num2 = new BigDecimal(map2.get("money"));
            int flag = num2.compareTo(num);
            if (flag == 0) {
                return (map2.get("name")).compareTo(map.get("name"));
            } else {
                return flag;
            }
        }
    }
}

class User {
    public User() {

    }

    public User(String name, String money) {
        this.name = name;
        this.money = money;
    }

    /**
     * 姓名
     */
    private String name;
    /**
     * 零花钱
     */
    private String money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

}
