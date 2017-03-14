package com.java.utils;

/**
 * Created by ibm on 2017/3/14.
 */
public class EventBusTest {

    public static void main(String[] args) throws InterruptedException {
        BussinessServiceImpl impl=new BussinessServiceImpl();
        impl.buy();

    }


}

class BussinessServiceImpl{
    public void buy(){
        System.out.println("开始buy");
        try {
            restForWhile();
//            EnventBusUtil.invoke(this,"restForWhile",null);
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("结束");
    }
    private void restForWhile() throws InterruptedException {
        System.out.println("开始睡眠");
        Thread.sleep(10000);
        System.out.println("结束睡眠");
    }
}
