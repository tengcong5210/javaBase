package com.java.MyEnum;

/**
 * 枚举就是一个类，其构造方法必须是private 需求:定义一个方法，获取中文星期
 * 
 * @author Administrator
 */
public enum WeekDay {//calss 
    MON("1") {
        public String getChinaName() {
            return "星期一";
        }
    },
    TUES("2") {
        public String getChinaName() {
            return "星期二";
        }
    },
    WED("3") {
        public String getChinaName() {
            return "星期三";
        }
    },
    THUR("4") {
        public String getChinaName() {
            return "星期四";
        }
    },
    FRI("5") {
        public String getChinaName() {
            return "星期五";
        }
    },
    SAT("6") {
        public String getChinaName() {
            return "星期一";
        }
    },
    SUN("7") {
        public String getChinaName() {
            return "星期六";
        }
    };//相当于new WeekDay1_4
    private String name;

    private WeekDay(String name) {//此时只有有参构造，故MON要变为MON("1")才不会报错。因为MON=new WeekDay(xxx)
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 抽象方法，该抽象方法必须在， MON("1"){ public String getChinaName(){ return "星期一"; }
     * }实现
     * 
     * @return
     */
    public abstract String getChinaName();
}

/**
 * 1.5之前的版本 没有枚举，只能这样定义
 * 
 * @author Administrator
 */
class WeekDay1_4 {

    private WeekDay1_4() {

    }

    public static final WeekDay1_4 MON  = new WeekDay1_4();
    public static final WeekDay1_4 TUES = new WeekDay1_4();
    public static final WeekDay1_4 WED  = new WeekDay1_4();
    public static final WeekDay1_4 THUR = new WeekDay1_4();
    public static final WeekDay1_4 FRI  = new WeekDay1_4();
    public static final WeekDay1_4 SAT  = new WeekDay1_4();
    public static final WeekDay1_4 SUN  = new WeekDay1_4();
}
