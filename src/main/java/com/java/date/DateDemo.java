package com.java.date;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void dateTest1() {
        long gmt = 0;//格林威治时间 1970/01/01

        Date date = new Date();
        date.setTime(gmt);//回到1970 元旦,相当于long -->Date
        System.out.println(date.getYear() + 1900);//1970

        Calendar cal = new GregorianCalendar();
        //date --> cal
        cal.setTime(date);//将cal设置为date的时间,也是1970
        System.out.println(cal.get(Calendar.YEAR));//1970
        //date 和 cal ,gmt 代表同一时刻
        //加-1天，是在当前时间上加-1天，就是减少1天，就是减少1天的毫秒数(1000*60*60*24)
        cal.add(Calendar.DAY_OF_YEAR, -1);
        Date d = cal.getTime();
        System.out.println(d);//1969
        long l = d.getTime();
        System.out.println(l);//-86400000,因为是在原点以前的时间
    }

    public void testDate() throws ParseException {
        //逾期日：min(约定还款日+1日0:00,保单止期)
        Calendar contractRepayDateCal = Calendar.getInstance();
        contractRepayDateCal.setTime(new Date());
        contractRepayDateCal.set(Calendar.DAY_OF_MONTH, contractRepayDateCal.get(Calendar.DAY_OF_MONTH) + 1);
        contractRepayDateCal.set(Calendar.HOUR_OF_DAY, 0);
        contractRepayDateCal.set(Calendar.MINUTE, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddhhmmss");
        String reportDate = "20150128000000";
        System.out.println("bb:" + sdf2.parse(reportDate));
        System.out.println("cc:" + sdf.format(sdf2.parse(reportDate)));
        System.out.println("aa:" + sdf.format(contractRepayDateCal.getTime()));
    }

    /**
     * 当期日期加减月，当期日期加减日
     */
    private void testDateAdd() {
        //        DateUtil.getDateWithoutTime 设置日期的时分秒毫秒为00
        System.out.println("adjustDay:"
                + DateUtil.formatDateDefault(DateUtil.getDateWithoutTime(DateUtil.adjustDay(new Date(), 7))));
        System.out.println("adjustMonth:"
                + DateUtil.formatDateDefault(DateUtil.getDateWithoutTime(DateUtil.adjustMonth(new Date(), 7))));
        System.out.println("adjustYear:"
                + DateUtil.formatDateDefault(DateUtil.getDateWithoutTime(DateUtil.adjustYear(new Date(), 10))));
    }

    /**
     * 时间戳转化为Sting或Date
     * 
     * @throws ParseException
     */
    @Test
    public void timeConvertDate() throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        Long time = new Long(1429545600000L);//借款到期日
        Long time = new Long(1463382269000L);//借款到期日
        Long time2 = new Long(1445581142000L);//借款到期日
        Long time3 = new Long(1480319435000L);//借款到期日
        String d = format.format(time);
        String d2 = format.format(time2);
        String d3 = format.format(time3);
        Date date = format.parse(d);
        System.out.println("d1::" + d);
        System.out.println("d2:" + d2);
        System.out.println("d3:" + d3);
        System.out.println("Format To Date:" + date);
        System.out.println("==========:" + new Date().getTime());
        Long agreeLoanDate = new Long(1445097600 * 1000l);
        String agree = format.format(agreeLoanDate);
        System.out.println("约定放款日:" + agree);
    }

    /**
     * 日期差
     */
    @Test
    public void testDateCha() {
        Date date1 = DateUtil.parseDate("2017-08-10", DateUtil.ZH_CN_DATE_PATTERN);//借款申请日期
        Date date2 = DateUtil.parseDate("2018-06-10", DateUtil.ZH_CN_DATE_PATTERN);//额度有效期
        int chaYear = DateUtil.getDateDistance(date1, date2, DateUtil.ACCURACY_YEAR);//日期相差天数
        System.out.println("testDateCha-Result:" + chaYear);
        int compareYear=1;
        if(chaYear<compareYear){
            System.out.println("true");
        }else{
            System.out.println("flase");
        }
    }

    /**
     * 日期比较
     */
    @Test
    public void testCompareDate() {
        System.out.println("testCompareDate(start)"+(new Date().getTime()));
        String guohudate = "2015-08-23";
        System.out.println(DateUtil.parseDate(guohudate));
        Date date = DateUtil.adjustDay(new Date(), 8);//申请日期
        Date date222 = DateUtil.adjustDay(DateUtil.parseDate(guohudate), 23);//过户日期
        System.out.println("过户日期:" + DateUtil.formatDateDefault(date222));
        Date amountInvalidDate = DateUtil.parseDate("20150827235959", DateUtil.NOMARK_DATETIME_PATTERN);
        System.out.println("end:" + DateUtil.formatDateDefault(amountInvalidDate));
        System.out.println("testCompareDate(end),rueslt:" + date.compareTo(amountInvalidDate));

    }

    @Test
    public void testFromatDate() {
    	Date startDate=DateUtil.parseDate("2016-07-03");
    	Date endDate=DateUtil.parseDate("2016-07-04");
    	BigDecimal time = new BigDecimal((startDate.getTime() - endDate.getTime()) / (24 * 60 * 60 * 1000 * 1.0)+"");
    	long endtime = Long.parseLong(new java.text.DecimalFormat("0").format(time));
    	System.out.println("endTime="+endtime);
	}
	@Test
	public void testDateAddx(){
        Date startDate=DateUtil.parseDate("2017-06-04");
        Date restDate=DateUtil.adjustDay(startDate,100);
        System.out.println("restDate="+DateUtil.formatDateDefault(restDate));
    }
    
    private void getDateMonth(Date date) {
        int month = date.getMonth() + 1;
        System.out.println("month:" + month);
    }

    @Test
    public void testGetYear() throws Exception {
        Date loanApplyDate = DateUtil.parseDate("20140806193900", DateUtil.NOMARK_DATETIME_PATTERN);//借款申请日期
        System.out.println("当前年份:" + DateUtil.getYear(loanApplyDate));
    }
}
