package com.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {

}

class Power extends Snow {

}

class Light extends Power {

}

class Heavy extends Power {

}

class Crusty extends Snow {

}

class Slush extends Snow {

}

/**
 * Arrays.asList的类型限制使用
 * 
 * @author linco lee
 */
public class AsListInFerence {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Power());
        //    List<Snow> snow2 = Arrays.asList(new Light(), new Heavy()); won't compile;
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        List<Snow> snow4 = Arrays.<Snow> asList(new Light(), new Heavy());//显示类型参数说明
    }
}
