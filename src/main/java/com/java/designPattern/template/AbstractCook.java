package com.java.designPattern.template;

/**
 * @author tengcongcong
 * @create 2018-03-14 9:07
 * @Version 1.0
 **/
public abstract class AbstractCook implements Cook {
    @Override
    public void doCook() {
        //step1:选料,此方法为重抽象方法，选料
        chooseMaterial();
        //step2:清洗
        washMaterial();
        //step3:切料
        cutMaterial();
        //step4:开灶，上锅,放油，烹饪
        putPan();
        //step5:放调料，此方法为重抽象方法，调料要根据做不同的菜放不同的调料
        putFlavour();
        //step6:出锅、装盘子
        outPan();
    }

    protected void outPan() {
        System.out.println("出锅，装盘");
    }

    protected abstract void putFlavour();

    protected void putPan() {
        System.out.println("打开炉灶、上锅、放油，放原料烹制");
    }

    protected void cutMaterial() {
       System.out.println("原料加工，斩切");
    }

    protected void washMaterial() {
        System.out.println("清洗原料.");
    }

    protected abstract void chooseMaterial();
}
