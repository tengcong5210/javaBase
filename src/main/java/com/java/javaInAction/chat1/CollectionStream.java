package com.java.javaInAction.chat1;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.java.javaInAction.chat1.bean.Currency;
import com.java.javaInAction.chat1.bean.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * 查询出交易金额大于1000并按货币分组
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public class CollectionStream {

    public static void main(String[] args) {
        List<Transaction> transactions= Arrays.asList(new Transaction(999,"CNY"),
                new Transaction(1500,"CNY"),
                new Transaction(1900,"CNY"),
                new Transaction(1800,"USD"),
                new Transaction(1200,"USD"),
                new Transaction(1000,"JPY"));

        // java8之前写法
        Map<String,List<Transaction>> curTransMap= Maps.newHashMap();
        for(Transaction tr:transactions){
            if(tr.getPrice()>1000){
                String currency=tr.getCurrency();
                List<Transaction> trans=curTransMap.get(currency);
                if(trans==null){
                    trans= Lists.newArrayList();
                    curTransMap.put(currency,trans);
                }
                trans.add(tr);
            }
        }

        System.out.println("java8之前写法："+JSON.toJSONString(curTransMap));


        Map<String,List<Transaction>> curTransMap8=transactions.stream()
                .filter((Transaction t)->t.getPrice()>1000).collect(groupingBy(Transaction::getCurrency));

        System.out.println("java8写法："+JSON.toJSONString(curTransMap8));








    }

}