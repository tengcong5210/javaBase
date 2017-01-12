package com.java.MyEnum;

public class LightTest {

    public static void main(String[] args) {
        //        testEnum();
        testSharpShooterEnum();
    }

    private static void testSharpShooterEnum() {
        System.out.println(OverdueParamEnum.getLoanStatusByCode("1012522").getName());
    }

    private static void testEnum() {
        Light[] lights = Light.values();
        for (Light light : lights) {
            System.out.println("当前灯Name:" + light.name());
            System.out.println("当前灯ordinal:" + light.ordinal());
            System.out.println("当前灯:" + light);
        }
    }

}
