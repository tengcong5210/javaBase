package com.java.collection.map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

public class HashmapTest {

    /*public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("123", "zhangsan");
        String str = map.get("123");
        System.out.println("str=" + str);

        HashSet<String> set = null;
        
        Collections.synchronizedMap(new HashMap<String, String>());
    }*/

    /**  1.HashMap 类映射不保证顺序；某些映射可明确保证其顺序: TreeMap 类
     *   2.在遍历Map过程中,不能用map.put(key,newVal),map.remove(key)来修改和删除元素，
     *   会引发 并发修改异常,可以通过迭代器的remove()：
     *   从迭代器指向的 collection 中移除当前迭代元素
     *   来达到删除访问中的元素的目的。
     *   */
    @Test
    public void testMapDelete() throws Exception{
        Map<Integer,Object> map=new HashedMap();
        map.put(0,"apply_id");
        map.put(1,"debtor_name");
        map.put(2,"debtor_tel");
        map.put(3,"debtor_idcard");
        map.put(4,"apply_amount");
        map.put(5,"apply_limit_m");
        map.put(6,"province");
        map.put(7,"contractName");

        Iterator<Map.Entry<Integer,Object>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Object> entry =it.next();
            Integer key=entry.getKey();
            if(key%2==1){
                System.out.println("delete key: "+key);
                it.remove();
            }
        }

        System.out.println("-------\n\t最终的map的元素遍历：");
        for(Map.Entry<Integer, Object> entry:map.entrySet()){
            int k=entry.getKey();
            Object v=entry.getValue();
            System.out.println(k+" = "+v);
        }


    }

    @Test
    public void testRepeatPut(){
        //实例化map时，会实例化HashEntry数组，默认容量16，负载因子0.75f
        Map<String,String> map=new HashedMap();
        //put方法的源码：
        //1.根据key计算hashcode
        //2.然后根据hashcode和HashEntry数组的长度 计算key在数组中的索引
        //3.根据查找索引在数组中的entry
        //4.判断entry是否存在，若存在，继续判断key的hashcode和key的值是否相等，相等，取出key对应的老值，不等，则往map中添加新元素
        //                     若不存在，则往map中添加新元素
        //5.map中的元素entry的定义：HashEntry
        map.put("aaa","1111");
        map.put("bbb","2222");
        map.put("aaa","3333");
    }



}
