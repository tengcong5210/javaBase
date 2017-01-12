package com.java.tool;

public class TddlUtil {
    /**
     * 获取表名
     * 
     * @param tableName 表名
     * @param dbName 库名
     * @param divValue 分库表字段 比如:policy_id
     * @param dbCount 库的数量
     * @param tableCount 表的数量 表数量要除以库的数量，因为Integer tableValue = idivValue %
     *            (dbCount * tableCount); 会用库*表 所以要先除才可以
     * @return
     */
    public static String getTbAndDbname(String tableName, String dbName, String divValue, Integer dbCount,
                                        Integer tableCount) {
        int idivValue = Math.abs(divValue.hashCode());
        //System.out.println(divValue);

        Integer tableValue = idivValue % (dbCount * tableCount);
        String tableValueStr = leftPad(tableValue, 4, '0');

        Integer dbValue = tableValue / tableCount;
        String dbValueStr = leftPad(dbValue, 2, '0');

        StringBuffer sb = new StringBuffer();
        sb.append(dbName + "_" + dbValueStr);
        sb.append("." + tableName + "_" + tableValueStr + " ");
        return sb.toString();
    }

    private static String leftPad(int num, final int maxLen, char filledChar) {
        StringBuffer sb = new StringBuffer();
        String str = String.valueOf(num);
        for (int i = str.length(); i < maxLen; i++) {
            sb.append(filledChar);
        }
        return sb.append(str).toString();
    }

    public static void main(String[] args) {
        //claim_subrogation_01.claim_0024
        //claim_01.claim_subrogation_0024
        System.out.println(TddlUtil.getTbAndDbname("claim_subrogation", "claim", "2960144943", 4, 64 / 4));
        System.out.println(TddlUtil.getTbAndDbname("bill_bill", "bill", "2960144943", 8, 1024 / 8));
        System.out.println(TddlUtil.getTbAndDbname("bill_balance_bill", "bill", "10125", 4, 8 / 4));
    }
}
