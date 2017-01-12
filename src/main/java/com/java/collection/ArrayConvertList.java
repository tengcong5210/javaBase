package com.java.collection;

import java.util.Arrays;
import java.util.List;

/**
 * 数组转list
 * 
 * @author linco lee
 */
public class ArrayConvertList {
    private static void convertListTest() {
        String productIds = "10056,10126,10028";
        Object[] arrayPro = productIds.split(",");
        List<Object> list = Arrays.asList(arrayPro);
        for (Object object : list) {
            System.out.println("object:" + object);
        }
    }

    public static void main(String[] args) {
        //        ArrayConvertList a = new ArrayConvertList();
        //        a.convertListTest();
        convertListTest();
    }
}

class LongListTest {
    private List<Long> productIds;

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

}
