package com.java.MyEnum;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/19
 * @描述
 */
public enum Environment {

    DEV(1,"开发"),
    TEST(2,"测试"),
    STAG(3,"预发"),
    PROD(4,"生产"),
    SIT(5,"集成");

    private Integer code;
    private String name;

    private Environment(Integer code, String name){
        this.code=code;
        this.name=name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 根据code获取枚举对象
     * @param code
     * @return
     */
    public static Environment getEnumByCode(Integer code){

        for(Environment var :Environment.values()){
            if(var.getCode().intValue()==code){
                return var;
            }
        }
        return null;
    }
}
