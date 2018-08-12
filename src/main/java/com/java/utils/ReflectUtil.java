package com.java.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/11
 * @描述
 */
public class ReflectUtil {

    public static void objCopy(Object src, Object dest) throws Exception {
        Class c1 = src.getClass();
        Class d1 = dest.getClass();
        Field[] fields = c1.getDeclaredFields();
        Field[] fields1 = d1.getDeclaredFields();
        Map<String, Field> map = new HashMap<String, Field>();
        for (Field temp : fields) {
            map.put(temp.getName(), temp);
        }

        for (Field field : fields1) {
            String name = field.getName();
            Field temp = map.get(name);
            if (!name.equals("serialVersionUID")) {
                if (temp == null) {
                    continue;
                }
                field.setAccessible(true);
                temp.setAccessible(true);
                field.set(dest, temp.get(src));
                field.setAccessible(false);
                temp.setAccessible(false);
            }
        }
    }

    public static <T> T objCopy(Object src, Class<T> c) throws Exception {
        T dest = c.newInstance();
        objCopy(src, dest);
        return dest;
    }

    public static List changeListObj(List list, Class cs) throws Exception {
        List result = new ArrayList();
        for (Object c : list) {
            result.add(objCopy(c, cs));
        }
        return result;
    }
}
