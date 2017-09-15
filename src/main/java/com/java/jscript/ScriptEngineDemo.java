package com.java.jscript;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


/**
 * js引擎
 * @author tengcongcong
 * @create 2017-09-14 16:05
 * @Version 1.0
 **/
public class ScriptEngineDemo {
    /**
     * 直接执行一段js代码
     * @throws Exception
     */
    @SuppressWarnings("Since15")
    @Test
    public void test01() throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");//ScriptEngine用来处理脚本解释和求值
        engine.put("age", 17);//赋值脚本环境中所使用的变量
        Object result=engine.eval("if(age>=18){ code='p2p';}else{ code='jsy';}");//解析 JavaScript 脚本,对脚本表达式进行求值
        System.out.println(((String) result));
    }

    /**
     * 执行通道规则js引擎
     */
    @SuppressWarnings("Since15")
    @Test
    public void test02()throws Exception{
        /*if(applyAmount<=20&&applyLimit<=12){
            return "p2p";
        }if((applyAmount<=20&&applyLimit>18)||applyAmount>20){
            return "及时雨";
        }*/

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.put("applyAmount", 21);//赋值脚本环境中所使用的变量 单位万元
        engine.put("applyLimit", 12);//赋值脚本环境中所使用的变量  单位月
        Object result=engine.eval("if(applyAmount<=20&&applyLimit<=12){code='p2p';}else if((applyAmount<=20&&applyLimit>12)||applyAmount>20){code='jsy';}else{code='p2p';}");
        System.out.println(((String) result));
    }
}
