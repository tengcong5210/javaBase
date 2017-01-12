package com.java.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.java.json.bean.Person;

/**
 * 将对象转换为json字符串
 * 
 * @author linco lee
 */
public class JsonConvertToString {
    /**
     * 将map转成jsonString
     */
    @Test
    public void mapConvertToString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", "11");
        map.put("b", "22");
        map.put("c", "33");
        String str1 = JSONObject.toJSONString(map);
        System.out.println("str1:" + str1);
        System.out.println("*****************************************");

        map = new HashMap<String, Object>();
        Person p = new Person();
        p.setAge(20);
        p.setName("张三");
        p.setPhone("18616231623");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setAge(2);
        p1.setName("张小三");
        p1.setPhone("18616231623");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setAge(2);
        p2.setName("张小三");
        p2.setPhone("18616231623");
        p2.setBirthday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        p.setFaimlies(list);
        map.put("person", p);
        String beanMap = FastJSONHelper.serialize(map);
        System.out.println("beanMap:" + beanMap);
    }

    /**
     * 将list转jsonString
     */
    @Test
    public void listConvertToString() {
        /**
         * list中存入String类型
         */
        List<String> listString = new ArrayList<String>();
        listString.add("1");
        listString.add("2");
        listString.add("3");
        listString.add("4");
        String strList = FastJSONHelper.serialize(listString);
        System.out.println("strList:" + strList);
        System.out.println("***********************************************");

        /**
         * list中存入Person类型
         */
        List<Person> listBean = new ArrayList<Person>();
        Person p = new Person("李四", 20, "18616231564", new Date(), getFamilyListPerson());
        listBean.add(p);
        String beanList = FastJSONHelper.serialize(listBean);//将list转jsonString
        System.out.println("beanList:" + beanList);

        JSONArray jsonArray = JSON.parseArray(beanList);//将list转成的jsonString再转成jsonArray
        Person po = null;
        for (Object object : jsonArray) {
            po = FastJSONHelper.deserialize(FastJSONHelper.serialize(object), Person.class);
            System.out.println("po:" + po);
        }

    }

    private List<Person> getFamilyListPerson() {
        List<Person> list = new ArrayList<Person>();
        Person pp = new Person();
        pp.setAge(2);
        pp.setName("李小四");
        pp.setPhone("11111111111");
        list.add(pp);
        return list;
    }

    private String getJson() {
        JSONObject json = new JSONObject();
        json.put("borrowerCertiNo", "");
        json.put("borrowerName", "李晶");
        json.put("thirdCode", "18");
        return json.toJSONString();
        //String strJson="{"borrowerCertiNo":"13100219800625401X","borrowerName":"李晶","depositRate":"0.068","endDate":"2015-04-15 16:38:44","loanPeriod":"3M","requirementNo":"21117212273967104","thirdCode":"18","thirdProductId":"10125","transactionAmount":"1200"}";
    }

    private void operateJson() {
        String json = getJson();
        JSONObject jsonObj = JSONObject.parseObject(json);
        String borrowerCertiNo = jsonObj.getString("borrowerCertiNo");
        String borrowerCertiNo1 = (String) jsonObj.get("borrowerCertiNo");
        if (StringUtils.isBlank(borrowerCertiNo)) {
            System.out.println("null_____________");
        } else {
            System.out.println("not null_____________");
        }
        System.out.println("json:" + json);
        System.out.println("jsonObj:" + jsonObj);
        System.out.println("borrowerCertiNo:" + borrowerCertiNo);
        System.out.println("borrowerCertiNo1:" + borrowerCertiNo1);
    }

}
