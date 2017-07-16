package com.java.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.java.json.bean.LoanApply;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tengcongcong
 * @create 2017-07-14 16:52
 * @Version 1.0
 **/
public class JsonTest2 {
    @Test
    public void testJsonStrToJsonArray(){
        String str="{\n" +
                "    \"respCode\": \"00\",\n" +
                "    \"respMessage\": \"成功\",\n" +
                "    \"data\": {\n" +
                "        \"leftLoanPeriod\": 0,\n" +
                "        \"projNo\": 14194514,\n" +
                "        \"totalLoanPrincipalAmt\": 60000,\n" +
                "        \"totalLoanPeriod\": 6,\n" +
                "        \"extId\": \"20170623141723827079\",\n" +
                "        \"paymentPlanDetail\": [\n" +
                "            {\n" +
                "                \"loanPeriod\": 1,\n" +
                "                \"origPrincipalBal\": 10000,\n" +
                "                \"origInterest\": 1302,\n" +
                "                \"origPenalty\": 0,\n" +
                "                \"origFee\": 0,\n" +
                "                \"repayedPrincipalBal\": 60000,\n" +
                "                \"repayedInterestAmt\": 336,\n" +
                "                \"repayedPenalty\": 0,\n" +
                "                \"repayedFeeAmt\": 0,\n" +
                "                \"paymentDate\": \"2073-05-01\",\n" +
                "                \"status\": \"已还款\",\n" +
                "                \"lastPaymentDate\": \"2073-04-08\",\n" +
                "                \"realTimePrincipalBal\": 0,\n" +
                "                \"realTimeInterest\": 0,\n" +
                "                \"realTimeFee\": 0,\n" +
                "                \"realTimePenalty\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"loanPeriod\": 1,\n" +
                "                \"origPrincipalBal\": 10000,\n" +
                "                \"origInterest\": 1302,\n" +
                "                \"origPenalty\": 0,\n" +
                "                \"origFee\": 0,\n" +
                "                \"repayedPrincipalBal\": 60000,\n" +
                "                \"repayedInterestAmt\": 336,\n" +
                "                \"repayedPenalty\": 0,\n" +
                "                \"repayedFeeAmt\": 0,\n" +
                "                \"paymentDate\": \"2073-05-01\",\n" +
                "                \"status\": \"已还款\",\n" +
                "                \"lastPaymentDate\": \"2073-04-08\",\n" +
                "                \"realTimePrincipalBal\": 0,\n" +
                "                \"realTimeInterest\": 0,\n" +
                "                \"realTimeFee\": 0,\n" +
                "                \"realTimePenalty\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject=JSON.parseObject(str);

        List<LoanApply> list1=new ArrayList<LoanApply>();
        LoanApply loanApply1=new LoanApply("1","20");
        LoanApply loanApply2=new LoanApply("2","30");
        list1.add(loanApply1);
        list1.add(loanApply2);

        List<LoanApply> list2=new ArrayList<LoanApply>();
        LoanApply loanApply3=new LoanApply("3","200");
        LoanApply loanApply4=new LoanApply("4","300");
        list2.add(loanApply3);
        list2.add(loanApply4);

        // step1:根据产品code和机构code查询还款计划属性配置，并得配置的根json的key和子json的key。
        // 这边要增加字段，属性级别(1.2,3) 根据属性级别进行升序，并主装成Map<String,List<T>> 的map
        Map<String,List<LoanApply>> map=new LinkedHashMap<String, List<LoanApply>>();
        map.put("data",list1);
        map.put("paymentPlanDetail",list2);

        //step2:遍历map,得到key，value
        String jsonStr;
        for(Map.Entry<String,List<LoanApply>> entry:map.entrySet()){
            String proType=entry.getKey();
            List<LoanApply> loanApplyList=entry.getValue();
            jsonStr=jsonObject.getString(proType);
            System.out.println("jsonStr:"+jsonStr);

            jsonObject=JSON.parseObject(jsonStr);
            char[] strChar=jsonStr.substring(0,1).toCharArray();
            char fisrtChar=strChar[0];
            if(fisrtChar=='{'){
                JSONObject rootJson=JSON.parseObject(jsonStr);
                if(!CollectionUtils.isEmpty(loanApplyList)){
                    for(LoanApply apply:loanApplyList){

                    }
                }

            }else if(fisrtChar=='['){
                JSONArray jsonArray= JSON.parseArray(jsonStr);
                System.out.println("结束");
            }


        }

        /*String jsonStr=jsonObject.getString("data");
        char[] strChar=jsonStr.substring(0,1).toCharArray();
        char fisrtChar=strChar[0];
        if(fisrtChar=='{'){

        }else if(fisrtChar=='['){
            JSONArray jsonArray= JSON.parseArray(jsonStr);
            System.out.println("结束");
        }*/

    }
}
