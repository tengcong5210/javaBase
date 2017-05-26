package com.java.json.EnumSerialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.junit.Test;

/**
 * @author tengcongcong
 * @create 2017-05-26 8:56
 * @Version 1.0
 **/
public class EnumSerializeTest {
    @Test
    public void testMethod1(){
        ResWithEnumDTO resWithEnumDTO=new ResWithEnumDTO();
        resWithEnumDTO.setId(1);
        resWithEnumDTO.setTermRateEnum(InvestTermRateEnum.MONTH_1);
        SerializeConfig config=new SerializeConfig();
        config.put(ResWithEnumDTO.class, new JavaBeanSerializer(ResWithEnumDTO.class));
        config.put(InvestTermRateEnum.class, new EnumCnSerializer(InvestTermRateEnum.class,"month","rate","desc"));
        System.out.println(JSON.toJSONString(resWithEnumDTO,config));
    }
}
