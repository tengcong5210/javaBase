package com.java.innerClass;

/**
 * 演示内部类访问外部类
 * 
 * @author linco lee
 */
public class DoThis {

    private int i = 10;

    void f() {
        System.out.println("DoThis.f()");
    }

    /**
     * 内部类中使用外部类对象，同事外部类的名字后跟圆点和this
     * 
     * @author linco lee
     */
    public class Inner {
        //内部里创建外部类的对象
        public DoThis outer() {
            return DoThis.this;
        }

        public void printOuterClassField() {
            System.out.println("outer.i=" + i);
        }
    }

    //外部类提供内部类实例的方法
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DoThis dt = new DoThis();
        //        DoThis.Inner dti = dt.inner();//可以不通过这种方式去创建内部类
        DoThis.Inner dti = dt.new Inner();//这种方式也可获取内部类对象的
        dti.outer().f();
        dti.printOuterClassField();
    }
}
