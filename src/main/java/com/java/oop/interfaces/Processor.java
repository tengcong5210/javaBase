package com.java.oop.interfaces;

import java.util.Arrays;

/**
 * 父类定义 name、process方法，子类upcase、downcase、splitter分别实现父类，并重写父类的process方法（
 * 注意：子类重写父类的process方法返回类型的不同）
 * 
 * @author linco lee
 */
public class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {//返回类型Object
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input) {//covariant return   返回类型String
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {//返回类型String
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input) {//返回类型String
        return Arrays.toString(((String) input).split(" "));
    }
}
