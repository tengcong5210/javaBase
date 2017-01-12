package com.java.json;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    private static String getOthreCreditInfo() {
        JSONObject otherInfoJson = new JSONObject();
        JSONObject linkmenJson = new JSONObject();
        linkmenJson.put("relativeName", "陆嫂");
        linkmenJson.put("relationship", "配偶");
        linkmenJson.put("phone", "13683612115");
        otherInfoJson.put("linkmen", linkmenJson.toString());
        return otherInfoJson.toString();
    }

    public static void testJson() throws Exception {
        JSONObject json = JSONObject.parseObject("{\"aa\":\"bb\"}");
        System.out.println("aa:" + json);
        json = json == null ? new JSONObject() : json;
        json.put("rejectReason", "拒保原因");
        System.out.println("bb:" + json);

    }

    public static void main(String[] args) throws Exception {
        String json = getOthreCreditInfo();
        Map<String, String> map = new HashMap<String, String>();

        JSONObject testJson = JSONObject.parseObject(json);

        String sss = map.get("aaaa");
        System.out.println("sssss:" + sss);
        JSONObject js = JSONObject.parseObject(null);//fastjson支持 parseObject（null） 如果为null 构建的js业务Null
        System.out.println("json:" + json);
        js = js == null ? new JSONObject() : js;
        String linkmenString = js.getString("linkmen");
        System.out.println("linkmenString:" + linkmenString);

        JSONObject j = JSONObject.parseObject(linkmenString);
        System.out.println("j:" + j);

        JSONObject linkmenJson = js.getJSONObject("linkmen");
        System.out.println("linkmenJson:" + linkmenJson);

        testJson();
        String ganjiO2oJson = getOthreCreditInfo2();
        JSONObject ganjiO2O = JSON.parseObject(ganjiO2oJson);
        ganjiO2O.remove("browse_qiuzhi_timestamp");
        //        String aa = ganjiO2O.getString("browse_qiuzhi_timestamp");
        System.out.println("=============:" + ganjiO2O);

    }

    private static String getOthreCreditInfo2() {
        //      array (
        //
        //                'loanApplyDate' => '20150804114920',
        //                'applyType' => '1',
        //                'thirdCode' => '18',
        //                'thridProductId' => '1300005009001',
        //                'thirdUserNo' => '500129654',
        //                'loanApplyNo' => '18012015080400000079', //申请单号
        //                'name' => '张三', //员工姓名
        //                'certiType' => '1', //证件类型
        //                'certiNo' => '500101198406223316', //身份证号
        //                'applyAmount' => '5000',
        //                'loanPeriod' => '30D', //贷款期限
        //                'phone' => '13436927431', //入职员工手机号码
        //                'otherCreditInfo' => array(
        //                  'linkmen' => array (
        //                    'relativeName' => '陆金凡', //亲属姓名
        //                    'relationship' => '配偶', //关系
        //                    'phone' => '13683612115', //手机
        //                  ),
        //                  'address' => '北京市朝阳区33路公交车旁边',
        //                  'applyAmount' => 5000, //月薪
        //                  'beginCompanyWork' => '2015-01-08' //入职时间
        //                  'atCompanyWork' => 1 //是否在职(1：是 0：否)
        //                  'companyPosition' => '普工' //职位
        //                  'companyPhone' => '入职员工手机号码'
        //                  'workFullTime' => 1 //是否全职(1：是 0：否)
        //                  'workPlace' => '北京'， //工作地点
        //                  'gj_apply_ip' => '192.168.12.84',  //申请人ip
        //                  'uuid':"7324999502352370595182-707047661" //uuid
        //                  'gj_register_phone' => '13436927431', //注册赶集会员所留手机号
        //
        //                  'jianli_work_year' => '3' //工龄, (招聘提供：简历里面有个工作年限）
        //                  'jianli_salary' => '5000', //简历期望月薪(招聘提供)
        //                  'jianli_position' => '普工', //简历填写职位类型(招聘提供)
        //                  'jianli_work_city' => '北京', //简历期望工作城市(招聘提供)
        //                  'jianli_phone' => , //简历预留手机号码(招聘提供)
        //
        //                  'browse_qiuzhi_timestamp' => array(1438660042080, 1438660042180, 1438660042280, 1438660042980) //求职频道浏览总时长(数据组提供)
        //                )
        //              ),
        //            ). 
        //        otherCreditInfo={"address":"北京市朝阳区33路公交车旁边","atCompanyWork":"1","beginCompanyWork":"2015-01-08","browse_qiuzhi_timestamp":["1438660042080","1438660042180","1438660042280","1438660042980"],"companyPhone":"入职员工手机号码","companyPosition":"普工","gj_apply_ip":"192.168.12.84","gj_register_phone":"13436927431","jianli_phone":"13436927431","jianli_position":"普工","jianli_salary":"5000","jianli_work_city":"北京","jianli_work_year":"3","linkmen":{"phone":"18616236131","relationship":"父亲","relativeName":"李云龙"},"uuid":"7324999502352370595182-707047661","workFullTime":"1","workPlace":"北京"}
        JSONObject json = new JSONObject();
        JSONObject linkmenJson = new JSONObject();
        linkmenJson.put("relativeName", "李云龙");
        linkmenJson.put("relationship", "父亲");
        linkmenJson.put("phone", "18616236131");
        json.put("linkmen", linkmenJson);
        json.put("address", "北京市朝阳区33路公交车旁边");
        json.put("beginCompanyWork", "2015-01-08");
        json.put("atCompanyWork", "1");
        json.put("companyPosition", "普工");
        json.put("companyPhone", "入职员工手机号码");
        json.put("workFullTime", "1");
        json.put("workPlace", "北京");
        json.put("gj_apply_ip", "192.168.12.84");
        json.put("uuid", "7324999502352370595182-707047661");
        json.put("gj_register_phone", "13436927431");
        json.put("jianli_work_year", "3");
        json.put("jianli_salary", "5000");
        json.put("jianli_position", "普工");
        json.put("jianli_work_city", "北京");
        json.put("jianli_phone", "13436927431");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("1438660042080");
        jsonArray.add("1438660042180");
        jsonArray.add("1438660042280");
        jsonArray.add("1438660042980");
        json.put("browse_qiuzhi_timestamp", jsonArray);
        return json.toString();
    }

    public static String testJsonArrayIsNull() {

        //        {
        //            "ret": 0,
        //            "data": {
        //                "isOverdue": false,
        //                "insurance": "众安本息履约保障",
        //                "periods": "12",
        //                "loanAmount": "1500000",
        //                "raiseIsEnd": false,
        //                "remainAmount": 1500000,
        //                "repayedPrincipal": "0",
        //                "combineStatusDes": "立即投资",
        //                "title": "消费贷48493753975472128",
        //                "allowInvest": true,
        //                "remainTime": "7天4小时",
        //                "createDate": "1446715327",
        //                "repayDate": "0",
        //                "repayedOtherFee": "0",
        //                "currentPeriod": "0",
        //                "statusDes": "募集中",
        //                "passedDays": 16744,
        //                "period": "12个月",
        //                "isTradeStart": false,
        //                "process": 0,
        //                "repayTypeDes": "按月付息，到期还本",
        //                "allowReturn": false,
        //                "loanRate": 900,
        //                "repayedInterest": "0",
        //                "loanId": "48493753975472128"
        //            },
        //            "msg": "ok"
        //        }
        JSONObject json = new JSONObject();
        json.put("ret", 0);
        json.put("b", "ok");
        JSONObject dataJson = new JSONObject();
        dataJson.put("isOverdue", false);
        dataJson.put("insurance", false);
        dataJson.put("periods", "12");
        dataJson.put("loanAmount", "1500000");
        dataJson.put("raiseIsEnd", false);
        dataJson.put("remainAmount", 1500000);
        dataJson.put("repayedPrincipal", "0");
        dataJson.put("combineStatusDes", "立即投资");
        dataJson.put("title", "消费贷48493753975472128");
        dataJson.put("allowInvest", true);
        dataJson.put("remainTime", "7天4小时");
        dataJson.put("createDate", "1446715327");
        dataJson.put("repayDate", "0");
        dataJson.put("repayedOtherFee", "0");
        dataJson.put("currentPeriod", "0");
        dataJson.put("statusDes", "募集中");
        dataJson.put("passedDays", 16744);
        dataJson.put("period", "12个月");
        dataJson.put("isTradeStart", false);
        dataJson.put("process", 0);
        dataJson.put("repayTypeDes", "按月付息，到期还本");
        dataJson.put("allowReturn", false);
        dataJson.put("loanRate", 900);
        dataJson.put("repayedInterest", "0");
        dataJson.put("loanId", "48493753975472128");
        json.put("data", dataJson);
        return json.toString();

    }

    public static void testQueryRementPlain() {
        String result = testJsonArrayIsNull();
        try {
            //            List<OpenRepaymentPlanQryResDTO> openRepaymentPlanQryResList = new ArrayList<OpenRepaymentPlanQryResDTO>();
            Map<String, Object> resMap = new HashMap<String, Object>();
            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONArray planA = jsonObject.getJSONArray("repayPlanItems");
            if (null != planA) {
                for (int i = 0; i < planA.size(); i++) {

                }
            }
            for (Map.Entry<String, Object> oneEnt : jsonObject.entrySet()) {
                if (!oneEnt.getKey().equals("repayPlanItems")) {
                    resMap.put(oneEnt.getKey(), oneEnt.getValue());
                }
            }
            //            resMap.put("repaymentPlanList", openRepaymentPlanQryResList);
        } catch (Exception e) {
            System.out.println("system.error:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
