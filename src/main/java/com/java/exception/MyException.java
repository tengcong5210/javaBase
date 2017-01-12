package com.java.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常测试
 * 
 * @author linco lee
 */
public class MyException {
    
    /**
     * 非检查异常(即运行时异常)
     * 
     * @remark 当一个方法抛出一个非检查异常时（即运行时异常），调用方不需要进行异常处理
     *         如果一个方法抛出检查异常时，调用方必须进行异常处理,如果throw new exception
     */
    @Test
    public void testNoCheckException(List<String> list) {
        try {
            list.get(0);
        } catch (Exception e) {
            throw new RuntimeException("运行时异常请检查,error message:" + e.getMessage());
        } finally {
            System.out.println("finally end");//finally中的代码会被执行
        }
        System.out.println("testNoCheckException end");//此处打印不会被执行，异常直接throw出去了。疑问：放在finally中会
    }

    /**
     * 检查异常
     */
    @Test
    public void testCheckException(List<String> list) throws Exception {
        list.get(0);
    }

    /**
     * 验证在try中 throw new RuntimeException 执行的代码路径
     */
    @Test
    public void testCheckParam(String param) {
        try {
            if (StringUtils.isBlank(param)) {
                throw new RuntimeException("the param is null");
            }
            System.out.println("will be executed code block");
        } catch (Exception e) {
            System.out.println("come catch code block");
        }
        System.out.println("this code block will be executed??????");
    }
    @Test
    public void testCheckParam2(String param) {
        try {
            if (StringUtils.isBlank(param)) {
                throw new RuntimeException("the param is null");
            }
            //此句不会执行
            System.out.println("will be executed code block");
        } catch (Exception e) {
        	//此句会执行
            System.out.println("come catch code block");
            throw new RuntimeException("the param is null");
        }
        //此句不会执行了
        System.out.println("this code block will be executed??????");
    }
    @Test
    public void testCheckParam3() {
        try {
        	String param=null;
        	int index=param.indexOf("22");//如果此句异常 下面的语句不会执行 直接进入catch
            System.out.println("will be executed code block");//不执行
        } catch (Exception e) {
            System.out.println("come catch code block");
            e.printStackTrace();  //catch执行后  下面的打印语句会执行吗？答：会执行，如果 catch中 throw new RuntimeException() 下面的语句就不会执行了  参考:testCheckParam2方法
        }finally{
        	System.out.println("finally");
        }
        System.out.println("this code block will be executed??????");//此句会执行
    }
    
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        //        try {
//        //            testNoCheckException(list);
//        //            //            testCheckException(list);
//        //        } catch (Exception e) {
//        //            e.printStackTrace();
//        //        }
//
//        testCheckParam3(null);
//        System.out.println("the end");
//    }

}
