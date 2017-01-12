package com.java.thinkInJava.typeInfo.chapter_14_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类LiteralPetCreator.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 下午5:17:11
 * @version 1.0.0
 */
public class LiteralPetCreator extends PetCreator {
    /**
     * unmodifiableList返回指定映射的不可修改视图。此方法允许模块为用户提供对内部映射的“只读”访问。在返回的映射上执行的查询操作将“读完
     * ”指定的映射。试图修改返回的映射（不管是直接修改还是通过其 collection 视图进行修改）将导致抛出
     * UnsupportedOperationException。
     */
    public static final List<Class<? extends Pet>>  allTypes = Collections.unmodifiableList(Arrays.asList(Pet.class,
                                                                     Dog.class, Cat.class, Rodent.class, Mutt.class,
                                                                     Pug.class, EgyptianMau.class, Manx.class,
                                                                     Cymric.class, Rat.class, Mouse.class,
                                                                     Hamster.class));
    /**
     * 返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。（如果 fromIndex 和 toIndex
     * 相等，则返回的列表为空
     * ）。返回的列表由此列表支持，因此返回列表中的非结构性更改将反映在此列表中，反之亦然。返回的列表支持此列表支持的所有可选列表操作。
     */
    private static final List<Class<? extends Pet>> types    = allTypes.subList(allTypes.indexOf(Mutt.class),
                                                                     allTypes.size());

    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
