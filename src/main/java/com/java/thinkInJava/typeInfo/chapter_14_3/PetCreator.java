package com.java.thinkInJava.typeInfo.chapter_14_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 类PetCreator.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 下午3:01:10
 * @version 1.0.0
 */
public abstract class PetCreator {
    /**
     * new Random(long seed)：使用单个 long 种子创建一个新的随机数生成器。
     */
    private Random rand = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    /**
     * 随机pet
     * 
     * @return
     */
    public Pet randomPet() {
        int n = rand.nextInt(types().size());//nextInt 生成[0,types().size())区间的整数
        try {
            return types().get(n).newInstance();//此处调用本类的抽象方法。抽象方法没有实现，数据哪来的呢？答：肯定是子类的有子类实现
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
