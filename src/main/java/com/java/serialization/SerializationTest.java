package com.java.serialization;

public class SerializationTest {

    public static void main(String[] args) {
        String fileName = "employee.ser";
        Example e = new Example();
        e.setId(10);
        e.setName("zhangsan");
        e.setSalary(5000);
        try {
            System.out.println("====serialize====");
            SerializationUtil.serialize(e, fileName);

            System.out.println("====deserialize====");
            Example exa = (Example) SerializationUtil.deserialize(fileName);
            System.out.println("exa:" + exa);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
