package com.java.collection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaList {

    public static void main(String[] args) {
        //        testListObjectReference();
        //        List<Order> orderList = testList();
        //        for (Order order : orderList) {
        //            System.out.println(ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE));
        //        }

        listTree();
    }

    /**
     * 测试集合存储对象再修改对象
     */
    private static void testListObjectReference() {
        Order order = new Order();
        order.setOrderInfo("信贷平台");
        order.setOrderStatus("1");
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        //对OrderStatus状态进行修改
        order.setOrderStatus("-1");
        for (Order od : orderList) {
            System.out.println("订单状态：" + od.getOrderStatus());//打印结果为-1
        }

    }

    private static List<Order> testList() {
        Order order = new Order();
        order.setOrderStatus("1");
        List<Order> orderList = new ArrayList<Order>();
        for (int i = 0; i < 3; i++) {
            order.setOrderInfo("信贷平台" + i);
            orderList.add(order);
        }
        return orderList;
    }

    private static void listTree() {
        String path = "D:\\home\\test1";
        List<String> dealList = new ArrayList<String>();
        dealList.add(path);
        int index = 0;
        String tempPath = "";
        File file = null;
        String[] files = null;
        while (index < dealList.size()) {
            tempPath = dealList.get(index);
            file = new File(tempPath);
            files = file.list();
            tempPath = tempPath + "/";
            for (int i = files.length - 1; i >= 0; i--) {
                dealList.add(index + 1, tempPath + files[i]);
            }
            index++;
        }
    }
}

class Order {
    /**
     * 订单状态：1 成功、-1 失败
     */
    private String orderStatus;
    private String orderInfo;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}
