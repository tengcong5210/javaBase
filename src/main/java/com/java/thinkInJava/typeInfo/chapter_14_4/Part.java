package com.java.thinkInJava.typeInfo.chapter_14_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.java.thinkInJava.Factory;

/**
 * 类Part.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月18日 下午12:51:09
 * @version 1.0.0
 */
public class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {

        partFactories.add(new FuelFilter.Factory());// new FuelFilter.Factory()此调用的方式 是静态内部类实例化   FuelFilter.Factory a = new FuelFilter.Factory();
        //        partFactories.add();
        //        partFactories.add();
        //        partFactories.add();
    }
    private static Random                rand          = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    //静态内部类
    public static class Factory implements com.java.thinkInJava.Factory<FuelFilter> {

        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
