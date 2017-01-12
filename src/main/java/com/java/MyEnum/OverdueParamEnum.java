package com.java.MyEnum;

/**
 * 产品逾期参数
 * 
 * @author congcong.teng
 * @date 2015-04-14
 */
public enum OverdueParamEnum {

    GANJI("10125", 2),
    XZSEC("10056", 3);
    private String  code;
    private Integer name;

    private OverdueParamEnum(String code, Integer name) {
        this.code = code;
        this.name = name;
    }

    public static OverdueParamEnum getLoanStatusByCode(String code) {
        for (OverdueParamEnum an : OverdueParamEnum.values()) {
            if (an.getCode().equals(code)) {
                return an;
            }
        }
        return OverdueParamEnum.XZSEC;
    }

    public String getCode() {
        return code;
    }

    public Integer getName() {
        return name;
    }
}
