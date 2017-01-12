package com.java.http.examples;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * @ClassName: ParamMap
 * @Description: 参数传递工具类
 * @author 冰水华川 QQ757225051
 * @date 2014-7-15 14:15:34
 */
public class ParamMap implements Map<String,Object> {
	private HashMap<String,Integer> intMap=new HashMap<String,Integer>();
	private HashMap<String,Boolean> booleanMap=new HashMap<String,Boolean>();
	private HashMap<String,Double> doubleMap=new HashMap<String,Double>();
	private HashMap<String,Long> longMap=new HashMap<String,Long>();
	private HashMap<String,Byte> byteMap=new HashMap<String,Byte>();
	private HashMap<String,Character> charMap=new HashMap<String,Character>();
	private HashMap<String,Date> dateMap=new HashMap<String,Date>();
	private HashMap<String,String> map=new HashMap<String,String>();
	@Override
	public int size() {
		int result=intMap.size()+booleanMap.size()+doubleMap.size()+
			longMap.size()+byteMap.size()+charMap.size()+dateMap.size()+map.size();
		return result;
	}

	@Override
	public boolean isEmpty() {
		if(size()==0){
			return true;
		}
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		if(map.containsKey(key)){
			return true;
		}
		if(intMap.containsKey(key)){
			return true;
		}
		if(booleanMap.containsKey(key)){
			return true;
		}
		if(doubleMap.containsKey(key)){
			return true;
		}
		if(longMap.containsKey(key)){
			return true;
		}
		if(byteMap.containsKey(key)){
			return true;
		}
		if(charMap.containsKey(key)){
			return true;
		}
		if(dateMap.containsKey(key)){
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		if(map.containsKey(value)){
			return true;
		}
		if(intMap.containsKey(value)){
			return true;
		}
		if(booleanMap.containsKey(value)){
			return true;
		}
		if(doubleMap.containsKey(value)){
			return true;
		}
		if(longMap.containsKey(value)){
			return true;
		}
		if(byteMap.containsKey(value)){
			return true;
		}
		if(charMap.containsKey(value)){
			return true;
		}
		if(dateMap.containsKey(value)){
			return true;
		}
		return false;
	}

	@Override
	public Object get(Object key) {
		Object result=map.get(key);
		if(result!=null){
			return result;
		}
		result=intMap.get(key);
		if(result!=null){
			return result;
		}
		result=booleanMap.get(key);
		if(result!=null){
			return result;
		}
		result=doubleMap.get(key);
		if(result!=null){
			return result;
		}
		result=longMap.get(key);
		if(result!=null){
			return result;
		}
		result=byteMap.get(key);
		if(result!=null){
			return result;
		}
		result=charMap.get(key);
		if(result!=null){
			return result;
		}
		result=dateMap.get(key);
		if(result!=null){
			return result;
		}
		return null;
	}
	public String getStr(String key) {
		String result= map.get(key);
		if(result!=null){
			return result;
		}
		Integer intResult= intMap.get(key);
		if(intResult!=null){
			return intResult+"";
		}
		Boolean booleanResult= booleanMap.get(key);
		if(booleanResult!=null){
			return booleanResult+"";
		}
		Double doubleResult= doubleMap.get(key);
		if(doubleResult!=null){
			return doubleResult+"";
		}
		Long longResult= longMap.get(key);
		if(longResult!=null){
			return longResult+"";
		}
		Byte byteResult=byteMap.get(key);
		if(byteResult!=null){
			return byteResult+"";
		}
		Character charResult= charMap.get(key);
		if(charResult!=null){
			return charResult+"";
		}
		Date dateResult= dateMap.get(key);
		if(dateResult!=null){
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(dateResult);
		}
		return null;
	}
	public Integer getInt(String key) {
		Integer intValue=intMap.get(key);
		if(intValue!=null){
			return intValue;
		}
		String strValue=map.get(key);
		if(strValue!=null){
			try {
				return Integer.parseInt(strValue);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public Boolean getBoolean(String key) {
		Boolean booleanValue=booleanMap.get(key);
		if(booleanValue!=null){
			return booleanValue;
		}
		String strValue=map.get(key);
		if(strValue!=null){
			if("true".equals(strValue)){
				return true;
			}else if("false".equals(strValue)){
				return false;
			}
		}
		return null;
	}
	public Double getDouble(String key) {
		Double doubleValue=doubleMap.get(key);
		if(doubleValue!=null){
			return doubleValue;
		}
		String strValue=map.get(key);
		if(strValue!=null){
			try {
				return Double.parseDouble(strValue);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public Long getLong(String key) {
		Long longValue=longMap.get(key);
		if(longValue!=null){
			return longValue;
		}
		String strValue=map.get(key);
		if(strValue!=null){
			try {
				return Long.parseLong(strValue);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public Byte getByte(String key) {
		Byte byteValue=byteMap.get(key);
		if(byteValue!=null){
			return byteValue;
		}
		String strValue=map.get(key);
		if(strValue!=null){
			try {
				return Byte.parseByte(strValue);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public Character getChar(String key) {
		Character charValue=charMap.get(key);
		if(charValue!=null){
			return charValue;
		}
		String strValue=map.get(key);
		if(strValue!=null&&strValue.length()==1){
			return strValue.charAt(0);
		}
		return null;
	}
	public Date getDate(String key) {
		Date dateValue=dateMap.get(key);
		if(dateValue!=null){
			return dateValue;
		}
		String strValue=map.get(key);
		if(strValue!=null){
			strValue=strValue.replace(".", "-");
			strValue=strValue.replace("/", "-");
			strValue=strValue.replace("年", "-");
			strValue=strValue.replace("月", "-");
			strValue=strValue.replace("日", "");
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(strValue);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public Object put(String key, Object value) {
		if(value instanceof String){
			map.put(key, (String)value);
		}else if(value instanceof Integer){
			intMap.put(key, (Integer)value);
		}else if(value instanceof Boolean){
			booleanMap.put(key, (Boolean)value);
		}else if(value instanceof Double){
			doubleMap.put(key, (Double)value);
		}else if(value instanceof Long){
			longMap.put(key, (Long)value);
		}else if(value instanceof Byte){
			byteMap.put(key, (Byte)value);
		}else if(value instanceof Character){
			charMap.put(key, (Character)value);
		}else if(value instanceof Date){
			dateMap.put(key, (Date)value);
		}
		return value;
	}
	public Object put(String key, String value) {
		return map.put(key, value);
	}
	public Object put(String key, Integer value) {
		return intMap.put(key, value);
	}
	public Object put(String key, Boolean value) {
		return booleanMap.put(key, value);
	}
	public Object put(String key, Double value) {
		return doubleMap.put(key, value);
	}
	public Object put(String key, Long value) {
		return longMap.put(key, value);
	}
	public Object put(String key, Byte value) {
		return byteMap.put(key, value);
	}
	public Object put(String key, Character value) {
		return charMap.put(key, value);
	}
	public Object put(String key, Date value) {
		return dateMap.put(key, value);
	}
	@Override
	public Object remove(Object key) {
		if(map.containsKey(key)){
			return map.remove(key);
		}
		if(intMap.containsKey(key)){
			return intMap.remove(key);
		}
		if(booleanMap.containsKey(key)){
			return booleanMap.remove(key);
		}
		if(doubleMap.containsKey(key)){
			return doubleMap.remove(key);
		}
		if(longMap.containsKey(key)){
			return longMap.remove(key);
		}
		if(byteMap.containsKey(key)){
			return byteMap.remove(key);
		}
		if(charMap.containsKey(key)){
			return charMap.remove(key);
		}
		if(dateMap.containsKey(key)){
			return dateMap.remove(key);
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		Set<? extends String>keys=m.keySet();
		Iterator<? extends String>ite=keys.iterator();
		while(ite.hasNext()){
			String key=ite.next();
			Object value=m.get(key);
			if(value instanceof String){
				map.put(key,(String)value);
			}else if(value instanceof Integer){
				intMap.put(key,(Integer)value);
			}else if(value instanceof Boolean){
				booleanMap.put(key,(Boolean)value);
			}else if(value instanceof Double){
				doubleMap.put(key,(Double)value);
			}else if(value instanceof Long){
				longMap.put(key,(Long)value);
			}else if(value instanceof Byte){
				byteMap.put(key,(Byte)value);
			}else if(value instanceof Character){
				charMap.put(key,(Character)value);
			}else if(value instanceof Date){
				dateMap.put(key,(Date)value);
			}
		}
	}
	@Override
	public void clear() {
		if(!map.isEmpty()){
			map.clear();
		}
		if(!intMap.isEmpty()){
			intMap.clear();
		}
		if(!booleanMap.isEmpty()){
			booleanMap.clear();
		}
		if(!doubleMap.isEmpty()){
			doubleMap.clear();
		}
		if(!longMap.isEmpty()){
			longMap.clear();
		}
		if(!byteMap.isEmpty()){
			byteMap.clear();
		}
		if(!charMap.isEmpty()){
			charMap.clear();
		}
		if(!dateMap.isEmpty()){
			dateMap.clear();
		}
		
	}

	@Override
	public Set<String> keySet() {
		Set<String>result=new HashSet<String>();
		Iterator<String>ite=null;
		Set<String>keySet=null;
		keySet=map.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=intMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=intMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=intMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=intMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=booleanMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=doubleMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=longMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=byteMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=charMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		keySet=dateMap.keySet();
		ite=keySet.iterator();
		while(ite.hasNext()){
			result.add(ite.next());
		}
		return result;
	}

	@Override
	public Collection<Object> values() {
		Collection<Object>result=new ArrayList<Object>();
		Collection<String>coll=map.values();
		for (String val : coll) {
			result.add(val);
		}
		Collection<Integer>IntColl=intMap.values();
		for (Integer val : IntColl) {
			result.add(val);
		}
		Collection<Boolean>booleanColl=booleanMap.values();
		for (Boolean val : booleanColl) {
			result.add(val);
		}
		Collection<Double>doubleColl=doubleMap.values();
		for (Double val : doubleColl) {
			result.add(val);
		}
		Collection<Long>longColl=longMap.values();
		for (Long val : longColl) {
			result.add(val);
		}
		Collection<Byte>byteColl=byteMap.values();
		for (Byte val : byteColl) {
			result.add(val);
		}
		Collection<Character>charColl=charMap.values();
		for (Character val : charColl) {
			result.add(val);
		}
		Collection<Date>dateColl=dateMap.values();
		for (Date val : dateColl) {
			result.add(val);
		}
		return result;
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		Map<String,Object>result=new HashMap<String,Object>();
		Set<Entry<String, String>> entry=map.entrySet();
		Iterator<Entry<String, String>>ite=entry.iterator();
		while(ite.hasNext()){
			Entry<String, String>strEntry=ite.next();
			String key=strEntry.getKey();
			String value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Integer>> intEntry=intMap.entrySet();
		Iterator<Entry<String, Integer>>intIte=intEntry.iterator();
		while(intIte.hasNext()){
			Entry<String, Integer>strEntry=intIte.next();
			String key=strEntry.getKey();
			Integer value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Boolean>> booleanEntry=booleanMap.entrySet();
		Iterator<Entry<String, Boolean>>booleanIte=booleanEntry.iterator();
		while(booleanIte.hasNext()){
			Entry<String, Boolean>strEntry=booleanIte.next();
			String key=strEntry.getKey();
			Boolean value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Double>> doubleEntry=doubleMap.entrySet();
		Iterator<Entry<String, Double>>doubleIte=doubleEntry.iterator();
		while(doubleIte.hasNext()){
			Entry<String, Double>strEntry=doubleIte.next();
			String key=strEntry.getKey();
			Double value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Long>> longEntry=longMap.entrySet();
		Iterator<Entry<String, Long>>longIte=longEntry.iterator();
		while(longIte.hasNext()){
			Entry<String, Long>strEntry=longIte.next();
			String key=strEntry.getKey();
			Long value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Byte>> byteEntry=byteMap.entrySet();
		Iterator<Entry<String, Byte>>byteIte=byteEntry.iterator();
		while(byteIte.hasNext()){
			Entry<String, Byte>strEntry=byteIte.next();
			String key=strEntry.getKey();
			Byte value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Character>> charEntry=charMap.entrySet();
		Iterator<Entry<String, Character>>charIte=charEntry.iterator();
		while(charIte.hasNext()){
			Entry<String, Character>strEntry=charIte.next();
			String key=strEntry.getKey();
			Character value=strEntry.getValue();
			result.put(key, value);
		}
		Set<Entry<String, Date>> dateEntry=dateMap.entrySet();
		Iterator<Entry<String, Date>>dateIte=dateEntry.iterator();
		while(dateIte.hasNext()){
			Entry<String, Date>strEntry=dateIte.next();
			String key=strEntry.getKey();
			Date value=strEntry.getValue();
			result.put(key, value);
		}
		return result.entrySet();
	}
	public String toString(){
		StringBuilder sb=new StringBuilder("ParamMap[");
		Set<Entry<String, String>> entry=map.entrySet();
		Iterator<Entry<String, String>>ite=entry.iterator();
		while(ite.hasNext()){
			Entry<String, String>strEntry=ite.next();
			String key=strEntry.getKey();
			String value=strEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");	
		}
		Set<Entry<String, Integer>> intEntrySum=intMap.entrySet();
		Iterator<Entry<String, Integer>>intIte=intEntrySum.iterator();
		while(intIte.hasNext()){
			Entry<String, Integer>intEntry=intIte.next();
			String key=intEntry.getKey();
			Integer value=intEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");
		}
		Set<Entry<String, Boolean>> booleanEntrySum=booleanMap.entrySet();
		Iterator<Entry<String, Boolean>>booleanIte=booleanEntrySum.iterator();
		while(booleanIte.hasNext()){
			Entry<String, Boolean>booleanEntry=booleanIte.next();
			String key=booleanEntry.getKey();
			Boolean value=booleanEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");
		}
		Set<Entry<String, Double>> doubleEntrySum=doubleMap.entrySet();
		Iterator<Entry<String, Double>>doubleIte=doubleEntrySum.iterator();
		while(doubleIte.hasNext()){
			Entry<String, Double>doubleEntry=doubleIte.next();
			String key=doubleEntry.getKey();
			Double value=doubleEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");
		}
		Set<Entry<String, Long>> longEntrySum=longMap.entrySet();
		Iterator<Entry<String, Long>>longIte=longEntrySum.iterator();
		while(longIte.hasNext()){
			Entry<String, Long>longEntry=longIte.next();
			String key=longEntry.getKey();
			Long value=longEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");
		}
		Set<Entry<String, Byte>> byteEntrySum=byteMap.entrySet();
		Iterator<Entry<String, Byte>>byteIte=byteEntrySum.iterator();
		while(byteIte.hasNext()){
			Entry<String, Byte>byteEntry=byteIte.next();
			String key=byteEntry.getKey();
			Byte value=byteEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");
		}
		Set<Entry<String, Character>> charEntrySum=charMap.entrySet();
		Iterator<Entry<String, Character>>charIte=charEntrySum.iterator();
		while(charIte.hasNext()){
			Entry<String, Character>charEntry=charIte.next();
			String key=charEntry.getKey();
			Character value=charEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(value);
			sb.append(",");
		}
		Set<Entry<String, Date>> dateEntrySum=dateMap.entrySet();
		Iterator<Entry<String, Date>>dateIte=dateEntrySum.iterator();
		while(dateIte.hasNext()){
			Entry<String, Date>dateEntry=dateIte.next();
			String key=dateEntry.getKey();
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
			Date value=dateEntry.getValue();
			sb.append(key);
			sb.append("=");
			sb.append(sdf.format(value));
			sb.append(",");
		}
		if(size()!=0){
			sb.delete(sb.length()-1, sb.length());
		}
		sb.append("]");
		return sb.toString();
	}
}

