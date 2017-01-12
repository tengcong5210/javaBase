package com.java.thinkInJava.typeInfo.chapter_14_3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 类PetCount3.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 下午5:50:20
 * @version 1.0.0
 */
public class PetCount3 {

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter() {
            super(getMap(LiteralPetCreator.allTypes));
        }

        /**
         * @param alltypes
         * @return
         */
        private static Map<Class<? extends Pet>, Integer> getMap(List<Class<? extends Pet>> alltypes) {
            Map<Class<? extends Pet>, Integer> map = new LinkedHashMap<Class<? extends Pet>, Integer>();
            for (Class<? extends Pet> pet : alltypes) {
                map.put(pet, 0);
            }
            return map;
        }

        public void count(Pet pet) {
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet)) {
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(",");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }

    }

    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            petCount.count(pet);
        }
        System.out.println(petCount);
    }
}
