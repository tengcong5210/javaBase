package com.java.MyEnum;

public enum Light {
    RED(1, "红灯"),
    GREEN(3, "绿灯"),
    YELLOW(2, "黄灯");
    private int    nCode;
    private String nName;

    private Light(int nCode, String nName) {
        this.nCode = nCode;
        this.nName = nName;
    }

    @Override
    public String toString() {
        return String.valueOf(this.nCode + "," + this.nName);
    }
}
