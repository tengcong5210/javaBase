package com.java.MyEnum;

/**
 * @创建人 tengcc
 * @创建时间 2018/10/8
 * @描述
 */
public final class Constant {

    public enum ENV {
        DEV(1),TEST(2),STAG(3),PROD(4);

        private final Integer id;

        private ENV(Integer index){
            this.id = index;
        }

        public Integer getId() {
            return id;
        }
    }
}
