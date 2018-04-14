package com.java.designPattern.template;

/**
 * @author tengcongcong
 * @create 2018-03-20 18:55
 * @Version 1.0
 **/
public class DiGuoJi extends AbstractCook {
    @Override
    protected void putFlavour() {
        System.out.println("放入葱姜蒜、辣椒、花椒、茴香");
    }

    @Override
    protected void chooseMaterial() {


        System.out.println("准备原料：");
        System.out.println("公鸡一只");
        System.out.println("葱姜蒜、辣椒、花椒、茴香");
        System.out.println("味精、盐、鸡精、醋、酱油、料酒");
    }
}
