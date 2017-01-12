package com.java.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class SqlTool2 {
    /**
     * 需要更改成以下保额和excel文件列对应
     */
    public static final String[] SUMINSUREDS                  = { "1955280.69", "1467240.77", "4962948.00",
            "4962948.00", "4962949.00", "2469956.00", "2469956.00", "2469956.00", "2469956.00", "2469956.00",
            "2469956.00", "2469956.00", "2469956.00", "2469956.00", "2469956.00", "2469956.00", "2469966.00",
            "2475322.00", "2475322.00", "2475322.00", "2475322.00", "2475322.00", "2475322.00", "2475322.00",
            "2475325.00", "1975268.65", "2467657.00", "2467657.00", "2467657.00", "2467657.00", "2467657.00",
            "2467657.00", "2467657.00", "2467657.00", "2467657.00", "2467657.00", "2467657.00", "2467667.00",
            "2466771.00", "2466771.00", "2466771.00", "2466771.00", "2466771.00", "2466771.00", "2466771.00",
            "2466771.00", "2466771.00", "2466771.00", "2466771.00", "2466782.00", "1481974.00", "1481974.00",
            "1481974.00", "1481974.00", "1481974.00", "1481974.00", "1481974.00", "1481974.00", "1481974.00",
            "1481974.00", "1481974.00", "1481975.00", "1853582.00", "1853582.00", "1853582.00", "1853582.00",
            "1853582.00", "1853582.00", "1853582.00", "1853582.00", "1853582.00", "1853582.00", "1853582.00",
            "1853582.00", "1853582.00", "1853582.00", "1853582.00", "1853587.00", "4938844.00", "987768.00",
            "988114.00", "987375.00", "4942310.00"           };
    /**
     * 需要更改成以下的保费和excel文件列对应
     */
    public static final String[] PREMIUMS                     = { "1955.28", "1451.16", "2447.48", "2447.48",
            "2447.48", "1238.36", "1238.36", "1238.36", "1238.36", "1238.36", "1238.36", "1238.36", "1238.36",
            "1238.36", "1238.36", "1238.36", "1238.37", "1241.05", "1241.05", "1241.05", "1241.05", "1241.05",
            "1241.05", "1241.05", "1241.05", "984.92 ", "1203.40", "1203.40", "1203.40", "1203.40", "1203.40",
            "1203.40", "1203.40", "1203.40", "1203.40", "1203.40", "1203.40", "1203.40", "1230.00", "1230.00",
            "1230.00", "1230.00", "1230.00", "1230.00", "1230.00", "1230.00", "1230.00", "1230.00", "1230.00",
            "1230.00", "743.01 ", "743.01 ", "743.01 ", "743.01 ", "743.01 ", "743.01 ", "743.01 ", "743.01 ",
            "743.01 ", "743.01 ", "743.01 ", "743.01 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ",
            "888.70 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ", "888.70 ",
            "888.70 ", "888.70 ", "2449.12", "489.83 ", "492.70 ", "492.34 ", "2450.84" };
    /**
     * 产品机构代码和excel文件列对应
     */
    public static final String[] ORGPRODUCTCODES              = { "CMBHZ20150306000661000241000000790000",
            "CMBHZ20150310000661000241000000810000", "CMBHZ20150313000661000241000000820000",
            "CMBHZ20150313000661000241000000820001", "CMBHZ20150313000661000241000000820002",
            "CMBHZ20150319000661000241000000850000", "CMBHZ20150319000661000241000000850001",
            "CMBHZ20150319000661000241000000850002", "CMBHZ20150319000661000241000000850003",
            "CMBHZ20150319000661000241000000850004", "CMBHZ20150319000661000241000000850005",
            "CMBHZ20150319000661000241000000850006", "CMBHZ20150319000661000241000000850007",
            "CMBHZ20150319000661000241000000850008", "CMBHZ20150319000661000241000000850009",
            "CMBHZ20150319000661000241000000850010", "CMBHZ20150319000661000241000000850011",
            "CMBHZ20150319000661000241000000860000", "CMBHZ20150319000661000241000000860001",
            "CMBHZ20150319000661000241000000860002", "CMBHZ20150319000661000241000000860003",
            "CMBHZ20150319000661000241000000860004", "CMBHZ20150319000661000241000000860005",
            "CMBHZ20150319000661000241000000860006", "CMBHZ20150319000661000241000000860007",
            "CMBHZ20150323000661000241000000890000", "CMBHZ20150325000661000241000000930000",
            "CMBHZ20150325000661000241000000930001", "CMBHZ20150325000661000241000000930002",
            "CMBHZ20150325000661000241000000930003", "CMBHZ20150325000661000241000000930004",
            "CMBHZ20150325000661000241000000930005", "CMBHZ20150325000661000241000000930006",
            "CMBHZ20150325000661000241000000930007", "CMBHZ20150325000661000241000000930008",
            "CMBHZ20150325000661000241000000930009", "CMBHZ20150325000661000241000000930010",
            "CMBHZ20150325000661000241000000930011", "CMBHZ20150325000661000241000000920000",
            "CMBHZ20150325000661000241000000920001", "CMBHZ20150325000661000241000000920002",
            "CMBHZ20150325000661000241000000920003", "CMBHZ20150325000661000241000000920004",
            "CMBHZ20150325000661000241000000920005", "CMBHZ20150325000661000241000000920006",
            "CMBHZ20150325000661000241000000920007", "CMBHZ20150325000661000241000000920008",
            "CMBHZ20150325000661000241000000920009", "CMBHZ20150325000661000241000000920010",
            "CMBHZ20150325000661000241000000920011", "CMBHZ20150403000661000241000000960000",
            "CMBHZ20150403000661000241000000960001", "CMBHZ20150403000661000241000000960002",
            "CMBHZ20150403000661000241000000960003", "CMBHZ20150403000661000241000000960004",
            "CMBHZ20150403000661000241000000960005", "CMBHZ20150403000661000241000000960006",
            "CMBHZ20150403000661000241000000960007", "CMBHZ20150403000661000241000000960008",
            "CMBHZ20150403000661000241000000960009", "CMBHZ20150403000661000241000000960010",
            "CMBHZ20150403000661000241000000960011", "CMBHZ20150403000661000241000000970000",
            "CMBHZ20150403000661000241000000970001", "CMBHZ20150403000661000241000000970002",
            "CMBHZ20150403000661000241000000970003", "CMBHZ20150403000661000241000000970004",
            "CMBHZ20150403000661000241000000970005", "CMBHZ20150403000661000241000000970006",
            "CMBHZ20150403000661000241000000970007", "CMBHZ20150403000661000241000000970008",
            "CMBHZ20150403000661000241000000970009", "CMBHZ20150403000661000241000000970010",
            "CMBHZ20150403000661000241000000970011", "CMBHZ20150403000661000241000000970012",
            "CMBHZ20150403000661000241000000970013", "CMBHZ20150403000661000241000000970014",
            "CMBHZ20150403000661000241000000970015", "CMBHZ20150422000661000241000001030000",
            "CMBHZ20150429000661000241000001100000", "CMBHZ20150506000661000241000001490000",
            "CMBHZ20150514000661000241000001650000", "CMBHZ20150602000661000241000008340000" };
    /**
     * 产品机构代码（通过policy_rout查出来的，注意： 顺序与excel不一致，为了对应policy_rout中的policyId）
     */
    public static final String[] ORGPRODUCTCODE_POLICY_ROUT   = { "CMBHZ20150403000661000241000000970000",
            "CMBHZ20150403000661000241000000970001", "CMBHZ20150403000661000241000000970002",
            "CMBHZ20150403000661000241000000970003", "CMBHZ20150403000661000241000000970004",
            "CMBHZ20150403000661000241000000970005", "CMBHZ20150306000661000241000000790000",
            "CMBHZ20150403000661000241000000970006", "CMBHZ20150403000661000241000000970007",
            "CMBHZ20150403000661000241000000970008", "CMBHZ20150403000661000241000000970009",
            "CMBHZ20150403000661000241000000970010", "CMBHZ20150403000661000241000000970011",
            "CMBHZ20150403000661000241000000970012", "CMBHZ20150403000661000241000000970013",
            "CMBHZ20150403000661000241000000970014", "CMBHZ20150403000661000241000000970015",
            "CMBHZ20150403000661000241000000960000", "CMBHZ20150403000661000241000000960001",
            "CMBHZ20150403000661000241000000960002", "CMBHZ20150403000661000241000000960003",
            "CMBHZ20150403000661000241000000960004", "CMBHZ20150325000661000241000000920011",
            "CMBHZ20150403000661000241000000960005", "CMBHZ20150325000661000241000000920010",
            "CMBHZ20150403000661000241000000960006", "CMBHZ20150403000661000241000000960007",
            "CMBHZ20150403000661000241000000960008", "CMBHZ20150403000661000241000000960009",
            "CMBHZ20150325000661000241000000920009", "CMBHZ20150325000661000241000000920008",
            "CMBHZ20150325000661000241000000920007", "CMBHZ20150325000661000241000000920006",
            "CMBHZ20150403000661000241000000960010", "CMBHZ20150325000661000241000000920005",
            "CMBHZ20150403000661000241000000960011", "CMBHZ20150325000661000241000000920004",
            "CMBHZ20150325000661000241000000920003", "CMBHZ20150325000661000241000000920002",
            "CMBHZ20150325000661000241000000920001", "CMBHZ20150325000661000241000000920000",
            "CMBHZ20150325000661000241000000930011", "CMBHZ20150325000661000241000000930010",
            "CMBHZ20150325000661000241000000930009", "CMBHZ20150325000661000241000000930008",
            "CMBHZ20150325000661000241000000930007", "CMBHZ20150325000661000241000000930006",
            "CMBHZ20150325000661000241000000930005", "CMBHZ20150325000661000241000000930004",
            "CMBHZ20150325000661000241000000930003", "CMBHZ20150325000661000241000000930002",
            "CMBHZ20150325000661000241000000930001", "CMBHZ20150325000661000241000000930000",
            "CMBHZ20150310000661000241000000810000", "CMBHZ20150319000661000241000000850011",
            "CMBHZ20150422000661000241000001030000", "CMBHZ20150319000661000241000000850010",
            "CMBHZ20150319000661000241000000850009", "CMBHZ20150319000661000241000000850008",
            "CMBHZ20150319000661000241000000850007", "CMBHZ20150319000661000241000000850006",
            "CMBHZ20150319000661000241000000850005", "CMBHZ20150319000661000241000000850004",
            "CMBHZ20150319000661000241000000850003", "CMBHZ20150319000661000241000000850002",
            "CMBHZ20150319000661000241000000850001", "CMBHZ20150319000661000241000000850000",
            "CMBHZ20150429000661000241000001100000", "CMBHZ20150602000661000241000008340000",
            "CMBHZ20150319000661000241000000860007", "CMBHZ20150319000661000241000000860006",
            "CMBHZ20150319000661000241000000860005", "CMBHZ20150319000661000241000000860004",
            "CMBHZ20150319000661000241000000860003", "CMBHZ20150319000661000241000000860002",
            "CMBHZ20150319000661000241000000860001", "CMBHZ20150319000661000241000000860000",
            "CMBHZ20150313000661000241000000820002", "CMBHZ20150313000661000241000000820001",
            "CMBHZ20150313000661000241000000820000", "CMBHZ20150323000661000241000000890000",
            "CMBHZ20150506000661000241000001490000", "CMBHZ20150514000661000241000001650000" };
    /**
     * policyId（通过policy_rout查出来的，与ORGPRODUCTCODE_POLICY_ROUT数组顺序对应的）
     */
    public static final String[] POLICYIDS                    = { "2374217663", "2374202372", "2374206432",
            "2374220995", "2374206433", "2374225447", "2374206440", "2374202373", "2374202374", "2374206434",
            "2374199667", "2374199669", "2374225448", "2374202375", "2374202376", "2374216323", "2374207814",
            "2374211395", "2374220992", "2374225444", "2374220993", "2374216321", "2374203708", "2374206431",
            "2374203707", "2374220994", "2374216322", "2374211396", "2374199666", "2374207813", "2374231034",
            "2374203706", "2374222268", "2374225445", "2374217662", "2374225446", "2374212687", "2374207812",
            "2374217661", "2374226785", "2374222266", "2374226784", "2374207811", "2374226783", "2374207810",
            "2374207809", "2374203705", "2374203704", "2374203703", "2374212686", "2374231032", "2374212685",
            "2374207808", "2374202366", "2374216320", "2374203709", "2374206430", "2374225441", "2374220989",
            "2374225440", "2374216318", "2374202369", "2374202368", "2374206429", "2374216317", "2374206428",
            "2374220988", "2374231035", "2374222269", "2374211394", "2374220990", "2374225443", "2374217660",
            "2374212684", "2374211391", "2374225442", "2374202370", "2374220987", "2374211389", "2374202367",
            "2374199665", "2374212688", "2374203710"         };
    /**
     * policy表中的产品机构代码(通过policy表中查查出的)
     */
    public static final String[] POLICY_ORGPRODUCTCODES       = { "CMBHZ20150403000661000241000000970003",
            "CMBHZ20150403000661000241000000960006", "CMBHZ20150403000661000241000000960003",
            "CMBHZ20150403000661000241000000960001", "CMBHZ20150319000661000241000000860006",
            "CMBHZ20150319000661000241000000850008", "CMBHZ20150319000661000241000000850000",
            "CMBHZ20150313000661000241000000820002", "CMBHZ20150306000661000241000000790000",
            "CMBHZ20150403000661000241000000970008", "CMBHZ20150403000661000241000000970004",
            "CMBHZ20150403000661000241000000970002", "CMBHZ20150403000661000241000000960005",
            "CMBHZ20150319000661000241000000850010", "CMBHZ20150403000661000241000000970010",
            "CMBHZ20150403000661000241000000970009", "CMBHZ20150403000661000241000000960009",
            "CMBHZ20150323000661000241000000890000", "CMBHZ20150319000661000241000000850003",
            "CMBHZ20150319000661000241000000850001", "CMBHZ20150403000661000241000000970000",
            "CMBHZ20150325000661000241000000920005", "CMBHZ20150325000661000241000000920002",
            "CMBHZ20150319000661000241000000860004", "CMBHZ20150403000661000241000000970014",
            "CMBHZ20150403000661000241000000960007", "CMBHZ20150403000661000241000000960004",
            "CMBHZ20150319000661000241000000850011", "CMBHZ20150319000661000241000000850006",
            "CMBHZ20150319000661000241000000850002", "CMBHZ20150403000661000241000000970013",
            "CMBHZ20150403000661000241000000970012", "CMBHZ20150403000661000241000000970007",
            "CMBHZ20150403000661000241000000970006", "CMBHZ20150403000661000241000000970001",
            "CMBHZ20150319000661000241000000860000", "CMBHZ20150319000661000241000000850005",
            "CMBHZ20150403000661000241000000970015", "CMBHZ20150319000661000241000000850004",
            "CMBHZ20150325000661000241000000920009", "CMBHZ20150313000661000241000000820000",
            "CMBHZ20150325000661000241000000920003", "CMBHZ20150310000661000241000000810000",
            "CMBHZ20150325000661000241000000930010", "CMBHZ20150325000661000241000000930008",
            "CMBHZ20150325000661000241000000930007", "CMBHZ20150325000661000241000000930000",
            "CMBHZ20150325000661000241000000920001", "CMBHZ20150325000661000241000000930011",
            "CMBHZ20150325000661000241000000930009", "CMBHZ20150403000661000241000000970011",
            "CMBHZ20150403000661000241000000970005", "CMBHZ20150403000661000241000000960011",
            "CMBHZ20150403000661000241000000960010", "CMBHZ20150403000661000241000000960002",
            "CMBHZ20150319000661000241000000860005", "CMBHZ20150319000661000241000000860001",
            "CMBHZ20150319000661000241000000850009", "CMBHZ20150319000661000241000000850007",
            "CMBHZ20150403000661000241000000960008", "CMBHZ20150403000661000241000000960000",
            "CMBHZ20150319000661000241000000860007", "CMBHZ20150319000661000241000000860002",
            "CMBHZ20150313000661000241000000820001", "CMBHZ20150602000661000241000008340000",
            "CMBHZ20150325000661000241000000920006", "CMBHZ20150325000661000241000000920000",
            "CMBHZ20150506000661000241000001490000", "CMBHZ20150325000661000241000000920004",
            "CMBHZ20150325000661000241000000930003", "CMBHZ20150325000661000241000000930001",
            "CMBHZ20150319000661000241000000860003", "CMBHZ20150514000661000241000001650000",
            "CMBHZ20150422000661000241000001030000", "CMBHZ20150325000661000241000000920011",
            "CMBHZ20150325000661000241000000920010", "CMBHZ20150325000661000241000000920007",
            "CMBHZ20150325000661000241000000930006", "CMBHZ20150325000661000241000000930005",
            "CMBHZ20150325000661000241000000930004", "CMBHZ20150429000661000241000001100000",
            "CMBHZ20150325000661000241000000920008", "CMBHZ20150325000661000241000000930002" };
    /**
     * policy表中的policyId 顺序与POLICY_ORGPRODUCTCODE要对应(通过policy表中查查出的)
     */
    public static final String[] POLICY_POLICYIDS             = { "2374220995", "2374220994", "2374220993",
            "2374220992", "2374220990", "2374220989", "2374220988", "2374220987", "2374206440", "2374206434",
            "2374206433", "2374206432", "2374206431", "2374206430", "2374199669", "2374199667", "2374199666",
            "2374199665", "2374206429", "2374206428", "2374217663", "2374217662", "2374217661", "2374217660",
            "2374216323", "2374216322", "2374216321", "2374216320", "2374216318", "2374216317", "2374202376",
            "2374202375", "2374202374", "2374202373", "2374202372", "2374202370", "2374202369", "2374207814",
            "2374202368", "2374207813", "2374202367", "2374207812", "2374202366", "2374207811", "2374207810",
            "2374207809", "2374207808", "2374226785", "2374226784", "2374226783", "2374225448", "2374225447",
            "2374225446", "2374225445", "2374225444", "2374225443", "2374225442", "2374225441", "2374225440",
            "2374211396", "2374211395", "2374211394", "2374211391", "2374211389", "2374222269", "2374222268",
            "2374222266", "2374212688", "2374212687", "2374212686", "2374212685", "2374212684", "2374203710",
            "2374203709", "2374203708", "2374203707", "2374203706", "2374203705", "2374203704", "2374203703",
            "2374231035", "2374231034", "2374231032"         };
    /**
     * policy表中的extra_common_info字段中的primaryExpiryDate属性，其他primarySumInsured、
     * primaryPremium是要改更变的
     */
    public static final String[] POLICY_PRIMARYEXPIRYDATES    = { "2015-09-30 23:59:59", "2015-10-08 23:59:59",
            "2015-10-08 23:59:59", "2015-10-08 23:59:59", "2015-09-20 23:59:59", "2015-09-20 23:59:59",
            "2015-09-20 23:59:59", "2015-09-12 23:59:59", "2016-03-05 23:59:59", "2015-09-30 23:59:59",
            "2015-09-30 23:59:59", "2015-09-30 23:59:59", "2015-10-08 23:59:59", "2015-09-20 23:59:59",
            "2015-09-30 23:59:59", "2015-09-30 23:59:59", "2015-10-08 23:59:59", "2015-09-23 23:59:59",
            "2015-09-20 23:59:59", "2015-09-20 23:59:59", "2015-09-30 23:59:59", "2015-09-25 23:59:59",
            "2015-09-25 23:59:59", "2015-09-20 23:59:59", "2015-09-30 23:59:59", "2015-10-08 23:59:59",
            "2015-10-08 23:59:59", "2015-09-20 23:59:59", "2015-09-20 23:59:59", "2015-09-20 23:59:59",
            "2015-09-30 23:59:59", "2015-09-30 23:59:59", "2015-09-30 23:59:59", "2015-09-30 23:59:59",
            "2015-09-30 23:59:59", "2015-09-20 23:59:59", "2015-09-20 23:59:59", "2015-09-30 23:59:59",
            "2015-09-20 23:59:59", "2015-09-25 23:59:59", "2015-09-12 23:59:59", "2015-09-25 23:59:59",
            "2016-03-07 23:59:59", "2015-09-21 23:59:59", "2015-09-21 23:59:59", "2015-09-21 23:59:59",
            "2015-09-21 23:59:59", "2015-09-25 23:59:59", "2015-09-21 23:59:59", "2015-09-21 23:59:59",
            "2015-09-30 23:59:59", "2015-09-30 23:59:59", "2015-10-08 23:59:59", "2015-10-08 23:59:59",
            "2015-10-08 23:59:59", "2015-09-20 23:59:59", "2015-09-20 23:59:59", "2015-09-20 23:59:59",
            "2015-09-20 23:59:59", "2015-10-08 23:59:59", "2015-10-08 23:59:59", "2015-09-20 23:59:59",
            "2015-09-20 23:59:59", "2015-09-12 23:59:59", "2015-12-02 23:59:59", "2015-09-25 23:59:59",
            "2015-09-25 23:59:59", "2015-11-06 23:59:59", "2015-09-25 23:59:59", "2015-09-21 23:59:59",
            "2015-09-21 23:59:59", "2015-09-20 23:59:59", "2015-11-14 23:59:59", "2015-10-22 23:59:59",
            "2015-09-25 23:59:59", "2015-09-25 23:59:59", "2015-09-25 23:59:59", "2015-09-21 23:59:59",
            "2015-09-21 23:59:59", "2015-09-21 23:59:59", "2015-10-29 23:59:59", "2015-09-25 23:59:59",
            "2015-09-21 23:59:59"                            };
    /**
     * policy表的tablename
     */
    public static final String[] POLICY_TABLE_NAMES           = { "policy_01.policy_0170", "policy_03.policy_0419",
            "policy_03.policy_0418", "policy_04.policy_0576", "policy_01.policy_0154", "policy_01.policy_0153",
            "policy_01.policy_0224", "policy_02.policy_0320", "policy_01.policy_0223", "policy_03.policy_0417",
            "policy_03.policy_0416", "policy_02.policy_0319", "policy_04.policy_0519", "policy_01.policy_0152",
            "policy_04.policy_0518", "policy_01.policy_0201", "policy_02.policy_0296", "policy_03.policy_0394",
            "policy_04.policy_0517", "policy_04.policy_0553", "policy_05.policy_0675", "policy_02.policy_0266",
            "policy_04.policy_0516", "policy_01.policy_0130", "policy_04.policy_0550", "policy_01.policy_0222",
            "policy_04.policy_0610", "policy_03.policy_0484", "policy_02.policy_0265", "policy_03.policy_0418",
            "policy_05.policy_0672", "policy_02.policy_0264", "policy_04.policy_0608", "policy_05.policy_0762",
            "policy_06.policy_0801", "policy_03.policy_0417", "policy_05.policy_0761", "policy_05.policy_0760",
            "policy_03.policy_0443", "policy_05.policy_0674", "policy_06.policy_0803", "policy_05.policy_0673",
            "policy_05.policy_0765", "policy_05.policy_0764", "policy_05.policy_0763", "policy_03.policy_0442",
            "policy_03.policy_0420", "policy_03.policy_0486", "policy_03.policy_0419", "policy_03.policy_0485",
            "policy_04.policy_0549", "policy_01.policy_0128", "policy_04.policy_0515", "policy_00.policy_0127",
            "policy_02.policy_0295", "policy_01.policy_0200", "policy_00.policy_0126", "policy_02.policy_0294",
            "policy_04.policy_0548", "policy_01.policy_0221", "policy_04.policy_0514", "policy_04.policy_0513",
            "policy_02.policy_0263", "policy_03.policy_0392", "policy_01.policy_0199", "policy_00.policy_0125",
            "policy_01.policy_0198", "policy_04.policy_0512", "policy_03.policy_0391", "policy_03.policy_0390",
            "policy_01.policy_0197", "policy_01.policy_0220", "policy_01.policy_0218", "policy_03.policy_0511",
            "policy_03.policy_0389", "policy_03.policy_0388", "policy_02.policy_0293", "policy_03.policy_0416",
            "policy_05.policy_0759", "policy_06.policy_0800", "policy_05.policy_0671", "policy_05.policy_0737",
            "policy_04.policy_0607"                          };
    /**
     * policy表的tablename对应的policyId
     */
    public static final String[] POLICY_TABLENAME_POLICYIDS   = { "2374206440", "2374202366", "2374202367",
            "2374211389", "2374220987", "2374220988", "2374206428", "2374216317", "2374206429", "2374202368",
            "2374202369", "2374216318", "2374225440", "2374220989", "2374225441", "2374206430", "2374216320",
            "2374202370", "2374225442", "2374211391", "2374212684", "2374217660", "2374225443", "2374220990",
            "2374211394", "2374199665", "2374222266", "2374226785", "2374217661", "2374207812", "2374212687",
            "2374217662", "2374222268", "2374203706", "2374231034", "2374207813", "2374203707", "2374203708",
            "2374207808", "2374212685", "2374231032", "2374212686", "2374203703", "2374203704", "2374203705",
            "2374207809", "2374207810", "2374226783", "2374207811", "2374226784", "2374211395", "2374220992",
            "2374225444", "2374220993", "2374216321", "2374206431", "2374220994", "2374216322", "2374211396",
            "2374199666", "2374225445", "2374225446", "2374217663", "2374202372", "2374206432", "2374220995",
            "2374206433", "2374225447", "2374202373", "2374202374", "2374206434", "2374199667", "2374199669",
            "2374225448", "2374202375", "2374202376", "2374216323", "2374207814", "2374203709", "2374231035",
            "2374212688", "2374203710", "2374222269"         };
    /**
     * bill表的tablename列
     */
    public static final String[] BILL_TABLENAMES              = { "bill_00.bill_bill_0125", "bill_00.bill_bill_0126",
            "bill_00.bill_bill_0127", "bill_01.bill_bill_0128", "bill_01.bill_bill_0130", "bill_01.bill_bill_0152",
            "bill_01.bill_bill_0153", "bill_01.bill_bill_0154", "bill_01.bill_bill_0170", "bill_01.bill_bill_0197",
            "bill_01.bill_bill_0198", "bill_01.bill_bill_0199", "bill_01.bill_bill_0200", "bill_01.bill_bill_0201",
            "bill_01.bill_bill_0218", "bill_01.bill_bill_0220", "bill_01.bill_bill_0221", "bill_01.bill_bill_0222",
            "bill_01.bill_bill_0223", "bill_01.bill_bill_0224", "bill_02.bill_bill_0263", "bill_02.bill_bill_0264",
            "bill_02.bill_bill_0265", "bill_02.bill_bill_0266", "bill_02.bill_bill_0293", "bill_02.bill_bill_0294",
            "bill_02.bill_bill_0295", "bill_02.bill_bill_0296", "bill_02.bill_bill_0319", "bill_02.bill_bill_0320",
            "bill_03.bill_bill_0388", "bill_03.bill_bill_0389", "bill_03.bill_bill_0390", "bill_03.bill_bill_0391",
            "bill_03.bill_bill_0392", "bill_03.bill_bill_0394", "bill_03.bill_bill_0416", "bill_03.bill_bill_0416",
            "bill_03.bill_bill_0417", "bill_03.bill_bill_0417", "bill_03.bill_bill_0418", "bill_03.bill_bill_0418",
            "bill_03.bill_bill_0419", "bill_03.bill_bill_0419", "bill_03.bill_bill_0420", "bill_03.bill_bill_0442",
            "bill_03.bill_bill_0443", "bill_03.bill_bill_0484", "bill_03.bill_bill_0485", "bill_03.bill_bill_0486",
            "bill_03.bill_bill_0511", "bill_04.bill_bill_0512", "bill_04.bill_bill_0513", "bill_04.bill_bill_0514",
            "bill_04.bill_bill_0515", "bill_04.bill_bill_0516", "bill_04.bill_bill_0517", "bill_04.bill_bill_0518",
            "bill_04.bill_bill_0519", "bill_04.bill_bill_0548", "bill_04.bill_bill_0549", "bill_04.bill_bill_0550",
            "bill_04.bill_bill_0553", "bill_04.bill_bill_0576", "bill_04.bill_bill_0607", "bill_04.bill_bill_0608",
            "bill_04.bill_bill_0610", "bill_05.bill_bill_0671", "bill_05.bill_bill_0672", "bill_05.bill_bill_0673",
            "bill_05.bill_bill_0674", "bill_05.bill_bill_0675", "bill_05.bill_bill_0737", "bill_05.bill_bill_0759",
            "bill_05.bill_bill_0760", "bill_05.bill_bill_0761", "bill_05.bill_bill_0762", "bill_05.bill_bill_0763",
            "bill_05.bill_bill_0764", "bill_05.bill_bill_0765", "bill_06.bill_bill_0800", "bill_06.bill_bill_0801",
            "bill_06.bill_bill_0803"                         };
    /**
     * bill表的policyId与tablename列顺序对应
     */
    public static final String[] BILL_TABLENAME_POLICYIDS     = { "2374220995", "2374220994", "2374220993",
            "2374220992", "2374220990", "2374220989", "2374220988", "2374220987", "2374206440", "2374206434",
            "2374206433", "2374206432", "2374206431", "2374206430", "2374199669", "2374199667", "2374199666",
            "2374199665", "2374206429", "2374206428", "2374217663", "2374217662", "2374217661", "2374217660",
            "2374216323", "2374216322", "2374216321", "2374216320", "2374216318", "2374216317", "2374202376",
            "2374202375", "2374202374", "2374202373", "2374202372", "2374202370", "2374202369", "2374207814",
            "2374202368", "2374207813", "2374202367", "2374207812", "2374202366", "2374207811", "2374207810",
            "2374207809", "2374207808", "2374226785", "2374226784", "2374226783", "2374225448", "2374225447",
            "2374225446", "2374225445", "2374225444", "2374225443", "2374225442", "2374225441", "2374225440",
            "2374211396", "2374211395", "2374211394", "2374211391", "2374211389", "2374222269", "2374222268",
            "2374222266", "2374212688", "2374212687", "2374212686", "2374212685", "2374212684", "2374203710",
            "2374203709", "2374203708", "2374203707", "2374203706", "2374203705", "2374203704", "2374203703",
            "2374231035", "2374231034", "2374231032"         };
    /**
     * bill表中due_date是6月8日对应的policyid
     */
    public static final String[] BILL_DUEDATE_0608_POLICYIDS  = { "2374220995", "2374220994", "2374220993",
            "2374220992", "2374220990", "2374220989", "2374220988", "2374220987", "2374206440", "2374206434",
            "2374206433", "2374206432", "2374206431", "2374206430", "2374199669", "2374199667", "2374199666",
            "2374199665", "2374206429", "2374206428", "2374216323", "2374216322", "2374216321", "2374216320",
            "2374216318", "2374216317", "2374202376", "2374202375", "2374202374", "2374202373", "2374202372",
            "2374202370", "2374202369", "2374202368", "2374202367", "2374202366", "2374225448", "2374225447",
            "2374225446", "2374225445", "2374225444", "2374225443", "2374225442", "2374225441", "2374225440",
            "2374211396", "2374211395", "2374211394", "2374211391", "2374211389" };
    /**
     * bill表中due_date是6月9日对应的policyid
     */
    public static final String[] BILL_DUTEDATE_0609_POLICYIDS = { "2374217663", "2374217662", "2374217661",
            "2374217660", "2374207814", "2374207813", "2374207812", "2374207811", "2374207810", "2374207809",
            "2374207808", "2374226785", "2374226784", "2374226783", "2374222269", "2374222268", "2374222266",
            "2374212688", "2374212687", "2374212686", "2374212685", "2374212684", "2374203710", "2374203709",
            "2374203708", "2374203707", "2374203706", "2374203705", "2374203704", "2374203703", "2374231035",
            "2374231034", "2374231032"                       };

    /**
     * 设置excle中产品机构列和保额、保费的关系
     */
    public static List<ExcelData> setExcelDataMap() {
        Map<String, String> policyRoutMap = setPolicyRoutMap();
        Map<String, String> orgProductCodeExtraMap = setPolicyOrgProductCodeExtra();

        System.out.println("====ORGPRODUCTCODES.length：" + ORGPRODUCTCODES.length);
        System.out.println("====PREMIUMS.length：" + PREMIUMS.length);
        System.out.println("====SUMINSUREDS.length：" + SUMINSUREDS.length);
        //excel中的产品机构列,此处需要注意ORGPRODUCTCODES、PREMIUMS、SUMINSUREDS列的顺序必须一致
        //        Map<String, ExcelData> excelDataMap = new HashMap<String, ExcelData>();
        List<ExcelData> list = new ArrayList<ExcelData>();
        for (int i = 0; i < ORGPRODUCTCODES.length; i++) {
            ExcelData ed = new ExcelData();
            ed.setPremium(PREMIUMS[i].trim());
            ed.setSumInsured(SUMINSUREDS[i].trim());
            ed.setPolicyId(policyRoutMap.get(ORGPRODUCTCODES[i].trim()));
            ed.setPrimaryExpiryDate(orgProductCodeExtraMap.get(ORGPRODUCTCODES[i].trim()));
            ed.setOrgProductCode(ORGPRODUCTCODES[i].trim());
            //            excelDataMap.put(ORGPRODUCTCODES[i].trim(), ed);
            list.add(ed);
        }
        //        return excelDataMap;
        return list;
    }

    /**
     * 设置bill表的tablename和policyid对应
     * 
     * @return
     */
    public static Map<String, String> setBillTableNameAndIdMap() {
        Map<String, String> billTableNamePolicyIdMap = new HashMap<String, String>();
        System.out.println("BILL_TABLENAME_POLICYIDS.length=" + BILL_TABLENAME_POLICYIDS.length);
        System.out.println("BILL_TABLENAMES.length=" + BILL_TABLENAMES.length);
        for (int i = 0; i < BILL_TABLENAME_POLICYIDS.length; i++) {
            billTableNamePolicyIdMap.put(BILL_TABLENAME_POLICYIDS[i].trim(), BILL_TABLENAMES[i].trim());
        }
        return billTableNamePolicyIdMap;
    }

    /**
     * 设置policy表的tablename和policyid对应
     * 
     * @return
     */
    public static Map<String, String> setPolicyTableNameAndIdMap() {
        Map<String, String> tableNamePolicyIdMap = new HashMap<String, String>();
        System.out.println("POLICY_TABLENAME_POLICYIDS.length=" + POLICY_TABLENAME_POLICYIDS.length);
        System.out.println("POLICY_TABLE_NAMES.length=" + POLICY_TABLE_NAMES.length);
        for (int i = 0; i < POLICY_TABLENAME_POLICYIDS.length; i++) {
            tableNamePolicyIdMap.put(POLICY_TABLENAME_POLICYIDS[i].trim(), POLICY_TABLE_NAMES[i].trim());
        }
        return tableNamePolicyIdMap;
    }

    /**
     * 设置policy_rout表中的产品机构代码和policyId的对应关系
     */
    public static Map<String, String> setPolicyRoutMap() {
        System.out.println("====ORGPRODUCTCODE_POLICY_ROUT.length：" + ORGPRODUCTCODE_POLICY_ROUT.length);
        System.out.println("====POLICYIDS.length：" + POLICYIDS.length);
        Map<String, String> policyRoutMap = new HashMap<String, String>();
        for (int i = 0; i < ORGPRODUCTCODE_POLICY_ROUT.length; i++) {
            policyRoutMap.put(ORGPRODUCTCODE_POLICY_ROUT[i].trim(), POLICYIDS[i].trim());
        }
        return policyRoutMap;
    }

    /**
     * 设置policy表中的产品机构和扩展字段中的信息
     * 
     * @return
     */
    public static Map<String, String> setPolicyOrgProductCodeExtra() {
        System.out.println("setPolicyOrgProductCodeExtra->POLICY_ORGPRODUCTCODES.length="
                + POLICY_ORGPRODUCTCODES.length);
        System.out.println("setPolicyOrgProductCodeExtra->POLICY_PRIMARYEXPIRYDATES.length="
                + POLICY_PRIMARYEXPIRYDATES.length);
        Map<String, String> orgProductCodeExtraMap = new HashMap<String, String>();
        for (int i = 0; i < POLICY_ORGPRODUCTCODES.length; i++) {
            orgProductCodeExtraMap.put(POLICY_ORGPRODUCTCODES[i].trim(), POLICY_PRIMARYEXPIRYDATES[i].trim());
        }
        return orgProductCodeExtraMap;
    }

    public static void main(String[] args) {
        List<ExcelData> list = setExcelDataMap();
        Map<String, String> tableNamePolicyIdMap = setPolicyTableNameAndIdMap();
        Map<String, String> billTableNamePolicyIdMap = setBillTableNameAndIdMap();
        System.out.println("list.size:" + list.size());
        //        generatePolicySql(list, tableNamePolicyIdMap);
        //        System.out.println("************************************************************************************");
        //        generateBillSql(list, billTableNamePolicyIdMap);

        getBalanceAmount(list);
        System.out.println(SqlTool2.class.getSimpleName());

    }

    private static void getBalanceAmount(List<ExcelData> list) {
        for (int j = 0; j < BILL_DUEDATE_0608_POLICYIDS.length; j++) {
            for (ExcelData ed : list) {
                if (BILL_DUEDATE_0608_POLICYIDS[j].trim().equals(ed.getPolicyId())) {
                    System.out.println(ed.getPremium());//55398.35
                }
            }
        }
        System.out.println("***********************************************");
        for (int j = 0; j < BILL_DUTEDATE_0609_POLICYIDS.length; j++) {
            for (ExcelData ed : list) {
                if (BILL_DUTEDATE_0609_POLICYIDS[j].trim().equals(ed.getPolicyId())) {
                    System.out.println(ed.getPremium());//39835.13
                }
            }
        }
    }

    /**
     * 生成billsql
     * 
     * @param list
     * @param billTableNamePolicyIdMap
     */
    private static void generateBillSql(List<ExcelData> list, Map<String, String> billTableNamePolicyIdMap) {
        for (ExcelData ed : list) {
            StringBuffer billSqlSb = new StringBuffer("update ").append(billTableNamePolicyIdMap.get(ed.getPolicyId()));
            billSqlSb.append(" set amount='").append(ed.getPremium()).append("',");
            billSqlSb.append("balance_account_id=null,modifier='tengcongcong',gmt_modified=now()").append(" where ");
            billSqlSb.append("policy_id='").append(ed.getPolicyId()).append("'");
            billSqlSb.append(" and pay_type='1';");
            System.out.println(billSqlSb.toString());
        }
    }

    /**
     * 生成policySql
     * 
     * @param list
     * @param tableNamePolicyIdMap
     */
    private static void generatePolicySql(List<ExcelData> list, Map<String, String> tableNamePolicyIdMap) {
        for (ExcelData ed : list) {
            //            System.out.println("value=" + ToStringBuilder.reflectionToString(ed, ToStringStyle.SHORT_PREFIX_STYLE));
            StringBuffer policySqlSb = new StringBuffer("update ").append(tableNamePolicyIdMap.get(ed.getPolicyId()));
            policySqlSb.append(" set sum_insured='").append(ed.getSumInsured()).append("',");
            policySqlSb.append("premium='").append(ed.getPremium()).append("',");
            JSONObject json = new JSONObject();
            json.put("primaryExpiryDate", ed.getPrimaryExpiryDate());
            json.put("primarySumInsured", ed.getSumInsured());
            json.put("primaryPremium", ed.getPremium());
            policySqlSb.append("extra_common_info='").append(json).append("',");
            policySqlSb.append("modifier='tengcongcong',gmt_modified=now()");
            policySqlSb.append(" where id='").append(ed.getPolicyId()).append("'");
            policySqlSb.append(" and insured_id='").append(ed.getOrgProductCode()).append("';");
            System.out.println(policySqlSb.toString());
        }
    }
}

class ExcelData {
    /**
     * excel需要更正成的保额
     */
    private String sumInsured;
    /**
     * excel需要更正成的保费
     */
    private String premium;
    /**
     * policyId
     */
    private String policyId;
    /**
     * policy表中extra_common_info字段中的属性
     */
    private String primaryExpiryDate;
    /**
     * 产品机构代码
     */
    private String orgProductCode;

    public String getOrgProductCode() {
        return orgProductCode;
    }

    public void setOrgProductCode(String orgProductCode) {
        this.orgProductCode = orgProductCode;
    }

    public String getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(String sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPrimaryExpiryDate() {
        return primaryExpiryDate;
    }

    public void setPrimaryExpiryDate(String primaryExpiryDate) {
        this.primaryExpiryDate = primaryExpiryDate;
    }

}
