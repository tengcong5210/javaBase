package com.java.abstractT;

public class OpenMyTest extends OpenAbstractTest implements OpenInterfaceTest {

    @Override
    public void eat() {
        System.out.println("抽象类");

    }

    public static void main(String[] args) {
        OpenMyTest omt = new OpenMyTest();
        omt.eat();
        omt.play();
        omt.move();
        omt.run();
    }

}
