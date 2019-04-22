package com.java.MyEnum;

import org.junit.Test;

/**
 * @创建人 tengcc
 * @创建时间 2018/10/8
 * @描述
 */
public class ConstantTest {
    @Test
    public  void testEnum() {
     System.out.println("xxx:"+Constant.ENV.DEV.name());

     Environment env=Environment.getEnumByCode(1);
        System.out.println("aaa:"+env.name());
        System.out.println("bbb:"+env.getName());

    }
}
