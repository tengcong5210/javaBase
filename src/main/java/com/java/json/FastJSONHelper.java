package com.java.json;

import com.alibaba.fastjson.JSON;

/**
 * json转换类型
 * 
 * @author linco lee
 */
public class FastJSONHelper {
    /**
     * 将java类型的对象转换为JSON格式的字符串
     * 
     * @param object java类型的对象 可以使Map，List,array
     * @return JSON格式的字符串
     */
    public static <T> String serialize(T object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
     * 
     * @param json JSON格式的字符串
     * @param clz java类型或者java数组类型，不包括java集合类型
     * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
     */
    public static <T> T deserialize(String json, Class<T> clz) {
        return JSON.parseObject(json, clz);
    }

}
