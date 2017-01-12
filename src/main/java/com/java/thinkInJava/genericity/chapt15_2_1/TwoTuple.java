package com.java.thinkInJava.genericity.chapt15_2_1;

/**
 * 类TwoTuple.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午8:56:13
 * @version 1.0.0
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public static void main(String[] args) {
        ParamsDTO p = new ParamsDTO("张三", "男");
        ResultDTO r = new ResultDTO("1", "处理成功");
        TwoTuple<ParamsDTO, ResultDTO> two = new TwoTuple<ParamsDTO, ResultDTO>(p, r);
        System.out.println(two.first);
        System.out.println(two.second);
    }
}

class ParamsDTO {
    private String name;
    private String sex;

    public ParamsDTO(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ParamsDTO [name=" + name + ", sex=" + sex + "]";
    }

}

class ResultDTO {
    public String result;
    public String resultMessage;

    public ResultDTO(String result, String resultMessage) {
        this.result = result;
        this.resultMessage = resultMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "ResultDTO [result=" + result + ", resultMessage=" + resultMessage + "]";
    }

}
