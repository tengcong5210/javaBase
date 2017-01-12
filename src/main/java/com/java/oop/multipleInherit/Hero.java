package com.java.oop.multipleInherit;

public class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void fly() {
        System.out.println("hero fly");

    }

    @Override
    public void swim() {
        System.out.println("hero swim");

    }

    /**
     * 此处的fight方法不必实现，因为ActionCharacter
     * 已经实现了。如果ActionCharacter没有实现，则hero类必须去实现fight方法，否则编译不通过
     */
    //    public void fight() {
    //        System.out.println("Hero fight");
    //    }

}
