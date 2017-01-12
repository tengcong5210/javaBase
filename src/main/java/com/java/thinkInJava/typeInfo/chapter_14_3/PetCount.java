package com.java.thinkInJava.typeInfo.chapter_14_3;

import java.util.HashMap;

/**
 * 类PetCount.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 下午4:43:53
 * @version 1.0.0
 */
public class PetCount {
    //此内部类可以换成下面的写法
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quanTity = get(type);
            if (quanTity == null) {
                put(type, 1);
            } else {
                put(type, quanTity + 1);
            }
        }
    }

    @SuppressWarnings("serial")
    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName());
            if (pet instanceof Pet) {
                counter.count("pet");
                //                new HashMap<String, Integer>() {
                //                    private void count(String type) {
                //                        Integer quanTity = get(type);
                //                        if (quanTity == null) {
                //                            put(type, 1);
                //                        } else {
                //                            put(type, quanTity + 1);
                //                        }
                //                    }
                //                }.count("pet");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("pug");
            }
            if (pet instanceof Cat) {
                counter.count("cat");
            }
            if (pet instanceof Manx) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Manx) {
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }

        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
