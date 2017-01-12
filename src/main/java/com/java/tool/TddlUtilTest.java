package com.java.tool;


/**
 * 类TddlUtilTest.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年12月6日 上午10:31:25
 * @version 1.0.0
 */
public class TddlUtilTest {
    public static final String PRODUCT_ID   = "10125";
    public static final String MODIFIER     = "tengcongcong";
    public static final String IS_DELETED_Y = "Y";
    public static final String IS_DELETED_N = "N";

    public static void main(String[] args) {
        //初始化sql参数
        //        SqlParamsDTO sqlDTO = new SqlParamsDTO("365351125", "2733724044", "821241841222922616");

        //        //sql一：还款表
        //        generateRepayMentSql(sqlDTO, "428358", "645846");
        //
        //        //sql二:待追偿表
        //        generateRecoverySql(sqlDTO);

        //sql三:已追偿表
        //注意：数组第一个id是要update amount字段的，第二个试update is_delete字段的id
        String[] subArrayIds = { "103465833", "103280045" };
        //        generateSubrogationSql(sqlDTO, "0.24", subArrayIds);
        //        generateSubrogationSql(sqlDTO, "103280045");

        //sql四:bill表 和billBalance
        String changeValue = null;
        String billId1 = "3194930814-23765067";
        String billId2 = "3427537294-24005013";
        boolean flag = false;
        //        generateBillSql(sqlDTO, flag, changeValue, billId1, billId2);
        //        generateBillSql(sqlDTO, "0.24", "3194930814-23765067", "3427537294-24005013");

    }

    /**
     * 生成billSql is_delete="Y"
     * 
     * @param sqlDTO
     * @param changeValue
     * @param billIds 此参数如果是一个表示不生成update amount的sql语句，如果是两个
     *            则第二个参数存的是生成amount语句所需的billId 和balanceId
     */
    private static void generateBillSql(SqlParamsDTO sqlDTO, boolean flag, String changeValue, String... billIds) {
        String tableName = TddlUtil.getTbAndDbname("bill_bill", "bill", sqlDTO.getPolicyId(), 8, 1024 / 8);
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append("update ").append(tableName).append("set is_deleted='").append(IS_DELETED_Y).append("',");
        sqlSb.append("balance_account_id=null,");
        sqlSb.append("gmt_modified=now(),modifier='").append(MODIFIER).append("' ");
        sqlSb.append("where product_id='").append(PRODUCT_ID).append("' ");
        sqlSb.append("and pay_type='4' ").append("and is_deleted='").append(IS_DELETED_N).append("' ");
        sqlSb.append("and policy_id='").append(sqlDTO.getPolicyId()).append("' ");
        sqlSb.append("and balance_account_id='").append(billIds[0].split("-")[1]).append("' ");
        sqlSb.append("and id='").append(billIds[0].split("-")[0]).append("';");
        System.out.println(sqlSb.toString());

        generateBalanceSql(sqlDTO, changeValue, billIds[0]);

        if (flag) {
            generateBillSql(sqlDTO, changeValue, billIds[1]);
        }
    }

    private static void generateBalanceSql(SqlParamsDTO sqlDTO, String changeValue, String billIds) {
        String tableBalance = TddlUtil.getTbAndDbname("bill_balance_bill", "bill", sqlDTO.getPolicyId(), 8, 1024 / 8);
        StringBuilder sqlBalance = new StringBuilder();
        sqlBalance.append("update ").append(tableBalance).append("set amount=amount-").append(changeValue).append(",");
        sqlBalance.append("trade_count=trade_count-1, ");
        sqlBalance.append("gmt_modified=now(),modifier='").append(MODIFIER).append("' ");
        sqlBalance.append("where product_id='").append(PRODUCT_ID).append("' ");
        sqlBalance.append("and id='").append(billIds.split("-")[0]).append("';");
        System.out.println(sqlBalance.toString());
    }

    private static void generateBillSql(SqlParamsDTO sqlDTO, String changeValue, String billId) {
        String tableName = TddlUtil.getTbAndDbname("bill_bill", "bill", sqlDTO.getPolicyId(), 8, 1024 / 8);
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append("update ").append(tableName).append("set amount=amount-").append(changeValue).append(",");
        sqlSb.append("gmt_modified=now(),modifier='").append(MODIFIER).append("' ");
        sqlSb.append("where product_id='").append(PRODUCT_ID).append("' ");
        sqlSb.append("and pay_type='4' ");
        sqlSb.append("and policy_id='").append(sqlDTO.getPolicyId()).append("' ");
        sqlSb.append("and balance_account_id='").append(billId.split("-")[1]).append("' ");
        sqlSb.append("and id='").append(billId.split("-")[0]).append("';");
        System.out.println(sqlSb.toString());

        generateBalanceSql(sqlDTO, changeValue, billId);
    }

    /**
     * 生成已追偿记录
     * 
     * @param sqlDTO
     * @param subArrayIds
     */
    private static void generateSubrogationSql(SqlParamsDTO sqlDTO, String id) {
        String tableName = TddlUtil.getTbAndDbname("claim_subrogation", "claim", sqlDTO.getPolicyId(), 4, 64 / 4);
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append("update ").append(tableName).append("set is_deleted='").append(IS_DELETED_Y).append("',");
        sqlSb.append("gmt_modified=now(),modifier='").append(MODIFIER).append("' ");
        sqlSb.append("where policy_id='").append(sqlDTO.getPolicyId()).append("' ");
        sqlSb.append("and is_deleted='").append(IS_DELETED_N).append("' ");
        sqlSb.append("and id='").append(id).append("';");
        System.out.println(sqlSb.toString());
    }

    /**
     * 生成已追偿记录 2个月都逾期的差额sql
     * 
     * @param sqlDTO
     * @param subArrayIds
     */
    private static void generateSubrogationSql(SqlParamsDTO sqlDTO, String changeValue, String... ids) {
        String tableName = TddlUtil.getTbAndDbname("claim_subrogation", "claim", sqlDTO.getPolicyId(), 4, 32);
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append("update ").append(tableName).append("set amount=amount-").append(changeValue).append(",");
        sqlSb.append("gmt_modified=now(),modifier='").append(MODIFIER).append("' ");
        sqlSb.append("where policy_id='").append(sqlDTO.getPolicyId()).append("' ");
        sqlSb.append("and id='").append(ids[0]).append("';");
        System.out.println(sqlSb.toString());
        generateSubrogationSql(sqlDTO, ids[1]);
    }

    /**
     * 待追偿表sql
     * 
     * @param sqlDTO
     */
    private static void generateRecoverySql(SqlParamsDTO sqlDTO) {
        String tableName = TddlUtil.getTbAndDbname("cp_recovery", "creditproduct", PRODUCT_ID, 4, 64 / 4);
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append("update ").append(tableName).append("set recovery_amount='0.00',");
        sqlSb.append("gmt_modified=now(),modifier='").append(MODIFIER).append("' ");
        sqlSb.append("where product_id='").append(PRODUCT_ID).append("' ");
        sqlSb.append("and policy_no='").append(sqlDTO.getPolicyNo()).append("';");
        System.out.println(sqlSb.toString());

    }

    /**
     * 生成还款表的sql
     * 
     * @param sqlDTO
     * @param ids 可变参数id
     * @return
     */
    private static void generateRepayMentSql(SqlParamsDTO sqlDTO, String... ids) {
        String tableName = TddlUtil.getTbAndDbname("cp_repayment", "creditproduct", sqlDTO.getUserId(), 4, 64 / 4);
        for (String id : ids) {
            StringBuilder sb = new StringBuilder();
            sb.append("update ").append(tableName).append("set ");
            sb.append("is_deleted='Y',gmt_modified=now(),modifier='tengcongcong'");
            sb.append(" where ").append("product_id='").append(PRODUCT_ID);
            sb.append("' and is_deleted='").append(IS_DELETED_N).append("'");
            sb.append(" and id='").append(id).append("';");
            System.out.println(sb.toString());
        }
    }
}

class SqlParamsDTO {
    private String userId;
    private String policyId;
    private String policyNo;
    private String requirementNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRequirementNo() {
        return requirementNo;
    }

    public void setRequirementNo(String requirementNo) {
        this.requirementNo = requirementNo;
    }

}
