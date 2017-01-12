package com.java.String;

import static org.junit.Assert.*;

import java.net.URLEncoder;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 验证字符串
 * @author zhangy
 *
 */
public class ValidateString {

	
	@Test
	public void testName() throws Exception {
		System.out.println(URLEncoder.encode("/帮助中心/文本/常见问题","UTF-8"));
	}
	@Test
	public void testChinaese() throws Exception {
		 String[] strArr = new String[] { "www.micmiu.com", "!@#$%^&*()_+{}[]|\"'?/:;<>,.", "！￥……（）——：；“”‘’《》，。？、", "不要啊", "やめて", "韩佳人", "???" };
		 for (String str : strArr) {
	            System.out.println("===========> 测试字符串：" + str);
	            System.out.println("Unicode判断结果 ：" + isChinese(str));
	            
	     }
		 
		 String str="张事实上事实上吧吧";
		 System.out.println(str.length()>8?str+"，大于8个字符":str+"，小于等于8个字符");
	}
	
	@Test
	public void testStringLength() throws Exception {
		String name="张三三";
		System.out.println("length:"+name.length());
	}
	/**
	 * 验证中文姓名（包括少数名族姓名中的"·"）
	 * @throws Exception
	 */
	@Test
	public void testChinaName() throws Exception {
		//[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*
//		String chinaName="阿沛·张三·阿旺晋美";
//		String chinaName="阿沛·吧·三·阿旺晋美";
		String chinaName="张三··李四·旺旺";
		String regex="[\u4E00-\u9FA5]+(?:·[\u4E00-\u9FA5]+)*";
		boolean bool=Pattern.matches(regex, chinaName);
		System.out.println("result="+bool);
	}
	  /**
     * 判断单独字符是否是中文
     *
     * @param c
     * @return
     */
    private boolean isChineseChar(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    /**
     * 完整的判断中文汉字和符号
     *
     * @param strName
     * @return
     */
    public boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!isChineseChar(c)) {
                return false;
            }
            if (isChinesePunctuation(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否是中文字符
     *
     * @param c
     * @return
     */
    public boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        } else {
            return false;
        }
    }

    @Test
	public void testBb() throws Exception {
    	System.out.println("{\"mimeType\":\"aaaa\",\"size\":\"bbb\"}".length());
	}
    
    @Test
	public void testAiliPath() throws Exception {
		String path="/房屋买卖贷/借款人信息/身份证";
		System.out.println(path.startsWith("/"));
		if(path.startsWith("/")){
			path=path.substring(1);
			System.out.println("截取后:"+path);
		}else{
			System.out.println("无需截取:"+path);
		}
	}
}
